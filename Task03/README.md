# Q3 — HashSet and the equals/hashCode Contract

## Aim
Prevent the same student from being counted more than once at different event gates.

## Java files
- task3.java — corrected Student class and HashSet solution.
- Brokentask3.java — intentionally incorrect example that overrides equals() but not hashCode().

## Simple explanation
HashSet uses hashCode() to find a bucket and equals() to check whether an equal item is present. Equal objects must return the same hash code. The corrected program uses the registration number in both methods.

## Methods used
equals(), hashCode(), toString(), add(), size().

## Compile and run
~~~bash
javac *.java
java BrokenAttendance
java Attendance
~~~

## Expected corrected output
~~~text
Unique students: 2
TreeSet students: [192311001 Arun, 192311002 Divya]
~~~

The broken example usually keeps equal registration numbers as separate entries because it uses the default identity hash codes. The exact size can vary if identity hash codes collide.

## Alternative and complexity
HashSet has expected O(1) add and lookup with well-distributed hashes. TreeSet with a registration-number comparator has O(log n) operations and sorted order. Both use O(n) space.