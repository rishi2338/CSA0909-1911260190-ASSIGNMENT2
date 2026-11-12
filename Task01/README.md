# Q1 — String, StringBuilder and StringBuffer

## Aim
Build railway e-tickets and compare three ways of joining text.

## Java file
StringConstructionBenchmark.java

## Simple explanation
- String cannot be changed after it is created. Repeated + joins can create temporary String objects.
- StringBuilder can be changed. append() adds text to the same builder.
- StringBuffer is also changeable, but its methods are synchronized.

## Methods used
append(), length(), and System.nanoTime() for timing.

## Test cases
6 fields × 1 ticket, 50 fields × 10,000 tickets, and 500 fields × 1,000 tickets. Each case is repeated five times.

## Compile and run
~~~bash
javac StringConstructionBenchmark.java
java StringConstructionBenchmark
~~~

## Result and decision
See ../results/Task01_output_revised.txt. Use StringBuilder for each ticket. For a shared multithreaded log, use a thread-safe logger or synchronize access.

## Complexity
Repeated + can approach O(n²) copied characters for n fields. StringBuilder append is approximately O(L) for L output characters.