/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

/**
 *
 * @author 4E
 */
import java.util.*;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.*;
import java.lang.reflect.*;
import java.util.StringTokenizer;
import java.io.*;




public class Controller implements SystemTypes
{
  ArrayList addresss = new ArrayList();
  ArrayList authors = new ArrayList();
  ArrayList books = new ArrayList();
  ArrayList readers = new ArrayList();
  ArrayList rents = new ArrayList();
  private static Controller uniqueInstance; 


  private Controller() { } 


  public static Controller inst() 
    { if (uniqueInstance == null) 
    { uniqueInstance = new Controller(); }
    return uniqueInstance; } 


  public static void loadModel(String file)
  {
    try
    { BufferedReader br = null;
      File f = new File(file);
      try 
      { br = new BufferedReader(new FileReader(f)); }
      catch (Exception ex) 
      { System.err.println("No file: " + file); return; }
      Class cont = Class.forName("Controller");
      java.util.Map objectmap = new java.util.HashMap();
      while (true)
      { String line1;
        try { line1 = br.readLine(); }
        catch (Exception e)
        { return; }
        if (line1 == null)
        { return; }
        line1 = line1.trim();

        if (line1.length() == 0) { continue; }
        String left;
        String op;
        String right;
        if (line1.charAt(line1.length() - 1) == '"')
        { int eqind = line1.indexOf("="); 
          if (eqind == -1) { continue; }
          else 
          { left = line1.substring(0,eqind-1).trim();
            op = "="; 
            right = line1.substring(eqind+1,line1.length()).trim();
          }
        }
        else
        { StringTokenizer st1 = new StringTokenizer(line1);
          Vector vals1 = new Vector();
          while (st1.hasMoreTokens())
          { String val1 = st1.nextToken();
            vals1.add(val1);
          }
          if (vals1.size() < 3)
          { continue; }
          left = (String) vals1.get(0);
          op = (String) vals1.get(1);
          right = (String) vals1.get(2);
        }
        if (":".equals(op))
        { int i2 = right.indexOf(".");
          if (i2 == -1)
          { Class cl;
            try { cl = Class.forName("" + right); }
            catch (Exception _x) { System.err.println("No entity: " + right); continue; }
            Object xinst = cl.newInstance();
            objectmap.put(left,xinst);
            Class[] cargs = new Class[] { cl };
            Method addC = cont.getMethod("add" + right,cargs);
            if (addC == null) { continue; }
            Object[] args = new Object[] { xinst };
            addC.invoke(Controller.inst(),args);
          }
          else
          { String obj = right.substring(0,i2);
            String role = right.substring(i2+1,right.length());
            Object objinst = objectmap.get(obj); 
            if (objinst == null) 
            { continue; }
            Object val = objectmap.get(left);
            if (val == null) 
            { continue; }
            Class objC = objinst.getClass();
            Class typeclass = val.getClass(); 
            Object[] args = new Object[] { val }; 
            Class[] settypes = new Class[] { typeclass };
            Method addrole = Controller.findMethod(objC,"add" + role);
            if (addrole != null) 
            { addrole.invoke(objinst, args); }
            else { System.err.println("Error: cannot add to " + role); }
          }
        }
        else if ("=".equals(op))
        { int i1 = left.indexOf(".");
          if (i1 == -1) 
          { continue; }
          String obj = left.substring(0,i1);
          String att = left.substring(i1+1,left.length());
          Object objinst = objectmap.get(obj); 
          if (objinst == null) 
          { continue; }
          Class objC = objinst.getClass();
          Class typeclass; 
          Object val; 
          if (right.charAt(0) == '"' &&
              right.charAt(right.length() - 1) == '"')
          { typeclass = String.class;
            val = right.substring(1,right.length() - 1);
          } 
          else if ("true".equals(right) || "false".equals(right))
          { typeclass = boolean.class;
            if ("true".equals(right))
            { val = new Boolean(true); }
            else
            { val = new Boolean(false); }
          }
          else 
          { val = objectmap.get(right);
            if (val != null)
            { typeclass = val.getClass(); }
            else 
            { int i;
              long l; 
              double d;
              try 
              { i = Integer.parseInt(right);
                typeclass = int.class;
                val = new Integer(i); 
              }
              catch (Exception ee)
              { try 
                { l = Long.parseLong(right);
                  typeclass = long.class;
                  val = new Long(l); 
                }
                catch (Exception eee)
                { try
                  { d = Double.parseDouble(right);
                    typeclass = double.class;
                    val = new Double(d);
                  }
                  catch (Exception ff)
                  { continue; }
                }
              }
            }
          }
          Object[] args = new Object[] { val }; 
          Class[] settypes = new Class[] { typeclass };
          Method setatt = Controller.findMethod(objC,"set" + att);
          if (setatt != null) 
          { setatt.invoke(objinst, args); }
          else { System.err.println("No attribute: " + att); }
        }
      }
    } catch (Exception e) { }
  }

  public static Method findMethod(Class c, String name)
  { Method[] mets = c.getMethods(); 
    for (int i = 0; i < mets.length; i++)
    { Method m = mets[i];
      if (m.getName().equals(name))
      { return m; }
    } 
    return null;
  }


  public void saveModel(String file)
  { File outfile = new File(file); 
    PrintWriter out; 
    try { out = new PrintWriter(new BufferedWriter(new FileWriter(outfile))); }
    catch (Exception e) { return; } 
  for (int _i = 0; _i < addresss.size(); _i++)
  { Address addressx_ = (Address) addresss.get(_i);
    out.println("addressx_" + _i + " : Address");
    out.println("addressx_" + _i + ".streetName = \"" + addressx_.getstreetName() + "\"");
    out.println("addressx_" + _i + ".city = \"" + addressx_.getcity() + "\"");
    out.println("addressx_" + _i + ".streetNr = " + addressx_.getstreetNr());
  }

  for (int _i = 0; _i < authors.size(); _i++)
  { Author authorx_ = (Author) authors.get(_i);
    out.println("authorx_" + _i + " : Author");
    out.println("authorx_" + _i + ".fName = \"" + authorx_.getfName() + "\"");
    out.println("authorx_" + _i + ".lName = \"" + authorx_.getlName() + "\"");
    out.println("authorx_" + _i + ".gender = \"" + authorx_.getgender() + "\"");
    out.println("authorx_" + _i + ".dob = \"" + authorx_.getdob() + "\"");
  }

  for (int _i = 0; _i < books.size(); _i++)
  { Book bookx_ = (Book) books.get(_i);
    out.println("bookx_" + _i + " : Book");
    out.println("bookx_" + _i + ".Title = \"" + bookx_.getTitle() + "\"");
    out.println("bookx_" + _i + ".ISBN = \"" + bookx_.getISBN() + "\"");
    out.println("bookx_" + _i + ".nr_copies = " + bookx_.getnr_copies());
    out.println("bookx_" + _i + ".publication_year = " + bookx_.getpublication_year());
  }

  for (int _i = 0; _i < readers.size(); _i++)
  { Reader readerx_ = (Reader) readers.get(_i);
    out.println("readerx_" + _i + " : Reader");
    out.println("readerx_" + _i + ".readerID = " + readerx_.getreaderID());
    out.println("readerx_" + _i + ".fName = \"" + readerx_.getfName() + "\"");
    out.println("readerx_" + _i + ".lName = \"" + readerx_.getlName() + "\"");
    out.println("readerx_" + _i + ".email = \"" + readerx_.getemail() + "\"");
    out.println("readerx_" + _i + ".phone = \"" + readerx_.getphone() + "\"");
  }

  for (int _i = 0; _i < rents.size(); _i++)
  { Rent rentx_ = (Rent) rents.get(_i);
    out.println("rentx_" + _i + " : Rent");
    out.println("rentx_" + _i + ".borrowing_date = \"" + rentx_.getborrowing_date() + "\"");
    out.println("rentx_" + _i + ".return_date = \"" + rentx_.getreturn_date() + "\"");
    out.println("rentx_" + _i + ".rentID = " + rentx_.getrentID());
  }

  for (int _i = 0; _i < addresss.size(); _i++)
  { Address addressx_ = (Address) addresss.get(_i);
    out.println("addressx_" + _i + ".renter = readerx_" + readers.indexOf(((Address) addresss.get(_i)).getrenter()));
  }
  for (int _i = 0; _i < authors.size(); _i++)
  { Author authorx_ = (Author) authors.get(_i);
    Collection author_books_Book = authorx_.getbooks();
    for (Object _j : author_books_Book)
    { out.println("bookx_" + books.indexOf(_j) + " : authorx_" + _i + ".books");
    }
  }
  for (int _i = 0; _i < books.size(); _i++)
  { Book bookx_ = (Book) books.get(_i);
    out.println("bookx_" + _i + ".author = authorx_" + authors.indexOf(((Book) books.get(_i)).getauthor()));
    out.println("bookx_" + _i + ".rent = rentx_" + rents.indexOf(((Book) books.get(_i)).getrent()));
  }
  for (int _i = 0; _i < readers.size(); _i++)
  { Reader readerx_ = (Reader) readers.get(_i);
    out.println("readerx_" + _i + ".address = addressx_" + addresss.indexOf(((Reader) readers.get(_i)).getaddress()));
    out.println("readerx_" + _i + ".rent = rentx_" + rents.indexOf(((Reader) readers.get(_i)).getrent()));
  }
  for (int _i = 0; _i < rents.size(); _i++)
  { Rent rentx_ = (Rent) rents.get(_i);
    out.println("rentx_" + _i + ".reader = readerx_" + readers.indexOf(((Rent) rents.get(_i)).getreader()));
    Collection rent_books_Book = rentx_.getbooks();
    for (Object _j : rent_books_Book)
    { out.println("bookx_" + books.indexOf(_j) + " : rentx_" + _i + ".books");
    }
  }
    out.close(); 
  }



  public void addAddress(Address oo) { addresss.add(oo); }

  public void addAuthor(Author oo) { authors.add(oo); }

  public void addBook(Book oo) { books.add(oo); }

  public void addReader(Reader oo) { readers.add(oo); }

  public void addRent(Rent oo) { rents.add(oo); }



  public void createAllAddress(ArrayList addressx)
  { for (int i = 0; i < addressx.size(); i++)
    { Address addressx_x = new Address();
      addressx.set(i,addressx_x);
      addAddress(addressx_x);
    }
  }


  public Address createAddress(Reader renterx)
  { 
    Address addressx = new Address(renterx);
    addAddress(addressx);
    setstreetName(addressx,"");
    setcity(addressx,"");
    setstreetNr(addressx,0);
    setrenter(addressx,renterx);

    return addressx;
  }

  public void createAllAuthor(ArrayList authorx)
  { for (int i = 0; i < authorx.size(); i++)
    { Author authorx_x = new Author();
      authorx.set(i,authorx_x);
      addAuthor(authorx_x);
    }
  }


  public Author createAuthor()
  { 
    Author authorx = new Author();
    addAuthor(authorx);
    setfName(authorx,"");
    setlName(authorx,"");
    setgender(authorx,"");
    setdob(authorx,"");
    setbooks(authorx,new HashSet());

    return authorx;
  }

  public void createAllBook(ArrayList bookx)
  { for (int i = 0; i < bookx.size(); i++)
    { Book bookx_x = new Book();
      bookx.set(i,bookx_x);
      addBook(bookx_x);
    }
  }


  public Book createBook(Author authorx,Rent rentx)
  { 
    Book bookx = new Book(authorx,rentx);
    addBook(bookx);
    setTitle(bookx,"");
    setISBN(bookx,"");
    setnr_copies(bookx,0);
    setpublication_year(bookx,0);
    setauthor(bookx,authorx);
    setrent(bookx,rentx);

    return bookx;
  }

  public void createAllReader(ArrayList readerx)
  { for (int i = 0; i < readerx.size(); i++)
    { Reader readerx_x = new Reader();
      readerx.set(i,readerx_x);
      addReader(readerx_x);
    }
  }


  public Reader createReader(Address addressx,Rent rentx)
  { 
    Reader readerx = new Reader(addressx,rentx);
    addReader(readerx);
    setreaderID(readerx,0);
    setfName(readerx,"");
    setlName(readerx,"");
    setemail(readerx,"");
    setphone(readerx,"");
    setaddress(readerx,addressx);
    setrent(readerx,rentx);

    return readerx;
  }

  public void createAllRent(ArrayList rentx)
  { for (int i = 0; i < rentx.size(); i++)
    { Rent rentx_x = new Rent();
      rentx.set(i,rentx_x);
      addRent(rentx_x);
    }
  }


  public Rent createRent(Reader readerx)
  { 
    Rent rentx = new Rent(readerx);
    addRent(rentx);
    setborrowing_date(rentx,"");
    setreturn_date(rentx,"");
    setrentID(rentx,0);
    setreader(rentx,readerx);
    setbooks(rentx,new HashSet());

    return rentx;
  }


public void setstreetName(Address addressx, String streetName_x) 
  { addressx.setstreetName(streetName_x);
    }


public void setcity(Address addressx, String city_x) 
  { addressx.setcity(city_x);
    }


public void setstreetNr(Address addressx, int streetNr_x) 
  { addressx.setstreetNr(streetNr_x);
    }


  public void setrenter(Address addressx, Reader renterxx) 
  {   if (addressx.getrenter() == renterxx) { return; }
    if (addressx.getrenter() != null)
    { addressx.getrenter().setaddress(null); }
    if (renterxx.getaddress() != null)
    { renterxx.getaddress().setrenter(null); }
    renterxx.setaddress(addressx);
    addressx.setrenter(renterxx);
      }


public void setfName(Author authorx, String fName_x) 
  { authorx.setfName(fName_x);
    }


public void setlName(Author authorx, String lName_x) 
  { authorx.setlName(lName_x);
    }


public void setgender(Author authorx, String gender_x) 
  { authorx.setgender(gender_x);
    }


public void setdob(Author authorx, String dob_x) 
  { authorx.setdob(dob_x);
    }


  public void setbooks(Author authorx, HashSet booksxx) 
  {   HashSet _oldbooksxx = authorx.getbooks();
    for (Object _o : _oldbooksxx)
    { Book _yy = (Book) _o;
      if (booksxx.contains(_yy)) { }
      else { _yy.setauthor(null); }
    }
  for (Object _o : booksxx)
  { Book _xx = (Book) _o;
    if (_oldbooksxx.contains(_xx)) { }
    else { if (_xx.getauthor() != null) { _xx.getauthor().removebooks(_xx); }  }
    _xx.setauthor(authorx);
  }
    authorx.setbooks(booksxx);
      }


  public void addbooks(Author authorx, Book booksxx) 
  { if (authorx.getbooks().contains(booksxx)) { return; }
    if (booksxx.getauthor() != null) { booksxx.getauthor().removebooks(booksxx); }
  booksxx.setauthor(authorx);
    authorx.addbooks(booksxx);
    }


  public void removebooks(Author authorx, Book booksxx) 
  { authorx.removebooks(booksxx);
    booksxx.setauthor(null);
  }


 public void unionbooks(Author authorx, Collection booksx)
  { for (Object _o : booksx)
    { Book bookxbooks = (Book) _o;
      addbooks(authorx,bookxbooks);
     } } 


 public void subtractbooks(Author authorx, Collection booksx)
  { for (Object _o : booksx)
    { Book bookxbooks = (Book) _o;
      removebooks(authorx,bookxbooks);
     } } 


public void setTitle(Book bookx, String Title_x) 
  { bookx.setTitle(Title_x);
    }


public void setISBN(Book bookx, String ISBN_x) 
  { bookx.setISBN(ISBN_x);
    }


public void setnr_copies(Book bookx, int nr_copies_x) 
  { bookx.setnr_copies(nr_copies_x);
    }


public void setpublication_year(Book bookx, int publication_year_x) 
  { bookx.setpublication_year(publication_year_x);
    }


  public void setauthor(Book bookx, Author authorxx) 
  {   if (bookx.getauthor() == authorxx) { return; }
    if (bookx.getauthor() != null)
    { Author old_value = bookx.getauthor();
      old_value.removebooks(bookx); } 
    authorxx.addbooks(bookx);
    bookx.setauthor(authorxx);
      }


  public void setrent(Book bookx, Rent rentxx) 
  {   if (bookx.getrent() == rentxx) { return; }
    if (bookx.getrent() != null)
    { Rent old_value = bookx.getrent();
      old_value.removebooks(bookx); } 
    rentxx.addbooks(bookx);
    bookx.setrent(rentxx);
      }


public void setreaderID(Reader readerx, int readerID_x) 
  { readerx.setreaderID(readerID_x);
    }


public void setfName(Reader readerx, String fName_x) 
  { readerx.setfName(fName_x);
    }


public void setlName(Reader readerx, String lName_x) 
  { readerx.setlName(lName_x);
    }


public void setemail(Reader readerx, String email_x) 
  { readerx.setemail(email_x);
    }


public void setphone(Reader readerx, String phone_x) 
  { readerx.setphone(phone_x);
    }


  public void setaddress(Reader readerx, Address addressxx) 
  {   if (readerx.getaddress() == addressxx) { return; }
    if (readerx.getaddress() != null)
    { readerx.getaddress().setrenter(null); }
    if (addressxx.getrenter() != null)
    { addressxx.getrenter().setaddress(null); }
    addressxx.setrenter(readerx);
    readerx.setaddress(addressxx);
      }


  public void setrent(Reader readerx, Rent rentxx) 
  {   if (readerx.getrent() == rentxx) { return; }
    if (readerx.getrent() != null)
    { readerx.getrent().setreader(null); }
    if (rentxx.getreader() != null)
    { rentxx.getreader().setrent(null); }
    rentxx.setreader(readerx);
    readerx.setrent(rentxx);
      }


public void setborrowing_date(Rent rentx, String borrowing_date_x) 
  { rentx.setborrowing_date(borrowing_date_x);
    }


public void setreturn_date(Rent rentx, String return_date_x) 
  { rentx.setreturn_date(return_date_x);
    }


public void setrentID(Rent rentx, int rentID_x) 
  { rentx.setrentID(rentID_x);
    }


  public void setreader(Rent rentx, Reader readerxx) 
  {   if (rentx.getreader() == readerxx) { return; }
    if (rentx.getreader() != null)
    { rentx.getreader().setrent(null); }
    if (readerxx.getrent() != null)
    { readerxx.getrent().setreader(null); }
    readerxx.setrent(rentx);
    rentx.setreader(readerxx);
      }


  public void setbooks(Rent rentx, HashSet booksxx) 
  {   HashSet _oldbooksxx = rentx.getbooks();
    for (Object _o : _oldbooksxx)
    { Book _yy = (Book) _o;
      if (booksxx.contains(_yy)) { }
      else { _yy.setrent(null); }
    }
  for (Object _o : booksxx)
  { Book _xx = (Book) _o;
    if (_oldbooksxx.contains(_xx)) { }
    else { if (_xx.getrent() != null) { _xx.getrent().removebooks(_xx); }  }
    _xx.setrent(rentx);
  }
    rentx.setbooks(booksxx);
      }


  public void addbooks(Rent rentx, Book booksxx) 
  { if (rentx.getbooks().contains(booksxx)) { return; }
    if (booksxx.getrent() != null) { booksxx.getrent().removebooks(booksxx); }
  booksxx.setrent(rentx);
    rentx.addbooks(booksxx);
    }


  public void removebooks(Rent rentx, Book booksxx) 
  { rentx.removebooks(booksxx);
    booksxx.setrent(null);
  }


 public void unionbooks(Rent rentx, Collection booksx)
  { for (Object _o : booksx)
    { Book bookxbooks = (Book) _o;
      addbooks(rentx,bookxbooks);
     } } 


 public void subtractbooks(Rent rentx, Collection booksx)
  { for (Object _o : booksx)
    { Book bookxbooks = (Book) _o;
      removebooks(rentx,bookxbooks);
     } } 





  public void killAllAddress(Collection addressxx)
  { for (Object _o : addressxx)
    { killAddress((Address) _o); }
  }

  public void killAddress(Address addressxx)
  { addresss.remove(addressxx);
    ArrayList _1removedaddressReader = new ArrayList();
    ArrayList _1qrangeaddressReader = new ArrayList();
    _1qrangeaddressReader.add(addressxx.getrenter());
    for (int _i = 0; _i < _1qrangeaddressReader.size(); _i++)
    { Reader readerx = (Reader) _1qrangeaddressReader.get(_i);
      if (readerx != null && addressxx.equals(readerx.getaddress()))
      { _1removedaddressReader.add(readerx);
        readerx.setaddress(null);
      }
    }
    for (int _i = 0; _i < _1removedaddressReader.size(); _i++)
    { killReader((Reader) _1removedaddressReader.get(_i)); }
  }



  public void killAllAuthor(Collection authorxx)
  { for (Object _o : authorxx)
    { killAuthor((Author) _o); }
  }

  public void killAuthor(Author authorxx)
  { authors.remove(authorxx);
    ArrayList _2removedauthorBook = new ArrayList();
    ArrayList _2qrangeauthorBook = new ArrayList();
    _2qrangeauthorBook.addAll(authorxx.getbooks());
    for (int _i = 0; _i < _2qrangeauthorBook.size(); _i++)
    { Book bookx = (Book) _2qrangeauthorBook.get(_i);
      if (bookx != null && authorxx.equals(bookx.getauthor()))
      { _2removedauthorBook.add(bookx);
        bookx.setauthor(null);
      }
    }

    authorxx.setbooks(new HashSet());
    for (int _i = 0; _i < _2removedauthorBook.size(); _i++)
    { killBook((Book) _2removedauthorBook.get(_i)); }
  }



  public void killAllBook(Collection bookxx)
  { for (Object _o : bookxx)
    { killBook((Book) _o); }
  }

  public void killBook(Book bookxx)
  { books.remove(bookxx);
    ArrayList _1qrangebooksAuthor = new ArrayList();
    _1qrangebooksAuthor.add(bookxx.getauthor());
    for (int _i = 0; _i < _1qrangebooksAuthor.size(); _i++)
    { Author authorx = (Author) _1qrangebooksAuthor.get(_i);
      if (authorx.getbooks().contains(bookxx))
      { removebooks(authorx,bookxx); }
    }
    ArrayList _1qrangebooksRent = new ArrayList();
    _1qrangebooksRent.add(bookxx.getrent());
    for (int _i = 0; _i < _1qrangebooksRent.size(); _i++)
    { Rent rentx = (Rent) _1qrangebooksRent.get(_i);
      if (rentx.getbooks().contains(bookxx))
      { removebooks(rentx,bookxx); }
    }
  }



  public void killAllReader(Collection readerxx)
  { for (Object _o : readerxx)
    { killReader((Reader) _o); }
  }

  public void killReader(Reader readerxx)
  { readers.remove(readerxx);
    ArrayList _2removedrenterAddress = new ArrayList();
    ArrayList _2removedreaderRent = new ArrayList();
    ArrayList _2qrangerenterAddress = new ArrayList();
    _2qrangerenterAddress.add(readerxx.getaddress());
    for (int _i = 0; _i < _2qrangerenterAddress.size(); _i++)
    { Address addressx = (Address) _2qrangerenterAddress.get(_i);
      if (addressx != null && readerxx.equals(addressx.getrenter()))
      { _2removedrenterAddress.add(addressx);
        addressx.setrenter(null);
      }
    }
    ArrayList _2qrangereaderRent = new ArrayList();
    _2qrangereaderRent.add(readerxx.getrent());
    for (int _i = 0; _i < _2qrangereaderRent.size(); _i++)
    { Rent rentx = (Rent) _2qrangereaderRent.get(_i);
      if (rentx != null && readerxx.equals(rentx.getreader()))
      { _2removedreaderRent.add(rentx);
        rentx.setreader(null);
      }
    }
    for (int _i = 0; _i < _2removedrenterAddress.size(); _i++)
    { killAddress((Address) _2removedrenterAddress.get(_i)); }
    for (int _i = 0; _i < _2removedreaderRent.size(); _i++)
    { killRent((Rent) _2removedreaderRent.get(_i)); }
  }



  public void killAllRent(Collection rentxx)
  { for (Object _o : rentxx)
    { killRent((Rent) _o); }
  }

  public void killRent(Rent rentxx)
  { rents.remove(rentxx);
    ArrayList _1removedrentReader = new ArrayList();
    ArrayList _2removedrentBook = new ArrayList();
    ArrayList _1qrangerentReader = new ArrayList();
    _1qrangerentReader.add(rentxx.getreader());
    for (int _i = 0; _i < _1qrangerentReader.size(); _i++)
    { Reader readerx = (Reader) _1qrangerentReader.get(_i);
      if (readerx != null && rentxx.equals(readerx.getrent()))
      { _1removedrentReader.add(readerx);
        readerx.setrent(null);
      }
    }
    ArrayList _2qrangerentBook = new ArrayList();
    _2qrangerentBook.addAll(rentxx.getbooks());
    for (int _i = 0; _i < _2qrangerentBook.size(); _i++)
    { Book bookx = (Book) _2qrangerentBook.get(_i);
      if (bookx != null && rentxx.equals(bookx.getrent()))
      { _2removedrentBook.add(bookx);
        bookx.setrent(null);
      }
    }

    rentxx.setbooks(new HashSet());
    for (int _i = 0; _i < _1removedrentReader.size(); _i++)
    { killReader((Reader) _1removedrentReader.get(_i)); }
    for (int _i = 0; _i < _2removedrentBook.size(); _i++)
    { killBook((Book) _2removedrentBook.get(_i)); }
  }




   
}


