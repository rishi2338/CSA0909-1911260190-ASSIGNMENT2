import java.util.*;
class Student {private final String regNo,name;Student(String r,String n){regNo=Objects.requireNonNull(r);name=n;}
 @Override public boolean equals(Object o){if(this==o)return true;if(!(o instanceof Student))return false;return regNo.equals(((Student)o).regNo);}
 @Override public int hashCode(){return Objects.hash(regNo);}
 @Override public String toString(){return regNo+" "+name;}}
public class Attendance {public static void main(String[] z){Set<Student>s=new HashSet<>();s.add(new Student("192311001","Arun"));s.add(new Student("192311002","Divya"));s.add(new Student("192311001","Arun"));System.out.println("Unique students: "+s.size());}}
