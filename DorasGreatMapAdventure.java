/**
 *   If client creates a "hash" DorasGreatMapAdventure, key will have a reasonable hashCode, the associated set contains Objects
 *   If client creates a "tree" DorasGreatMapAdventure, key will implement Comparable interface as required by the TreeMap() class,
 *                                                                          the associated set contains Objects

// Michelle Duong
// mr. allen helped, and akshay, for one method nathanael, chris helped on toString
 */
import java.util.*;


public class DorasGreatMapAdventure<K,V>{

/**
 *   Thou shall add NO methods that that modify any properties of iAmTheMap.
 *   Modify any properties of iAmTheMap may cause you other methods to fail toString() testing
*/
    private Map<K, Set<V>> iAmTheMap;
    
/**
 *   Thou shall not modify the constructor.
 *   Modify the constructor of iAmTheMap may cause you other methods to fail toString() testing
 */
    public DorasGreatMapAdventure(String type) {
        if ("hash".equals(type))
            iAmTheMap = new HashMap<K, Set<V>>();
        else if ("tree".equals(type))
            iAmTheMap = new TreeMap<K, Set<V>>();
        else
            iAmTheMap = new HashMap<K, Set<V>>();
    }

/**
 *      returns the set of keys from iAmTheMap
 *      I know, I gave it to you.
 */
    public Set<K> keySet() {
        return iAmTheMap.keySet();   
    }

/**
 *      returns iAmTheMap - Just in case there is a DorasGreatMapAdventureTheSequel
 *      I know, I gave it to you.
 */
    public Map<K, Set<V>> getMap() {
        return iAmTheMap;
    }
    
/**
 *      returns the total number of items in the iAmTheMap
 *      That is, the sum of the size of each set assocaiated with all keys
 *               plus the number of keys
 *               redundant items are counted multiple times.
 */
    public int size() {
        Set<K> mySet = keySet();
        int count = mySet.size();
        //System.out.println(count);
        for(K obj : mySet)
           count += iAmTheMap.get(obj).size();
        return count;

        }
    

/**
 *      returns the total number of non key items in the iAmTheMap
 *      That is, the sum of the size of each set assocaiated with all keys
 */
    public int numItems()
    {
        Set<K> mySet = keySet();
        int count = 0;
      
        for(K obj : mySet)
           count += iAmTheMap.get(obj).size();
        return count;
    }

/**
 *      returns the total number of distinct non key items in the iAmTheMap
 *      That is, the sum of the size of each set assocaiated with all keys,
 *               not counting duplicates
 */
    public int numDistinctItems() {
        ArrayList<V> done = new ArrayList<V>();
        for (Set<V> set: iAmTheMap.values())
         {
             for (V v: set)
             {
                 if (!done.contains(v))
                 {
                     done.add(v);
                 }
              }
          }
        return done.size();
    }

/**
 *      returns true iff
 *           iAmTheMap is Empty or all sets in the Map are Empty
 *      otherwise returns false
 */
    public boolean isEmpty() {
        return iAmTheMap.isEmpty();
}

/**
 *      returns true if a one or more associated set contains diego
 *      otherwise (no set contains diego) return false
 *      
 */
    public boolean contains(Object diego)
    {
        Set<K> mySet = keySet();
        for (K obj : mySet){
          if (iAmTheMap.get(obj).contains(diego)) 
          {
          return true;
        }
      }
      return false;  

     }
    
/**
 *      returns an array containing all elements from the associated sets
 *      items may appear in the array more than once
 *      keys are not to be added to the array
 */
    public Object[] toArray()
    {
        Object[] ans = new Object[numItems()];
        int here = 0;
        for (Set <V> set: iAmTheMap.values())
        {
            for (V v: set)
            { ans[here]= v;
              here++;
            }
           }
                
         return ans;
    }
    
/**
 *      add tico to the set associated with key.
 *      If key is not in iAmTheMap, add a new Set containg tico as its sole member
 */
    public void add(K key, V tico) 
    {
        Set<K> mySet = keySet();
        Set<V> myList;
     if(iAmTheMap.keySet().contains(key))
     iAmTheMap.get(key).add(tico);
     else
    {
     myList = new TreeSet<V>();
     iAmTheMap.put(key, myList);
    }
   iAmTheMap.get(key).add(tico);

       }
    
/**
 *      if tico is in the Set associate with key
 *          remove tico from the set associated with key.
 *          if the Set becomes Empty, remove the key from iAmTheMap
 *      otherwise (tico is not in the Set) 
 *          - do not throw an exception, that is exit the method gracefully
 */
    public void remove(K key, V tico) {
        Set<V> set = iAmTheMap.get(key);
        if (set.contains(tico))
        {
            iAmTheMap.get(key).remove(tico);
            Set<V> set2 = iAmTheMap.get(key);
            if ( set2.size()==0)
            {
               iAmTheMap.remove(key);
            }
         }
        
    }
    
/**
 *      remove isa from all sets
 *          if the Set becomes Empty, remove the key from iAmTheMap
 */
    public void removeFromAll(V isa)
    {
         Set<K> set = keySet();
         ArrayList<K> frown = new ArrayList<K>();
      for (K k : set)
      {
          if ( iAmTheMap.get(k).contains(isa))
          {
              frown.add(k);
           }
       }
      for (K kk: frown)
      {
          Set<V> set2 = iAmTheMap.get(kk);
          if (set2.size() == 1)
          {
              iAmTheMap.remove(kk);
            }
            else
            {
                iAmTheMap.get(kk).remove(isa);
            }
        }
}
        
    
    
/**
 *      Every key in this.iAmTheMap is a key in otherDorasGreatMapAdventure.iAMTheMap
 *      Every key in otherDorasGreatMapAdventure.iAmTheMap is a key in this.iAMTheMap
 *      Each pair of set for a given key are equal
 *           that is,  iAmTheMap.get(key).equals(otherDorasGreatMapAdventure.iAmTheMap.get(key))
 */
    public boolean equals (Object otherDorasGreatMapAdventure) {
        
        return otherDorasGreatMapAdventure.equals(iAmTheMap);
    }
    
/**
 *      The String should be of the form:
 *      "{key.toString()=iAmThemap.get(key).toString(), <repeat for all keys>}
 *      a single = between key and set, with a comma and a single space between each key set pair
 */
    public String toString() {
        Set<K> mySet = keySet();
        //int s = mySet.size();
        String ans = "{";
        for ( K k : mySet)
        {
            ans = ans.concat(k.toString());
            ans = ans.concat("=");
            ans = ans.concat(iAmTheMap.get(k).toString());
            ans = ans.concat(", ");
        }
        
         ans= ans.substring(ans.length()-2); 
        
            
        
        ans = ans + "}";
        return ans;
    }

// stuff added after attempt 1
    
/**
 *      Finds the largest value in all the sets contained in the map.
 *      You should assume that all Sets contain comparable items
 *      and that all sets are Comparable to each other
 *      DorasGreatMapAdventure is NOT empty
 */
    public V maxItem()
    {
        //return (V) new Object();
     
     
      
        ArrayList<V> done = new ArrayList<V>();
        for (Set<V> set: iAmTheMap.values())
         {
             for (V v: set)
             {
                 if (!done.contains(v))
                 {
                     done.add(v);
                 }
              }
          }
        V max = done.get(0);

        for ( int x = 0; x < done.size()-1; x++)
        {
            if ( (((Comparable)max).compareTo ( (Comparable)done.get(x+1)) < 0))
            {
               max =  done.get(x+1);
            }
        }
      

     return (V) max;


    }
}