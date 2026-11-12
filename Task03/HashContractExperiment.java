import java.util.*;
class BrokenStudent {
 final String regNo; BrokenStudent(String r){regNo=r;}
 public boolean equals(Object o){return o instanceof BrokenStudent && regNo.equals(((BrokenStudent)o).regNo);}
 // Intentionally no hashCode override: this demonstrates the contract violation.
}
class MutableStudent {
 String regNo; MutableStudent(String r){regNo=r;}
 public boolean equals(Object o){return o instanceof MutableStudent && regNo.equals(((MutableStudent)o).regNo);}
 public int hashCode(){return Objects.hash(regNo);}
}
public class HashContractExperiment {
 public static void main(String[] args){
  Set<BrokenStudent> broken=new HashSet<>();broken.add(new BrokenStudent("R001"));broken.add(new BrokenStudent("R001"));
  System.out.println("Broken class set size (implementation-dependent hash placement): "+broken.size());
  Set<AttendanceKey> fixed=new HashSet<>();fixed.add(new AttendanceKey("R001"));fixed.add(new AttendanceKey("R001"));
  System.out.println("Correct class set size: "+fixed.size());
  MutableStudent m=new MutableStudent("R002");Set<MutableStudent>s=new HashSet<>();s.add(m);m.regNo="R003";
  System.out.println("After key mutation, contains mutated object: "+s.contains(m));
 }
 static class AttendanceKey {final String id;AttendanceKey(String s){id=s;}public boolean equals(Object o){return o instanceof AttendanceKey&&id.equals(((AttendanceKey)o).id);}public int hashCode(){return Objects.hash(id);}}
}