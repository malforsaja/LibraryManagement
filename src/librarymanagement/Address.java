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
class Address implements SystemTypes
{
  private String streetName; // internal
  private String city; // internal
  private int streetNr; // internal
  private Reader renter;

  public Address(Reader renter)
  {
    this.streetName = "";
    this.city = "";
    this.streetNr = 0;
    this.renter = renter;

  }

  public Address() { }



  public String toString()
  { String _res_ = "(Address) ";
    _res_ = _res_ + streetName + ",";
    _res_ = _res_ + city + ",";
    _res_ = _res_ + streetNr;
    return _res_;
  }

  public void setstreetName(String streetName_x) { streetName = streetName_x;  }


    public static void setAllstreetName(Collection address_s,String val)
  { for (Object _o : address_s)
    { Address address_x = (Address) _o;
      Controller.inst().setstreetName(address_x,val); } }


  public void setcity(String city_x) { city = city_x;  }


    public static void setAllcity(Collection address_s,String val)
  { for (Object _o : address_s)
    { Address address_x = (Address) _o;
      Controller.inst().setcity(address_x,val); } }


  public void setstreetNr(int streetNr_x) { streetNr = streetNr_x;  }


    public static void setAllstreetNr(Collection address_s,int val)
  { for (Object _o : address_s)
    { Address address_x = (Address) _o;
      Controller.inst().setstreetNr(address_x,val); } }


  public void setrenter(Reader renter_xx) { renter = renter_xx;
  }

  public static void setAllrenter(Collection address_s,Reader _val)
  { for (Object _o : address_s)
    { Address address_x = (Address) _o;
      Controller.inst().setrenter(address_x, _val); } }

    public String getstreetName() { return streetName; }

    public static HashSet getAllstreetName(Collection address_s)
  { HashSet result = new HashSet();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getstreetName()); }
    return result; }

    public static ArrayList getAllOrderedstreetName(Collection address_s)
  { ArrayList result = new ArrayList();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getstreetName()); } 
    return result; }

    public String getcity() { return city; }

    public static HashSet getAllcity(Collection address_s)
  { HashSet result = new HashSet();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getcity()); }
    return result; }

    public static ArrayList getAllOrderedcity(Collection address_s)
  { ArrayList result = new ArrayList();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getcity()); } 
    return result; }

    public int getstreetNr() { return streetNr; }

    public static HashSet getAllstreetNr(Collection address_s)
  { HashSet result = new HashSet();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(new Integer(address_x.getstreetNr())); }
    return result; }

    public static ArrayList getAllOrderedstreetNr(Collection address_s)
  { ArrayList result = new ArrayList();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(new Integer(address_x.getstreetNr())); } 
    return result; }

  public Reader getrenter() { return renter; }

  public static HashSet getAllrenter(Collection address_s)
  { HashSet result = new HashSet();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getrenter()); }
    return result; }

  public static ArrayList getAllOrderedrenter(Collection address_s)
  { ArrayList result = new ArrayList();
    for (Object _o : address_s)
    { Address address_x = (Address) _o;
      result.add(address_x.getrenter()); }
    return result; }


}
