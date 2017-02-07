/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 *
 * @author 4E
 */
class Rent
  implements SystemTypes
{
  private String borrowing_date; // internal
  private String return_date; // internal
  private int rentID; // internal
  private Reader reader;
  private HashSet books = new HashSet(); // of Book

  public Rent(Reader reader)
  {
    this.borrowing_date = "";
    this.return_date = "";
    this.rentID = 0;
    this.reader = reader;

  }

  public Rent() { }



  public String toString()
  { String _res_ = "(Rent) ";
    _res_ = _res_ + borrowing_date + ",";
    _res_ = _res_ + return_date + ",";
    _res_ = _res_ + rentID;
    return _res_;
  }

  public void setborrowing_date(String borrowing_date_x) { borrowing_date = borrowing_date_x;  }


    public static void setAllborrowing_date(Collection rent_s,String val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().setborrowing_date(rent_x,val); } }


  public void setreturn_date(String return_date_x) { return_date = return_date_x;  }


    public static void setAllreturn_date(Collection rent_s,String val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().setreturn_date(rent_x,val); } }


  public void setrentID(int rentID_x) { rentID = rentID_x;  }


    public static void setAllrentID(Collection rent_s,int val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().setrentID(rent_x,val); } }


  public void setreader(Reader reader_xx) { reader = reader_xx;
  }

  public static void setAllreader(Collection rent_s,Reader _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().setreader(rent_x, _val); } }

  public void setbooks(HashSet books_xx) { books = books_xx;
    }
 
  public void addbooks(Book books_xx) { books.add(books_xx);
    }
 
  public void removebooks(Book books_xx) { books.remove(books_xx);
    }

  public static void setAllbooks(Collection rent_s,HashSet _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().setbooks(rent_x, _val); } }

  public static void addAllbooks(Collection rent_s,Book _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().addbooks(rent_x, _val); } }


  public static void removeAllbooks(Collection rent_s,Book _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().removebooks(rent_x, _val); } }


  public static void unionAllbooks(Collection rent_s, HashSet _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().unionbooks(rent_x, _val); } }


  public static void subtractAllbooks(Collection rent_s, HashSet _val)
  { for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      Controller.inst().subtractbooks(rent_x, _val); } }


    public String getborrowing_date() { return borrowing_date; }

    public static HashSet getAllborrowing_date(Collection rent_s)
  { HashSet result = new HashSet();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getborrowing_date()); }
    return result; }

    public static ArrayList getAllOrderedborrowing_date(Collection rent_s)
  { ArrayList result = new ArrayList();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getborrowing_date()); } 
    return result; }

    public String getreturn_date() { return return_date; }

    public static HashSet getAllreturn_date(Collection rent_s)
  { HashSet result = new HashSet();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getreturn_date()); }
    return result; }

    public static ArrayList getAllOrderedreturn_date(Collection rent_s)
  { ArrayList result = new ArrayList();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getreturn_date()); } 
    return result; }

    public int getrentID() { return rentID; }

    public static HashSet getAllrentID(Collection rent_s)
  { HashSet result = new HashSet();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(new Integer(rent_x.getrentID())); }
    return result; }

    public static ArrayList getAllOrderedrentID(Collection rent_s)
  { ArrayList result = new ArrayList();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(new Integer(rent_x.getrentID())); } 
    return result; }

  public Reader getreader() { return reader; }

  public static HashSet getAllreader(Collection rent_s)
  { HashSet result = new HashSet();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getreader()); }
    return result; }

  public static ArrayList getAllOrderedreader(Collection rent_s)
  { ArrayList result = new ArrayList();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.add(rent_x.getreader()); }
    return result; }

  public HashSet getbooks() { return (HashSet) ((HashSet) books).clone(); }

  public static HashSet getAllbooks(Collection rent_s)
  { HashSet result = new HashSet();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.addAll(rent_x.getbooks()); }
    return result; }

  public static ArrayList getAllOrderedbooks(Collection rent_s)
  { ArrayList result = new ArrayList();
    for (Object _o : rent_s)
    { Rent rent_x = (Rent) _o;
      result.addAll(rent_x.getbooks()); }
    return result; }


}
