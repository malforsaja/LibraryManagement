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
class Book implements SystemTypes
{
  private String Title; // internal
  private String ISBN; // internal
  private int nr_copies; // internal
  private int publication_year; // internal
  private Author author;
  private Rent rent;

  public Book(Author author,Rent rent)
  {
    this.Title = "";
    this.ISBN = "";
    this.nr_copies = 0;
    this.publication_year = 0;
    this.author = author;
    this.rent = rent;

  }

  public Book() { }



  public String toString()
  { String _res_ = "(Book) ";
    _res_ = _res_ + Title + ",";
    _res_ = _res_ + ISBN + ",";
    _res_ = _res_ + nr_copies + ",";
    _res_ = _res_ + publication_year;
    return _res_;
  }

  public void setTitle(String Title_x) { Title = Title_x;  }


    public static void setAllTitle(Collection book_s,String val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setTitle(book_x,val); } }


  public void setISBN(String ISBN_x) { ISBN = ISBN_x;  }


    public static void setAllISBN(Collection book_s,String val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setISBN(book_x,val); } }


  public void setnr_copies(int nr_copies_x) { nr_copies = nr_copies_x;  }


    public static void setAllnr_copies(Collection book_s,int val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setnr_copies(book_x,val); } }


  public void setpublication_year(int publication_year_x) { publication_year = publication_year_x;  }


    public static void setAllpublication_year(Collection book_s,int val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setpublication_year(book_x,val); } }


  public void setauthor(Author author_xx) { author = author_xx;
  }

  public static void setAllauthor(Collection book_s,Author _val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setauthor(book_x, _val); } }

  public void setrent(Rent rent_xx) { rent = rent_xx;
  }

  public static void setAllrent(Collection book_s,Rent _val)
  { for (Object _o : book_s)
    { Book book_x = (Book) _o;
      Controller.inst().setrent(book_x, _val); } }

    public String getTitle() { return Title; }

    public static HashSet getAllTitle(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getTitle()); }
    return result; }

    public static ArrayList getAllOrderedTitle(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getTitle()); } 
    return result; }

    public String getISBN() { return ISBN; }

    public static HashSet getAllISBN(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getISBN()); }
    return result; }

    public static ArrayList getAllOrderedISBN(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getISBN()); } 
    return result; }

    public int getnr_copies() { return nr_copies; }

    public static HashSet getAllnr_copies(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(new Integer(book_x.getnr_copies())); }
    return result; }

    public static ArrayList getAllOrderednr_copies(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(new Integer(book_x.getnr_copies())); } 
    return result; }

    public int getpublication_year() { return publication_year; }

    public static HashSet getAllpublication_year(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(new Integer(book_x.getpublication_year())); }
    return result; }

    public static ArrayList getAllOrderedpublication_year(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(new Integer(book_x.getpublication_year())); } 
    return result; }

  public Author getauthor() { return author; }

  public static HashSet getAllauthor(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getauthor()); }
    return result; }

  public static ArrayList getAllOrderedauthor(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getauthor()); }
    return result; }

  public Rent getrent() { return rent; }

  public static HashSet getAllrent(Collection book_s)
  { HashSet result = new HashSet();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getrent()); }
    return result; }

  public static ArrayList getAllOrderedrent(Collection book_s)
  { ArrayList result = new ArrayList();
    for (Object _o : book_s)
    { Book book_x = (Book) _o;
      result.add(book_x.getrent()); }
    return result; }


}
