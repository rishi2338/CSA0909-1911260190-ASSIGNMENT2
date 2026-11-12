import java.util.*;
public class StringConstructionBenchmark {
 static String plus(int n){String s="";for(int i=0;i<n;i++)s+="FIELD"+i+"="+i+";";return s;}
 static String builder(int n){StringBuilder s=new StringBuilder();for(int i=0;i<n;i++)s.append("FIELD").append(i).append('=').append(i).append(';');return s.toString();}
 static String buffer(int n){StringBuffer s=new StringBuffer();for(int i=0;i<n;i++)s.append("FIELD").append(i).append('=').append(i).append(';');return s.toString();}
 static long measure(java.util.function.IntFunction<String> f,int n,int reps){long st=System.nanoTime(),sum=0;for(int i=0;i<reps;i++)sum+=f.apply(n).length();if(sum==0)System.out.println();return (System.nanoTime()-st)/reps;}
 public static void main(String[] z){int[][] w={{6,1},{50,10000},{500,1000}};System.out.println("fields,tickets,plus_ns,builder_ns,buffer_ns");for(int[] x:w){measure(StringConstructionBenchmark::builder,x[0],Math.min(100,x[1]));System.out.printf(Locale.ROOT,"%d,%d,%d,%d,%d%n",x[0],x[1],measure(StringConstructionBenchmark::plus,x[0],x[1]),measure(StringConstructionBenchmark::builder,x[0],x[1]),measure(StringConstructionBenchmark::buffer,x[0],x[1]));}}
}