# Q5 — Generics, Comparator and Leaderboard

## Aim
Rank sports teams by points, goal difference and team name.

## Java file
LeaderboardDemoBeginner.java

## Simple explanation
Leaderboard<T> stores different object types using a generic type T. A Comparator tells Java how to compare two teams: points high-to-low, goal difference high-to-low, and name A-to-Z.

## Methods and concepts
Generics (<T>), Comparator, compare(), Collections.sort(), ArrayList, compareTo().

## Compile and run
~~~bash
javac LeaderboardDemoBeginner.java
java LeaderboardDemoBeginner
~~~

## Expected output
~~~text
[Eagles(9,6), Bisons(9,4), Panthers(9,4), Cobras(6,1)]
~~~

Bisons is above Panthers because points and goal difference are tied, so alphabetical order decides.

## Complexity
Sorting n teams takes O(n log n). The copied list uses O(n) extra space. Comparator is reusable when different ranking orders are needed.