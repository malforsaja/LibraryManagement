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
class Author implements SystemTypes
{
  private String fName; // internal
  private String lName; // internal
  private String gender; // internal
  private String dob; // internal
  private HashSet books = new HashSet(); // of Book

  public Author()
  {
    this.fName = "";
    this.lName = "";
    this.gender = "";
    this.dob = "";

  }



  public String toString()
  { String _res_ = "(Author) ";
    _res_ = _res_ + fName + ",";
    _res_ = _res_ + lName + ",";
    _res_ = _res_ + gender + ",";
    _res_ = _res_ + dob;
    return _res_;
  }

  public void setfName(String fName_x) { fName = fName_x;  }


    public static void setAllfName(Collection author_s,String val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().setfName(author_x,val); } }


  public void setlName(String lName_x) { lName = lName_x;  }


    public static void setAlllName(Collection author_s,String val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().setlName(author_x,val); } }


  public void setgender(String gender_x) { gender = gender_x;  }


    public static void setAllgender(Collection author_s,String val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().setgender(author_x,val); } }


  public void setdob(String dob_x) { dob = dob_x;  }


    public static void setAlldob(Collection author_s,String val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().setdob(author_x,val); } }


  public void setbooks(HashSet books_xx) { books = books_xx;
    }
 
  public void addbooks(Book books_xx) { books.add(books_xx);
    }
 
  public void removebooks(Book books_xx) { books.remove(books_xx);
    }

  public static void setAllbooks(Collection author_s,HashSet _val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().setbooks(author_x, _val); } }

  public static void addAllbooks(Collection author_s,Book _val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().addbooks(author_x, _val); } }


  public static void removeAllbooks(Collection author_s,Book _val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().removebooks(author_x, _val); } }


  public static void unionAllbooks(Collection author_s, HashSet _val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().unionbooks(author_x, _val); } }


  public static void subtractAllbooks(Collection author_s, HashSet _val)
  { for (Object _o : author_s)
    { Author author_x = (Author) _o;
      Controller.inst().subtractbooks(author_x, _val); } }


    public String getfName() { return fName; }

    public static HashSet getAllfName(Collection author_s)
  { HashSet result = new HashSet();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getfName()); }
    return result; }

    public static ArrayList getAllOrderedfName(Collection author_s)
  { ArrayList result = new ArrayList();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getfName()); } 
    return result; }

    public String getlName() { return lName; }

    public static HashSet getAlllName(Collection author_s)
  { HashSet result = new HashSet();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getlName()); }
    return result; }

    public static ArrayList getAllOrderedlName(Collection author_s)
  { ArrayList result = new ArrayList();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getlName()); } 
    return result; }

    public String getgender() { return gender; }

    public static HashSet getAllgender(Collection author_s)
  { HashSet result = new HashSet();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getgender()); }
    return result; }

    public static ArrayList getAllOrderedgender(Collection author_s)
  { ArrayList result = new ArrayList();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getgender()); } 
    return result; }

    public String getdob() { return dob; }

    public static HashSet getAlldob(Collection author_s)
  { HashSet result = new HashSet();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getdob()); }
    return result; }

    public static ArrayList getAllOrdereddob(Collection author_s)
  { ArrayList result = new ArrayList();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.add(author_x.getdob()); } 
    return result; }

  public HashSet getbooks() { return (HashSet) ((HashSet) books).clone(); }

  public static HashSet getAllbooks(Collection author_s)
  { HashSet result = new HashSet();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.addAll(author_x.getbooks()); }
    return result; }

  public static ArrayList getAllOrderedbooks(Collection author_s)
  { ArrayList result = new ArrayList();
    for (Object _o : author_s)
    { Author author_x = (Author) _o;
      result.addAll(author_x.getbooks()); }
    return result; }


}

