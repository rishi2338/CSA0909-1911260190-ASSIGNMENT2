# CSA0909 — Programming in Java, Assignment 2

**Student:** Rishinathan L  
**Register number:** 1911260190  
**Assignment:** CO2 — Strings and the Java Collection Framework  
**Total:** 50 marks

This repository contains clear and straightforward Java implementations for all seven questions. The code uses straightforward variable declarations, loops, System.out.println() and direct method calls. Required assignment topics such as collections, maps, generics, comparators and queues are retained.

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

Each task folder has its own README with the aim, simple explanation, methods or concepts used, compile/run commands, expected result and complexity notes.

## Java version and running programs

The programs use standard Java features available in Java 8 or later. Open a terminal inside the required task folder and run the command shown in that task's README. For example:

~~~bash
javac StringConstructionBenchmark.java
java StringConstructionBenchmark
~~~

For Task03, run BrokenAttendance and Attendance separately.

## Consolidated report

[Open the assignment report](report/ASSIGNMENT_REPORT.md) for explanations and conclusions for Q1–Q7.

## Before final submission

Run every program on your own computer, capture your terminal output screenshots, and add them to the matching task folders if screenshots are required for submission. Repeat the benchmark tests on your laptop because timings vary by JVM and computer. Review the report so you can explain the code and results in the viva.