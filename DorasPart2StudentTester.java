import java.util.*;
import java.awt.*;

public class DorasPart2StudentTester extends junit.framework.TestCase
{
// test size
/**
 *      if tico is in the Set associate with key
 *          remove tico from the set associated with key.
 *          if the Set becomes Empty, remove the key from iAmTheMap
 *      otherwise - do not throw an exception, that exit the method gracefully
 */
    public void testRemove_key_Object01()
    {
       String problemMessage = "Remove_key_Object test 1";
       int[] setSize = {5, 3, 1, 2, 4};
       ArrayList<Set<String>> answerSet = new ArrayList<Set<String>>();
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       ArrayList<String> correctArray = new ArrayList<String>();
       for (int i = 0; i < setSize.length; i++)
       {
          answerSet.add(new HashSet());
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerSet.get(i).add(""+j);
          }
       }
       first.remove(new Integer(4), "0");
       answerSet.get(4).remove("0");
       int setIndex = 0;
       for (Integer keys : first.keySet())
       {
          Set<String> mySet = first.getMap().get(keys);
          Set correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }


/**
 *      remove isa from all sets
 */
    public void testRemoveFromAll01()
    {
       int[] setSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       ArrayList<Set<String>> answerSet = new ArrayList<Set<String>>();
       for (int i = 0; i < setSize.length; i++)
       {
          answerSet.add(new HashSet());
          for (int j = 0; j < setSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerSet.get(i).add(""+j);
          }
       }

       first.removeFromAll("1");
       for (int i = 0; i < setSize.length; i++)
       {
          for (int j = 0; j < setSize[i]; j++)
          {
             answerSet.get(j).remove("1");
          }
       }

       int setIndex = 0;
       for (Integer keys : first.keySet())
       {
          Set<String> mySet = first.getMap().get(keys);
          Set<String> correctSet = answerSet.get(setIndex);
          assertEquals(correctSet.size(), mySet.size());
          for (Object correctItem : correctSet)
              assertEquals(true, mySet.contains(correctItem));
          setIndex++;
       }
    }

/**
 *      This allows me to take the union of two DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are in either Map.
 *      For keys that are in both Maps, the associated Sets will be a union of the two sets
 */
    public void testMapUnion01()
    {
       Map<Integer, Set<String>> answerMap = new TreeMap<Integer, Set<String>>();

       int[] firstSetSize = {5, 3, 1, 2, 4, 2};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < firstSetSize.length; i++)
       {
          answerMap.put(new Integer(i), new HashSet());
          for (int j = 0; j < firstSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
              answerMap.get(new Integer(i)).add(""+j);
          }
       }

       int[] secondSetSize = {5, 3, 1, 2, 4};
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
       for (int i = 0; i < secondSetSize.length; i++)
       {
          if (answerMap.get(new Integer(i*2)) == null)
             answerMap.put(new Integer(i*2), new HashSet());
          for (int j = 0; j < secondSetSize[i]; j++)
          {
              second.add(new Integer(i*2), "" + (10 + j));
              answerMap.get(new Integer(i*2)).add("" + (10 + j));
          }
       }
       DorasGreatMapAdventurePart2<Integer, String> union = first.mapUnion(second);
       assertEquals(union.getMap(), answerMap);
    }


/**  returns a DorasGreatMapAdventure implemented with a HashMap
 *      This allows me to take the intersection of DorasGreatMapAdventure implemented with TreeMaps and HashMap
 *
 *      the returned Map will contains the keys that are only in both Maps.
 *      the associated Sets will be an intersection of the two sets
    public DorasGreatMapAdventure setIntersection(DorasGreatMapAdventure backpack)
*/
    public void testMapIntersection01() {
       Map<Integer, Set<String>> answerMap = new TreeMap<Integer, Set<String>>();

       int[] commonSetSize = {5, 3, 1, 2, 4, 2};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       DorasGreatMapAdventurePart2<Integer, String> second = new DorasGreatMapAdventurePart2<Integer, String>("hash");
     ?%fof0(nt i = 09 k < c???on[e6si~E<legctl: i;+h #   (b{
, 0""  ! `answErMqt.x?p,n%w A
te'??(k),(nEg HashS%4())9?  00 `@ b?r!(hn? ? =$0;,j`< c/moonwUtSir%[i]; k++!
    ?8 0  z
  ?   ?0    $fmpst,idf)?w InDegar*i), ""j);?($    ?" 0   3eon?.adF(nw Intdoer(i?,D"* + h):
   !       ?`?enqwgMap/Ge`(?ew H&uuger,))?.a?dh""kb)
  `      `}
` `    }

      int[? fyr?ps?tS?ze$ {2, 3,"?d 1!,?4- 3, 10};"??    gnb ha.| m$< 3 a(< f?qstSetS+ze,he?o|h; i;+)
    !  {
   $    (f?r (mnv j = 0r j ? f?:svSe4iza[i\; *++)
!(#  ! !  { `      !" ? fi2st?add8~ewjYnte'er ?+(,!b" + (10?+ j)m;? 0     ?  }
   ( ` }
`      yotY] cesondSuTSi~e?? ;7$ 8,!6< 1<"?,4$a4, ?,"6, 4};J?   ( 0for$(i?u i = 03?i < sEc?ntRetsijm.?ength; i;#)J     `z?` ($  ("  ~or j?otaj = 0: *$<,slcondUetSkzeZ?;?k++)
 0 0" !  (k
   ?h   $   $sekond.a`e*n%w`	ntager(i+22)."?b + *20 +!j)+9
 "0  ? "` |   ?0 }J(     $TorasGree~MaaAdven|t2aTart2<	n4egap,?Ctr?ng>!I~6urs}?$?o,$9 6irst(eap)ndercdcdion(seko^|;;
b 0$  assertEqu?m?()ntercactzkn.getIcp(+$ answmrMap){
    y
/("  bdturns c DorasGreatMepA$renDure?k??leMent?d witi a?H?shMa0
 *"$   !R?is(??low3`me Qo take vAd!di?ferense of(To~asGreatMarAdventuB% iepl?m?mted yTh EreeMaps$ao$ ?asha`
 
 (`  "  th! ^etu2ned Ear wal, go/tainv thg Kuy{ that ?re ?n This/iAmDheMap.
 * "  $`no? e%ch ?ey ?N this.i@mTj%Max, if Th!t key i3`in swit??,
 *( $   tje$assnciEued$qET isathe r%? dinfgrEnca Of th)s.iAmDimMap m swiser.lAmDheLap
    publ)c!D?rasG?gatMapAdVenture ma?iffebu~#m(DoviGreatKapAdvEntuze r7iRer9
/
!   qubnik rfid?t%stOQxDi?ference 1(+ {
    $0 Mqp<Inte'er, Sat4Strin'>> ajCw!zmapb=(New ?reeMap<Hnteger, REv<String>>));

(     ?int[] anqwe:SetSixe =?{0- 4, "};
    `"  Lm?asGriavM?pA`venturePa2?6<Integer, Strqno>`nir3d ?`neW DorisGre`~MapAd~entuRuPaRu2<inteear, Suring>("t?%E*);p     !DorisGru?t?aQAdven45rePa?t2>Integev. Strknc> seco.d = nuw Gor!sr?aTMApAFVenttp?Pcrt6>InTeger, String>("jash"){(?     fov (knt i = p; i 4 e.qwerSeTIze.nengtl; i++)
"    !?S
     !  0 !nswarMaP,t}p(&es Mftee?r?i), neu HashSet())3*         $for (iNt 
 ? 0:!j < AnswdrSetSaZe[i]; j+)
  `   (   
   ?   ?%`   givsT.add(new I?pegev(i), ?"+ji;
      ?  `    ansuerMcp?get8n%w 	nDegmp(ii)&ad.h""+j)+
         !}
  "  ,$}
 (  `  int[ girstSgt?ize"= {2,"3, 7,(12, t, 3, 50};
    !&0for ,ylt$i =?0;"i 8$fIrstSet?ije.lengTh; i/+)
  "" $ {
 !!0  ?   &os(?nt j = 0:(j 8 &ir3TSmTS)ze[A]? j+;	
  `       {
  ?"` 0?  `   vibsxnadd8nmw?I*tegez(i+12+, "" / (10 + j))3
 (          `"secnnd.add(New Inv%gdr(i+1qi((""(+ (10 +?j))` !$  "  ?
!     (}
   0   o?isGRaitMa?Alventur?Part?4Intefes, Sdring> DiffevenCe = f?rst.mqp@ivferdncd(second);
?0  ` $asseptAquals*dIffgzence/getMap)), ansgerMat);  (?}J
/*"
 ?  " ! vetuvn?0true ifd
 #"? (   0 oor"each kuy`yn ThisiAmU`eMap,(backpac{.iEeTheMap conTakn?"|he came ?ey
 *      (  viiw.iAmTheMa?.?e?(k?y)"is A subsev of baskpcck.iImT(eM?.get?[!+* ( ! 0note:  t(ks al|ows bo|h$Mcts sn be(equa|
 *   ?  ?t(ebwis%!retWro f!Lwa
  $!?ublic coolain iySubmcxKv(DoracGrdyvapAd6ejture backpAcc) {
*/
` ? ?}blic void pestKsSubm`p_n00h)  `${
`   4?  int[] insErWeQQi:e$= {2, $> 2, ?3,d5,(20};J    ?  $?rd?GreaDMa?A?v?nturePprt2<Int?ger, S4ring? fjrst = new"DovcsGreauM?pE$venTure@Apt:<:ndegdr, Qtpinc6x"tree");
   ! p`DnrasS?eaTMap?tven?urEXart2<I?tf?esl Spri.g> secood = n%w DgRasreapEqpAdwenpebdap?2<?ntegazl CurInf>"hesh");
     ` dos (mnt I 5!?; i?< anssm?SevSire.hength{ i++)       {
   ?  ? %$vor (int"j = 0; b <(An??ez?%tSije[i];$j+9
$? $(  ? {
$    ( "!  0 1firrt.atD(nf k,tdger"m)-*"+j);
 (     !  0 H s?cond.aed(oe Il4%?e?(i?, j"+j);  ?  <  p$}
?   0 h}
 % 0  $assurtEquals(tVue, firsu.isSuj?CpO?,b?conn)h;
  `! 0 isSERtquu,s?pzw$, cec?n?.isStbmapffIbst-+
  ((0 ?fifc|/ale(new$AndeGep(91), #(elq#); $  ?!  asSe?tEquel?,Nalse,$'ars|.i3SubmqpOv(saoond);
   & ! segon?.aed(new`?NtEcer(Yy), bieLq"+;
 ?     se#onlnadd)nEw4IN4agdr(89+, "mU");   01 $awsgr|Eq}a?s?tqq?,!girst?isSub}gxOF<wecondi-;
$! ? d aqser???ual[(va,se= sekoNliSSubmapM?(?r?T?){J $ ,}
/+*
0*(0" ? zmtur~3 dRue h?f
 *   ?    #&?v eabh?key!in 4(yS/?QM\jemapl bqbktack.iAmFheMap?coNtaans 4xe saiE$kdy
0   !`    t Is-iE?Themap.getce9)"ys `"prO1?r suc?eu od backra?k+kAm`gMqP?oat(key) fgr ewery Ke? a~`kAmTheOap.jgyS-|()
 *!  2  l/te: cthys implies that no sets`Ara ?qu`Ln
 *    $ ~dhesvi3e$rettrn"false
   (p5blis pmmleqn!IsPR?pErSubmepO?(Dor?sGreAtM`pCTventurE s)`*/
  b"t?b,ic vnid(testIsPropmr[5"laPOF00)9
 !  }
  0   {nv[? afsgerSETSiZe ? ;2, 4, 2,`!3? 7, 21}3j"  `a`? Dor?sGra!dMapAdventubaPa2u2<iNtggev. S?2hng< fmpst$= .iw DorasOreqt]avdtgftUSePart2=i?t?ge2,(St?ing>?"|vee");
?   4! Dor?sGreatMApAdventureParv2<?n}mweR&?Stving>`seconD ?"new?Do{AsGreatMaYAdvejTuraPer`2<INveoer wtrin?>("harj");
!  ?"? forp(int i = 0;pi < enswevCetSize.n%k?vd; i/+)
?  ( `(?
      !  fkr ()nt *(= 3* j0<$ancsg{Set[i~e[i]{ j)))
(80 ($   ?{
  !   0      1gir{r.a?d(new ?ndeeer(i),!"+j);
0  !! `  `  h se?o?l.q?d(ngw I.teG%r(]?? ""+j(;
   0   !  }J    $  }O
1  `?$ As{eptEquals)Gc,se, fivvt.iSProterS?b?apOn(sdcon`-);   ""  asCes|Dyuc,s(Falsa, s?Cknd.isPro?e?Sq&mapOf(fyvct));  `(&? first/add(nuw(IvteGes()9), "helx"/;
"`     as?espAquals(falseh fers?.abProperSubmapOF(Secofd));
?  " ! aqsertUqualS(True. cebondisPr-0ar[ubmapOFfisst)?;!    H svconf.addhnew Inteeer(99), "|elp");*       s?cond.adl(~e In|dgev(9?9, &m-");
  ?  ` asuertdyu?ls(True, farrt/9cPpoqerSubmapOv(seco.d(+;
  , 0  a3sertUquamw(falsu$ sdcond.ks?r/pmRSu?mePOf?first)!;
"   }

+:* *!  (  Remmv?3 all m?ppi.g3?from this"mat
!*  public`vgkD2rdearh) 
*/
  $ ruflic"v?id t?StCleiv03()
  $$[
      !i?t[] ao1werSudSize = {24-$12, 1, 5, 2, 0, 1:, 32$ 56- 1* 1  4,"2,$3."8?"9}?
?   `  @oras?rgctMaxA$ventur%Rirt3<MntegE2, STrmn&?"firsT`?$new Dor?sGpeqtMipAdventwreart28Iftegd?$ Adri?w&(lbeu#)+
       fe2 (int!i = 0+ i(<0answeRRetWize.mength; i*+?
     0"{
  !"  $ ! fgb (imd j =`0;!j < answ?rSelS)je[i]; *++)
  $?      {
  0  0  $  (  fIrst.add)few IftMgmr(i)< "b+j);
(  ?  $0  }
!  ??  }

     0 a3sertEquals(answerSetSize.lefgp`,"gir{tnkeqSuv().siz?()??
a   `$ fivst.slaar()?
   (!" assept?1Uals(0, fir3t.kgySe4(),s?ze()?;
  0 }J  ? 
o.(
 8 $   th%"set as{ociated`Viph"key is mm05)%d":  p?blic void?glea2KeI(Objd?t0isA)*'
    public!voIt testBleaRKey09)
 !  {
       inu[] answ%`S??SiRe = {20. 12,b91, 5- r01<`1:,!32( 12,!3, 11, , 4, 7, 8, 9};  0  $ ?o2asgrua4MaxAtvejtubePErp?<Intufur, Stro.g6 fir3| 5 new Do?asGrwatEapAdtendurePart2<IntEgmr, STping?(2treg");?      fgr (int k =( ; i < AnsweRSuu?mze.len?v(; i++)
 % ?? $?
 ?  ( $ `for (in|?j(, 0; j < ansW%rSdtS)??[i]; j++)Z?       ?!?
  !`    `(!"  first.qde(o%w Intege?(h). ""+ji;?        $ m
"   ?  

   $0 (asse`tEquil{(a??v?rS%tSI?e?lelg|`- first.keySat(+.siz%())?
" "   (.ibst.cly?rKey,new Iotege2(0)	;
( !  ` first.BleacJey(?ew?	nteGe6(anqwezS?t?kza&hmlgd`-4))3
6      asseptEqtels , fKb3p.gEtMap().Gev(.ew Integdr0)-.siZe(?);
  ?  ! awsar?Dq?al{(0, fibst.ggtMap().geT(neW K&4egur(ansgarset[izd.|efgth)1),.s?ze())?
   0   foj ,i?t i&= 9? i"<"ansWerSe4?qze*?e.gvh-1; i+*)J?`    9
!  `   0   acsertEqua??(answer?otsire[i],0f?srtnGetMap((.ged
o'?4Inveger(i)).size(-)=
  0    }
 ?  }
*/**
 *      returns the number key-value mapping in iAmTheMap
    public int numMappings() 

 */
    public void testNumMappings01()
    {
       int[] answerSetSize = {2, 4, 1, 2, 1, 3, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       DorasGreatMapAdventurePart2<Integer, String> first = new DorasGreatMapAdventurePart2<Integer, String>("tree");
       for (int i = 0; i < answerSetSize.length; i++)
       {
          for (int j = 0; j < answerSetSize[i]; j++)
          {
              first.add(new Integer(i), ""+j);
          }
       }

       int[] moreSets = {2, 4, 1, 2, 1, 3, 5, 2, 1, 12, 32, 12, 3, 11, 4, 6, 7, 8, 9};
       assertEquals(answerSetSize.length, first.numMappings());
       for (int i = 0; i < moreSets.length; i++)
       {
          for (int j = 0; j < moreSets[i]; j++)
          {
              first.add(new Integer(answerSetSize.length+i), ""+(i*10+j));
          }
          assertEquals(1+answerSetSize.length + i, first.numMappings());
       }
    }
}