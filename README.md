# CSA0909 — Programming in Java, Assignment 2

**Student:** Rishi Nathan  
**Register number:** 1911260190  
**Assignment:** CO2 — Strings and the Java Collection Framework  
**Total:** 50 marks

This repository contains beginner-readable Java implementations for all seven questions in the assignment. The code uses straightforward variable declarations, loops, System.out.println() and direct method calls. Required assignment concepts such as collections, maps, generics, comparators and queues are retained.

## Task folders

| Folder | Topic | Java program |
|---|---|---|
| [Task01](Task01/README.md) | String, StringBuilder and StringBuffer | StringConstructionBenchmark.java |
| [Task02](Task02/README.md) | ArrayList, LinkedList and ArrayDeque | ListStructureBenchmark.java |
| [Task03](Task03/README.md) | HashSet and equals/hashCode | Attendance.java, BrokenAttendance.java |
| [Task04](Task04/README.md) | HashMap, TreeMap and LinkedHashMap | PharmacyInventory.java |
| [Task05](Task05/README.md) | Generics and Comparator ranking | LeaderboardDemo.java |
| [Task06](Task06/README.md) | Queue and PriorityQueue | Triage.java |
| [Task07](Task07/README.md) | Diagnose, redesign and validate | RedesignValidation.java |

Each task folder has its own README with the aim, explanation, methods or concepts used, compile/run commands, result and complexity notes.

## Java version and running programs

The programs use standard Java features available in Java 8 or later. Open a terminal inside the required task folder and run:

~~~bash
javac *.java
java ClassName
~~~

Use the class name shown in that task's README. For Task03, run BrokenAttendance and Attendance separately.

## Results and report

- results/ contains captured console output from a validation run.
- report/ASSIGNMENT_REPORT.md contains the combined explanation and conclusions for Q1–Q7.

Benchmark timings depend on the computer, JVM, warm-up and background activity. They are sample measurements, not universal performance guarantees. Repeat the tests on your own laptop and keep your own raw measurements.

## Before final submission

The assignment asks each student to execute every task individually and submit output screenshots and raw experimental data. The text files in results/ are console captures; **personal terminal screenshots have not been added**. Run each program on your computer, capture the output, and add those screenshots to the matching task folder. Review the report so you can explain the code and defend the results in the viva.