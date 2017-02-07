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
import java.util.Date;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;

public interface SystemTypes
{
  public class Set
  { 







    public static HashSet addSet(HashSet s, Object x)
    { s.add(x);
      return s; }

    public static HashSet addSet(HashSet s, int x)
    { s.add(new Integer(x));
      return s; }

    public static HashSet addSet(HashSet s, double x)
    { s.add(new Double(x));
      return s; }

    public static HashSet addSet(HashSet s, boolean x)
    { s.add(new Boolean(x));
      return s; }

    public static HashSet addSequence(HashSet s, Object x)
    { s.add(x);
      return s; }

    public static HashSet addSequence(HashSet s, int x)
    { s.add(new Integer(x));
      return s; }

    public static HashSet addSequence(HashSet s, double x)
    { s.add(new Double(x));
      return s; }

    public static HashSet addSequence(HashSet s, boolean x)
    { s.add(new Boolean(x));
      return s; }

    public static ArrayList asSequence(Collection c)
    { ArrayList res = new ArrayList(); res.addAll(c); return res; }

    public static HashSet asSet(Collection c)
    { HashSet res = new HashSet(); res.addAll(c); return res; }


  public static Comparable max(Collection l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) Set.any(l); 
    for (Object _o : l)
    { Comparable e = (Comparable) _o;
      if (res.compareTo(e) < 0) { res = e; } }
    return res; }


  public static Comparable min(Collection l)
  { Comparable res = null; 
    if (l.size() == 0) { return res; }
    res = (Comparable) Set.any(l); 
    for (Object _o : l)
    { Comparable e = (Comparable) _o;
      if (res.compareTo(e) > 0) { res = e; } }
    return res; }


  public static HashSet union(HashSet a, Collection b)
  { HashSet res = new HashSet(); 
    res.addAll(a); res.addAll(b);
    return res; }

  public static HashSet union(ArrayList a, HashSet b)
  { HashSet res = new HashSet(); 
    res.addAll(a); res.addAll(b);
    return res; }

  public static ArrayList union(ArrayList a, ArrayList b)
  { ArrayList res = new ArrayList(); 
    res.addAll(a); res.addAll(b);
    return res; }


  public static HashSet subtract(HashSet a, Collection b)
  { HashSet res = new HashSet(); 
    res.addAll(a);
    res.removeAll(b);
    return res; }

  public static ArrayList subtract(ArrayList a, Collection b)
  { ArrayList res = new ArrayList(); 
    res.addAll(a);
    res.removeAll(b);
    return res; }

  public static String subtract(String a, String b)
  { String res = ""; 
    for (int i = 0; i < a.length(); i++)
    { if (b.indexOf(a.charAt(i)) < 0) { res = res + a.charAt(i); } }
    return res; }



  public static HashSet intersection(HashSet a, Collection b)
  { HashSet res = new HashSet(); 
    res.addAll(a);
    res.retainAll(b);
    return res; }

  public static ArrayList intersection(ArrayList a, Collection b)
  { ArrayList res = new ArrayList(); 
    res.addAll(a);
    res.retainAll(b);
    return res; }



  public static HashSet symmetricDifference(Collection a, Collection b)
  { HashSet res = new HashSet();
    for (Object _a : a)
    { if (b.contains(_a)) { }
      else { res.add(_a); }
    }
    for (Object _b : b)
    { if (a.contains(_b)) { }
      else { res.add(_b); }
    }
    return res;
  }



  public static boolean isUnique(Collection evals)
  { HashSet vals = new HashSet(); 
    for (Object ob : evals)
    { if (vals.contains(ob)) { return false; }
      vals.add(ob);
    }
    return true;
  }


  public static int sumint(Collection a)
  { int sum = 0; 
    for (Object _o : a)
    { Integer x = (Integer) _o; 
      if (x != null) { sum += x.intValue(); }
    } 
    return sum; }

  public static double sumdouble(Collection a)
  { double sum = 0.0; 
    for (Object _o : a)
    { Double x = (Double) _o; 
      if (x != null) { sum += x.doubleValue(); }
    } 
    return sum; }

  public static long sumlong(Collection a)
  { long sum = 0; 
    for (Object _o : a)
    { Long x = (Long) _o; 
      if (x != null) { sum += x.longValue(); }
    } 
    return sum; }

  public static String sumString(Collection a)
  { String sum = ""; 
    for (Object x : a)
    { sum = sum + x; }
    return sum;  }



  public static int prdint(Collection a)
  { int sum = 1; 
    for (Object _o : a)
    { Integer x = (Integer) _o; 
      if (x != null) { sum *= x.intValue(); }
    } 
    return sum; }

  public static double prddouble(Collection a)
  { double sum = 1; 
    for (Object _o : a)
    { Double x = (Double) _o; 
      if (x != null) { sum *= x.doubleValue(); }
    } 
    return sum; }

  public static long prdlong(Collection a)
  { long sum = 1; 
    for (Object _o : a)
    { Long x = (Long) _o; 
      if (x != null) { sum *= x.longValue(); }
    } 
    return sum; }



  public static ArrayList concatenate(Collection a, Collection b)
  { ArrayList res = new ArrayList(); 
    res.addAll(a); 
    res.addAll(b); 
    return res; }


  public static ArrayList reverse(ArrayList a)
  { ArrayList res = new ArrayList(); 
    for (int i = a.size() - 1; i >= 0; i--)
    { res.add(a.get(i)); } 
    return res; }

  public static String reverse(String a)
  { String res = ""; 
    for (int i = a.length() - 1; i >= 0; i--)
    { res = res + a.charAt(i); } 
    return res; }



  public static ArrayList front(ArrayList a)
  { ArrayList res = new ArrayList(); 
    for (int i = 0; i < a.size() - 1; i++)
    { res.add(a.get(i)); } 
    return res; }


  public static ArrayList tail(ArrayList a)
  { ArrayList res = new ArrayList(); 
    for (int i = 1; i < a.size(); i++)
    { res.add(a.get(i)); } 
    return res; }


  public static ArrayList sort(final ArrayList a)
  { int i = a.size()-1;
    return mergeSort(a,0,i);
  }

  public static ArrayList sort(final HashSet a)
  { ArrayList b = new ArrayList(); 
    b.addAll(a); 
    int i = b.size()-1;
    return mergeSort(b,0,i);
  }

  static ArrayList mergeSort(final ArrayList a, int ind1, int ind2)
  { ArrayList res = new ArrayList();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    int mid = (ind1 + ind2)/2;
    ArrayList a1;
    ArrayList a2;
    if (mid == ind1)
    { a1 = new ArrayList();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,ind1,mid-1);
      a2 = mergeSort(a,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) a1.get(i); 
      Comparable e2 = (Comparable) a2.get(j);
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(e1);
        i++; // get next e1
      } 
      else 
      { res.add(e2);
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static ArrayList sortedBy(final ArrayList a, ArrayList f)
  { int i = a.size()-1;
    java.util.Map f_map = new java.util.HashMap();
    for (int j = 0; j < a.size(); j++)
    { f_map.put(a.get(j), f.get(j)); }
    return mergeSort(a,f_map,0,i);
  }

  static ArrayList mergeSort(final ArrayList a, java.util.Map f, int ind1, int ind2)
  { ArrayList res = new ArrayList();
    if (ind1 > ind2)
    { return res; }
    if (ind1 == ind2)
    { res.add(a.get(ind1));
      return res;
    }
    if (ind2 == ind1 + 1)
    { Comparable e1 = (Comparable) f.get(a.get(ind1)); 
      Comparable e2 = (Comparable) f.get(a.get(ind2));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a.get(ind1)); res.add(a.get(ind2)); return res; }
      else 
      { res.add(a.get(ind2)); res.add(a.get(ind1)); return res; }
    }    int mid = (ind1 + ind2)/2;
    ArrayList a1;
    ArrayList a2;
    if (mid == ind1)
    { a1 = new ArrayList();
      a1.add(a.get(ind1));
      a2 = mergeSort(a,f,mid+1,ind2);
    }
    else
    { a1 = mergeSort(a,f,ind1,mid-1);
      a2 = mergeSort(a,f,mid,ind2);
    }
    int i = 0;
    int j = 0;
    while (i < a1.size() && j < a2.size())
    { Comparable e1 = (Comparable) f.get(a1.get(i)); 
      Comparable e2 = (Comparable) f.get(a2.get(j));
      if (e1.compareTo(e2) < 0) // e1 < e2
      { res.add(a1.get(i));
        i++; // get next e1
      } 
      else 
      { res.add(a2.get(j));
        j++; 
      } 
    } 
    if (i == a1.size())
    { for (int k = j; k < a2.size(); k++)
      { res.add(a2.get(k)); } 
    } 
    else 
    { for (int k = i; k < a1.size(); k++) 
      { res.add(a1.get(k)); } 
    } 
    return res;
  }


  public static ArrayList integerSubrange(int i, int j)
  { ArrayList tmp = new ArrayList(); 
    for (int k = i; k <= j; k++)
    { tmp.add(new Integer(k)); } 
    return tmp;
  }

  public static String subrange(String s, int i, int j)
  { return s.substring(i-1,j); }

  public static ArrayList subrange(ArrayList l, int i, int j)
  { ArrayList tmp = new ArrayList(); 
    for (int k = i-1; k < j; k++)
    { tmp.add(l.get(k)); } 
    return tmp; 
  }



  public static ArrayList prepend(ArrayList l, Object ob)
  { ArrayList res = new ArrayList();
    res.add(ob);
    res.addAll(l);
    return res;
  }


  public static ArrayList append(ArrayList l, Object ob)
  { ArrayList res = new ArrayList();
    res.addAll(l);
    res.add(ob);
    return res;
  }


  public static int count(Collection l, Object obj)
  { int res = 0; 
    for (Object _o : l)
    { if (obj == _o) { res++; } 
      else if (obj != null && obj.equals(_o)) { res++; } 
    }
    return res; 
  }

  public static int count(String s, String x)
  { int res = 0; 
    if ("".equals(s)) { return res; }
    int ind = s.indexOf(x); 
    if (ind == -1) { return res; }
    String ss = s.substring(ind+1,s.length());
    res++; 
    while (ind >= 0)
    { ind = ss.indexOf(x); 
      if (ind == -1 || ss.equals("")) { return res; }
      res++; 
      ss = ss.substring(ind+1,ss.length());
    } 
    return res;
  }



  public static ArrayList characters(String str)
  { char[] _chars = str.toCharArray();
    ArrayList _res = new ArrayList();
    for (int i = 0; i < _chars.length; i++)
    { _res.add("" + _chars[i]); }
    return _res;
  }



    public static Object any(Collection v)
    { for (Object o : v) { return o; }
      return null;
    }


    public static Object first(Collection v)
    { for (Object o : v) { return o; }
      return null;
    }


    public static Object last(ArrayList v)
    { if (v.size() == 0) { return null; }
      return v.get(v.size() - 1);
     }



    public static ArrayList subcollections(ArrayList v)
    { ArrayList res = new ArrayList();
      if (v.size() == 0) { res.add(new ArrayList()); return res; }
      if (v.size() == 1) { res.add(new ArrayList()); res.add(v); return res;
       }
      ArrayList s = new ArrayList();
      Object x = v.get(0);
      s.addAll(v);
      s.remove(0);
      ArrayList scs = subcollections(s);
      res.addAll(scs);
      for (int i = 0; i < scs.size(); i++)
      { ArrayList sc = (ArrayList) scs.get(i);
        ArrayList scc = new ArrayList();
        scc.add(x); scc.addAll(sc); res.add(scc); 
      }
      return res;
    }

    public static HashSet subcollections(HashSet v)
    { HashSet res = new HashSet();
      if (v.size() == 0) { res.add(new HashSet()); return res; }
      if (v.size() == 1) { res.add(new HashSet()); res.add(v); return res;
       }
      HashSet s = new HashSet();
      Object x = null; int _i = 0;
      for (Object _o : v)
      { if (_i == 0) { x = _o; _i++; }
         else { s.add(_o); }
      }
      HashSet scs = subcollections(s);
      res.addAll(scs);
      for (Object _obj : scs)
      { HashSet sc = (HashSet) _obj;
        HashSet scc = new HashSet();
        scc.add(x); scc.addAll(sc); res.add(scc); 
      }
      return res;
    }


  public static ArrayList maximalElements(ArrayList s, ArrayList v)
  { ArrayList res = new ArrayList();
    if (s.size() == 0) { return res; }
    Comparable largest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (largest.compareTo(next) < 0)
      { largest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (largest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }

  public static ArrayList minimalElements(ArrayList s, ArrayList v)
  { ArrayList res = new ArrayList();
    if (s.size() == 0) { return res; }
    Comparable smallest = (Comparable) v.get(0);
    res.add(s.get(0));
    
    for (int i = 1; i < s.size(); i++)
    { Comparable next = (Comparable) v.get(i);
      if (next.compareTo(smallest) < 0)
      { smallest = next;
        res.clear();
        res.add(s.get(i));
      }
      else if (smallest.compareTo(next) == 0)
      { res.add(s.get(i)); }
    }
    return res;
  }


  public static HashSet intersectAll(Collection se)
  { HashSet res = new HashSet(); 
    if (se.size() == 0) { return res; }
    res.addAll((Collection) Set.any(se));
    for (Object _o : se)
    { res.retainAll((Collection) _o); }
    return res;
  }



  public static HashSet unionAll(Collection se)
  { HashSet res = new HashSet(); 
    for (Object _o : se)
    { Collection b = (Collection) _o; 
      res.addAll(b);
    }
    return res;
  }



    public static ArrayList concatenateAll(ArrayList a)
    { ArrayList res = new ArrayList();
      for (int i = 0; i < a.size(); i++)
      { ArrayList r = (ArrayList) a.get(i);
        res.addAll(r); 
      }
      return res;
    }



  public static ArrayList insertAt(ArrayList l, int ind, Object ob)
  { ArrayList res = new ArrayList();
    for (int i = 0; i < ind-1 && i < l.size(); i++)
    { res.add(l.get(i)); }
    if (ind <= l.size() + 1) { res.add(ob); }
    for (int i = ind-1; i < l.size(); i++)
    { res.add(l.get(i)); }
    return res;
  }
  public static String insertAt(String l, int ind, Object ob)
  { String res = "";
    for (int i = 0; i < ind-1 && i < l.length(); i++)
    { res = res + l.charAt(i); }
    if (ind <= l.length() + 1) { res = res + ob; }
    for (int i = ind-1; i < l.length(); i++)
    { res = res + l.charAt(i); }
    return res;
  }


 public static boolean isInteger(String str)
  { try { Integer.parseInt(str); return true; }
    catch (Exception _e) { return false; }
  }


 public static boolean isReal(String str)
  { try { Double.parseDouble(str); return true; }
    catch (Exception _e) { return false; }
  }

  }
}

