import java.util.*;
public class PharmacyInventory {
 static long lookup(Map<String,Integer> m,List<String> k,int r){long s=System.nanoTime(),v=0;for(int i=0;i<r;i++)v+=m.get(k.get(i%k.size()));if(v<0)System.out.println();return System.nanoTime()-s;}
 public static void main(String[] z){int[] sizes={100,1000,10000};int reps=100000;System.out.println("size,hash_ns,tree_ns,linked_ns");
 for(int n:sizes){Map<String,Integer>h=new HashMap<>(),t=new TreeMap<>(),l=new LinkedHashMap<>();List<String>k=new ArrayList<>();for(int i=n-1;i>=0;i--){String x=String.format(Locale.ROOT,"MED%06d",i);k.add(x);h.put(x,i);t.put(x,i);l.put(x,i);}System.out.printf(Locale.ROOT,"%d,%d,%d,%d%n",n,lookup(h,k,reps)/reps,lookup(t,k,reps)/reps,lookup(l,k,reps)/reps);}
 Map<String,Integer>t=new TreeMap<>(),l=new LinkedHashMap<>();String[]c={"MED103","MED101","MED104","MED102"};int[]q={40,12,8,25};for(int i=0;i<c.length;i++){t.put(c[i],q[i]);l.put(c[i],q[i]);}System.out.println("Code order (TreeMap): "+t);System.out.println("Insertion order (LinkedHashMap): "+l);}
}