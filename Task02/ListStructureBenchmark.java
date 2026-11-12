import java.util.*;
public class ListStructureBenchmark {
 static volatile long sink;static long tm(Runnable r){long s=System.nanoTime();r.run();return System.nanoTime()-s;}
 public static void main(String[] z){int[] sizes={1000,10000,50000};System.out.println("size,array_end,linked_end,array_front,linked_front,deque_ends,array_middle,linked_middle,array_get,linked_get,array_iter,linked_iter");
 for(int n:sizes){ArrayList<Integer>a=new ArrayList<>();LinkedList<Integer>l=new LinkedList<>();ArrayDeque<Integer>d=new ArrayDeque<>();for(int i=0;i<n;i++){a.add(i);l.add(i);d.add(i);}int k=n/2,o=200;
 long ae=tm(()->{for(int i=0;i<o;i++)a.add(i);}),le=tm(()->{for(int i=0;i<o;i++)l.add(i);});
 long af=tm(()->{for(int i=0;i<o;i++){a.add(0,i);a.remove(0);}}),lf=tm(()->{for(int i=0;i<o;i++){l.addFirst(i);l.removeFirst();}}),df=tm(()->{for(int i=0;i<o;i++){d.addFirst(i);d.removeLast();}});
 long am=tm(()->{for(int i=0;i<o;i++){a.add(a.size()/2,i);a.remove(a.size()/2);}}),lm=tm(()->{for(int i=0;i<o;i++){l.add(l.size()/2,i);l.remove(l.size()/2);}});
 long ag=tm(()->{long x=0;for(int i=0;i<o*100;i++)x+=a.get(k);sink=x;}),lg=tm(()->{long x=0;for(int i=0;i<o*100;i++)x+=l.get(k);sink=x;});
 long ai=tm(()->{long x=0;for(int v:a)x+=v;sink=x;}),li=tm(()->{long x=0;for(int v:l)x+=v;sink=x;});
 System.out.printf(Locale.ROOT,"%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d%n",n,ae/o,le/o,af/o,lf/o,df/o,am/o,lm/o,ag/(o*100),lg/(o*100),ai,li);}
 System.out.println("ArrayDeque is efficient at both ends; it has no indexed access or efficient middle insertion.");}
}