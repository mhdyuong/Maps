import java.util.*;

/**
 * Write a description of class DorasGreatMapAdventurePart2 here.
 * helped by akshay in the first method
 * @author Michelle Duong
 * @version 
 */
public class DorasGreatMapAdventurePart2<K, V> extends DorasGreatMapAdventure<K,V>
{

/**
 *   If client creates a "hash" DorasGreatMapAdventure, key will have a reasonable hashCode, the associated set contains Objects
 *   If client creates a "tree" DorasGreatMapAdventure, key will implement Comparable interface as required by the TreeMap() class,
 *                                                                          the associated set contains Objects
 */
	public DorasGreatMapAdventurePart2(String type) {
		super(type);
	}

/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the union of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are in either Map.
 *      For keys that are in both Maps, the associated Sets will be a union of the two sets
 */
	public DorasGreatMapAdventurePart2<K, V> mapUnion(DorasGreatMapAdventure<K, V> boots)
	{
	    DorasGreatMapAdventurePart2<K, V> union = new DorasGreatMapAdventurePart2<K, V>("Hash");
	    Iterator<K> m = this.getMap().keySet().iterator();
	    while ( m.hasNext())
	    { 
	        K temp = m.next();
	        Set <V> s = this.getMap().get(temp);
	        Iterator<V> t = this.getMap().get(temp).iterator();
	        while (t.hasNext())
	        {
	            union.add(temp, t.next());
	         }
	        
	    }
	     Iterator<K> m2 = boots.getMap().keySet().iterator();
	    while ( m2.hasNext())
	    { 
	        K temp2 = m2.next();
	        Set <V> s2 = boots.getMap().get(temp2);
	        Iterator<V> t2 = boots.getMap().get(temp2).iterator();
	        while (t2.hasNext())
	        {
	            union.add(temp2, t2.next());
	         }
	        
	    }
	  
		return union;
	}

/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the intersection of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are only in both Maps.
 *      the associated Sets will be an intersection of the two sets
 */
	public DorasGreatMapAdventurePart2<K, V> mapIntersection(DorasGreatMapAdventure<K, V> backpack)
	{
	    DorasGreatMapAdventurePart2<K, V> intersection = new DorasGreatMapAdventurePart2<K, V>("Hash");
        Set<K> m1 = this.getMap().keySet();
        Set<K> m2 = backpack.getMap().keySet();
        Set<K> keys = new HashSet<K>();
        for( K k: m1)
        {
           if (m2.contains(k))
           {
              keys.add(k); 
            }
        }
        for ( K kk: keys)
        {
            Set <V> s = this.getMap().get(kk);
            Set <V> sb = backpack.getMap().get(kk);
            Iterator back = sb.iterator();
            while (back.hasNext())
            {
               s.add((V)back.next()); 
            }
             Iterator all = s.iterator();
             while ( all.hasNext())
             {
                intersection.add(kk, (V)all.next()); 
              }
            
	       }
	    return intersection;
	}

/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the difference of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are in this.iAmTheMap.
 *      for each key in this.iAmTheMap, if that key is in swiper,
 *      the associated set is the set difference of this.iAmTheMap - swiper.iAmTheMap
 */
	public DorasGreatMapAdventurePart2<K, V> mapDifference(DorasGreatMapAdventure<K, V> swiper)
	{
	    DorasGreatMapAdventurePart2<K, V> difference = new DorasGreatMapAdventurePart2<K, V>("Hash");
        Set<K> m1 = this.getMap().keySet();
        Set<K> m2 = swiper.getMap().keySet();
        Set<K> keysInBoth = new HashSet<K>();
        Set<K> keysInOne = new HashSet<K>();
        for( K k: m1)
        {
           if (m2.contains(k))
           {
              keysInBoth.add(k); 
            }
        }
        for ( K k1: m1)
        {
            if ( !keysInBoth.contains(k1)  )
            {
                keysInOne.add(k1);
            }
        }

        for (K m : keysInBoth)
        {
            Set<V> v1 = this.getMap().get(m);//
            Set<V> v2 = swiper.getMap().get(m);//
            for ( V v: v2)
            {
               if (v1.contains(v))
               {
                   v1.remove(v);
                }
            }
            Iterator iter = v1.iterator();
            while( iter.hasNext())
            {
                difference.add(m,(V)iter.next()); 
            }
            
        }
        for ( K s : keysInOne)
        {
            Set<V> t = this.getMap().get(s);
            Iterator it = t.iterator();
            while(it.hasNext())
            {
               difference.add({.((V)id.?ext());
 `    $   "??-
    (   }
	   pre??r? digfe2ence;)w
	
/** *   ` `returns$true mff
 +?  ? $ `0f?r each`;ei?iN dlas.iCeTheMep,!rackpa??.i-th?Mqt?cont`kns ti? sqe? {?y?
 *  , ((?  phIs.aA-W dM?p.eet0jey) ic a cubsev of  ac?pAck.?ImTheOapngdt?k?
0* ? 0 "l/~e:  this"anlwq both Mapc do be?eqqelO
 * $    OthGx7isu return false
 */Ixublic`booleaj isSuflqpOf:dorisGrMatLapAdventure=K$ V~ backPick {		Set<K> s `t(?sngetMap().i%?Set(?3M
		S?T<K>(s2#= bscKpick.fetMap()>keySeT()?	
		`.v cnt = c.c+ze();
		I?mzator iv  siua2?Tor()?			w?ime( it.hAsNext())
	{*		 0in ({3.contains(ip.n?xt()()
		  {
		  $  bnt-; 
  $!      ]
	}		if *!?cn4==0)) returf fdlse;?		int cnt2 = S.size(?;
?	&k2( K c: s)
		{		   @Qet<V>!v1 = this.cetmap(+.ged(g=;
		 ?  e|<(v3 9 bac{pub+,getMap(i&gep(k);
	   $ynu cft# = v3,sizg()+	" 0 iTerat/r it"?= v1*i?erator));
I    kkl? 	it2.?a{N?xt())
	! ? ;
		  $    `h$ (0v3,conteijs(id2.?ext()))
		  "     {		   (   b"   cj}3--?
	    !   ! ???		     (}?		 (  iF (cnts = 0-		   `"$cnt2/-; 
		    ?mse
	)  `"` zetubn false;
	   }
		if ( cnt2 ==`8)
	I  return tree;
		  return fa|su;9}
	M?/**?
 ( 0    ?g?ur.s8true inf
 *   ?$! !!fkr ea?? kgy aj thir.iAmTheMap, baokp#ck.iA?TheMap aontamns the ?ame key
 *0"  0   `vhis.iAmth?O?p.gmt,Kex)$is a suBset kf backPack*ii\heMap?ggt(k?y) foz!dvery key in iImTheM1p.kmySut() *`   $    sith this.iAmDheMapnc!t(ke?) Is a tsoper?sufse?$of backpack.IUmT`eM`p.get,ke?) for qt?ea3t one key in iAmEheaq.keySet )
`"      oote:?$phiw impliec tiat eq}al set3 @pe$?OT psoqerSubse4s.
!*  ?   oth?rwise re?urN Falce
?
/
IpUblib$"oomean )sRroperSukmap_f(Lov!sGreatMapAdten4ure<O, V. s) {
$(" 
	 0 ?returj this?isSu?mapOf({) &&!!s.getMap().equals(this.getMap());
	 $"}
		
	-


/**
 (  "$ $Re}kves `ml mappi.g# drom?hks`Map
 *( powtCoNeidion:  keyWet().size() }= p*"*/M
Ipublic foid clecr()(?
	    
	  ! thi{.getMqp()cle`r();

	]
)
/**
 *  ? " t`m smp associatm` w?th Kcx is?`is emptied
 (  `osuCoNdiTio?:  getIap).get(isa).sIzG() == 0 *    "$if isa ys nnt a$key
"j !      $ ?!do not throw a? exceptiol?`tlat is ax)t0the?method grace?uLly" +/
	puBdic ?oyd"cneazKey(?"isA?`{M
) SEu<?> {gt$=(this.getMpp().KeySev,	?
	 /v s =? null;
	 if ("set.cont?i~s(x?a))
	 ;
	   vhiw.?ut?ip().get(isa).glear();
	 }
	   `
	  ` J
	}

/**M
 j!     rgturow t?e number key-value mapting in m@mVheMap */
	p}bl?c ynt num?appi?gs() {
?	return vhhs.getMat(.keySmt(+.size();
}
}