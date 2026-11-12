# Q6 — Queue, PriorityQueue and Emergency Triage

## Aim
Treat the most critical patient first. For equal severity, treat the earliest arrival first.

## Java files
- Triage.java — priority queue and arrival-order tie-break.
- TriageScalingBenchmark.java — add/remove timing for increasing queue sizes.

## Simple explanation
A normal FIFO queue only follows arrival order. PriorityQueue uses a Comparator to place the smallest severity number first. An arrival counter keeps equal-severity patients in arrival order.

## Methods and concepts
PriorityQueue, Comparator, add(), poll(), StringBuilder.append(), and toString().

## Compile and run
~~~bash
javac *.java
java TriageBeginner
java TriageScalingBenchmarkBeginner
~~~

## Expected triage output
~~~text
Meena(S1) Kumar(S1) Lata(S2) Ravi(S3) John(S3) Asha(S5)
~~~

## Complexity and fairness
Adding and removing takes O(log n); checking the next patient takes O(1). The queue uses O(n) space. The scaling program tests 1,000, 10,000 and 50,000 patients. A minor patient may wait indefinitely if critical cases keep arriving. Priority ageing can raise priority after a waiting-time limit. The example explains this rule but does not implement time-based ageing. A real hospital system needs clinical review, persistence and concurrency controls.