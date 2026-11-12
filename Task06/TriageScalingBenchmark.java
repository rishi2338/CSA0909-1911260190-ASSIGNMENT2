import java.util.*;
public class TriageScalingBenchmark {
 static class P {final int severity;final long arrival;P(int s,long a){severity=s;arrival=a;}}
 public static void main(String[] args){int[] sizes={1000,10000,50000};System.out.println("patients,add_ns_per_patient,poll_ns_per_patient");
 for(int n:sizes){PriorityQueue<P>q=new PriorityQueue<>(Comparator.comparingInt((P p)->p.severity).thenComparingLong(p->p.arrival));long s=System.nanoTime();for(int i=0;i<n;i++)q.add(new P(i%5+1,i));long add=System.nanoTime()-s;s=System.nanoTime();while(!q.isEmpty())q.poll();long poll=System.nanoTime()-s;System.out.printf(Locale.ROOT,"%d,%d,%d%n",n,add/n,poll/n);}
 }
}