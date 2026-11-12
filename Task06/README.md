# Q6 — Queue, PriorityQueue and Emergency Triage

## Aim
Treat the most critical patient first. For equal severity, treat the earliest arrival first.

## Java file
TriageBeginner.java

## Simple explanation
A normal FIFO queue only follows arrival order. PriorityQueue uses a Comparator to place the smallest severity number first. An arrival counter keeps equal-severity patients in arrival order.

## Methods and concepts
PriorityQueue, Comparator, add(), poll(), StringBuilder.append(), toString().

## Compile and run
~~~bash
javac TriageBeginner.java
java TriageBeginner
~~~

## Expected output
~~~text
Meena(S1) Kumar(S1) Lata(S2) Ravi(S3) John(S3) Asha(S5)
~~~

## Complexity and fairness
Adding and removing takes O(log n); checking the next patient takes O(1). A minor patient may wait indefinitely if critical cases keep arriving. Priority ageing can raise priority after a waiting-time limit. This sample explains the rule but does not implement time-based ageing.