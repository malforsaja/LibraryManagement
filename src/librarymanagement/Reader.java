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
class Reader
  implements SystemTypes
{
  private int readerID; // internal
  private String fName; // internal
  private String lName; // internal
  private String email; // internal
  private String phone; // internal
  private Address address;
  private Rent rent;

  public Reader(Address address,Rent rent)
  {
    this.readerID = 0;
    this.fName = "";
    this.lName = "";
    this.email = "";
    this.phone = "";
    this.address = address;
    this.rent = rent;

  }

  public Reader() { }



  public String toString()
  { String _res_ = "(Reader) ";
    _res_ = _res_ + readerID + ",";
    _res_ = _res_ + fName + ",";
    _res_ = _res_ + lName + ",";
    _res_ = _res_ + email + ",";
    _res_ = _res_ + phone;
    return _res_;
  }

  public void setreaderID(int readerID_x) { readerID = readerID_x;  }


    public static void setAllreaderID(Collection reader_s,int val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setreaderID(reader_x,val); } }


  public void setfName(String fName_x) { fName = fName_x;  }


    public static void setAllfName(Collection reader_s,String val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setfName(reader_x,val); } }


  public void setlName(String lName_x) { lName = lName_x;  }


    public static void setAlllName(Collection reader_s,String val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setlName(reader_x,val); } }


  public void setemail(String email_x) { email = email_x;  }


    public static void setAllemail(Collection reader_s,String val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setemail(reader_x,val); } }


  public void setphone(String phone_x) { phone = phone_x;  }


    public static void setAllphone(Collection reader_s,String val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setphone(reader_x,val); } }


  public void setaddress(Address address_xx) { address = address_xx;
  }

  public static void setAlladdress(Collection reader_s,Address _val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setaddress(reader_x, _val); } }

  public void setrent(Rent rent_xx) { rent = rent_xx;
  }

  public static void setAllrent(Collection reader_s,Rent _val)
  { for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      Controller.inst().setrent(reader_x, _val); } }

    public int getreaderID() { return readerID; }

    public static HashSet getAllreaderID(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(new Integer(reader_x.getreaderID())); }
    return result; }

    public static ArrayList getAllOrderedreaderID(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(new Integer(reader_x.getreaderID())); } 
    return result; }

    public String getfName() { return fName; }

    public static HashSet getAllfName(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getfName()); }
    return result; }

    public static ArrayList getAllOrderedfName(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getfName()); } 
    return result; }

    public String getlName() { return lName; }

    public static HashSet getAlllName(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getlName()); }
    return result; }

    public static ArrayList getAllOrderedlName(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getlName()); } 
    return result; }

    public String getemail() { return email; }

    public static HashSet getAllemail(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getemail()); }
    return result; }

    public static ArrayList getAllOrderedemail(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getemail()); } 
    return result; }

    public String getphone() { return phone; }

    public static HashSet getAllphone(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getphone()); }
    return result; }

    public static ArrayList getAllOrderedphone(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getphone()); } 
    return result; }

  public Address getaddress() { return address; }

  public static HashSet getAlladdress(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getaddress()); }
    return result; }

  public static ArrayList getAllOrderedaddress(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getaddress()); }
    return result; }

  public Rent getrent() { return rent; }

  public static HashSet getAllrent(Collection reader_s)
  { HashSet result = new HashSet();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getrent()); }
    return result; }

  public static ArrayList getAllOrderedrent(Collection reader_s)
  { ArrayList result = new ArrayList();
    for (Object _o : reader_s)
    { Reader reader_x = (Reader) _o;
      result.add(reader_x.getrent()); }
    return result; }


}
