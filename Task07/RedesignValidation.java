import java.util.*;
public class RedesignValidation{
 static String old(int n){String s="";for(int i=0;i<n;i++)s+="field"+i+"="+i+";";return s;}
 static String revised(int n){StringBuilder s=new StringBuilder();for(int i=0;i<n;i++)s.append("field").append(i).append('=').append(i).append(';');return s.toString();}
 static long run(java.util.function.IntFunction<String>f,int n,int r){long s=System.nanoTime(),v=0;for(int i=0;i<r;i++)v+=f.apply(n).length();if(v==0)System.out.println();return(System.nanoTime()-s)/r;}
 public static void main(String[]z){int[]a={10,50,100,500};System.out.println("fields,original_ns,builder_ns");for(int n:a){run(Redux::old,n,50);System.out.printf(Locale.ROOT,"%d,%d,%d%n",n,run(Redux::old,n,1000),run(Redux::revised,n,1000));}}
 static class Redux{static String old(int n){return RedesignValidation.old(n);}static String revised(int n){return RedesignValidation.revised(n);}}
}