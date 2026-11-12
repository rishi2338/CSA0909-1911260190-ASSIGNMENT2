# Assignment 2 — Report (Q1–Q7)

Student: Rishi Nathan  
Register number: 1911260190  
Course: CSA0909 — Programming in Java

Evidence note: all programs were compiled and run using OpenJDK 21.0.12 in a Linux execution environment. Captured output is in results/. Timings are initial single-run measurements and vary with JIT warm-up, machine load and runtime. Repeat measurements on your own laptop and add screenshots from your own terminal before final submission.

## Q1 — Strings
String is immutable; repeated concatenation creates intermediate values and recopies the accumulated prefix. With similarly sized fields, copied-character work can approach O(n²). StringBuilder uses a mutable buffer and amortized O(L) append work for L output characters. StringBuffer synchronizes its methods. Use StringBuilder for each thread-confined ticket. For shared logging, prefer a thread-safe logger or synchronized/queued logging. String.join/StringJoiner suit pre-collected values; String.format is convenient but adds formatting overhead. Workloads: 6 fields × 1 ticket, 50 × 10,000, 500 × 1,000.

## Q2 — Lists and deque
ArrayList: indexed get O(1), end append amortized O(1), front/middle insert or removal O(n) due to shifting, iteration O(n). LinkedList: end operations O(1), indexed get O(n), middle insertion O(n) to locate plus O(1) link, iteration O(n), higher per-node memory. ArrayDeque: amortized O(1) at both ends, no indexed access, middle insertion is not efficient. A plain array has O(1) indexed read and O(n) shifts for insertion/removal. ArrayList suits indexed playlist access; ArrayDeque suits a separate Up Next deque. Benchmarks use 1,000, 10,000 and 50,000 elements.

## Q3 — hashCode and equals
HashSet uses hashCode to select a bucket and equals to compare candidates. Equal objects must have equal hash codes. Overriding equals alone can put logically equal objects in different buckets. The corrected Student uses immutable registration number in both methods; expected output is Unique students: 2. Mutating a hash key after insertion can break lookup/removal. TreeSet with registration comparator gives O(log n) operations and sorted order; HashMap keyed by registration number gives expected O(1). Both use O(n) space.

## Q4 — Maps
HashMap has expected O(1) put/get and unspecified iteration order. TreeMap has O(log n) put/get and sorted keys. LinkedHashMap has expected O(1) basic operations and insertion-order iteration. TreeMap naturally prints code order; LinkedHashMap naturally prints insertion order. Sorting HashMap keys costs O(n log n). Hashtable is legacy; use HashMap or explicit concurrency utilities in modern code. Sorted array plus binarySearch gives O(log n) lookup, O(n) insertion, O(n) ordered report and O(n) space. The code tests 100, 1,000 and 10,000 medicines with 100,000 lookups.

## Q5 — Generics and ranking
Leaderboard<T> accepts Comparator<? super T> and sorts a copy so stored insertion order is unchanged. Comparator: points descending, goal difference descending, name ascending. Expected output: [Eagles(9,6), Bisons(9,4), Panthers(9,4), Cobras(6,1)]. Bisons precedes Panthers because the first two keys tie and alphabetical order is the final tie-break. Sorting O(n log n), copied list O(n) space. Comparable suits one natural order; injected Comparator is more reusable for teams, players and colleges. Three stable sorts require three O(n log n) sorts.

## Q6 — Priority queue
FIFO cannot select by severity. PriorityQueue comparator sorts severity 1 first and then ascending arrival counter. Offer/poll O(log n), peek O(1), space O(n). Iterating the queue is not sorted; repeatedly poll a copy to display service order. Expected output: Meena(S1) Kumar(S1) Lata(S2) Ravi(S3) John(S3) Asha(S5). Starvation can affect minor patients; ageing can raise effective priority after a waiting threshold. The sample does not implement time-based ageing. Real hospital deployment needs clinical validation, persistence, concurrency and monitoring.

## Q7 — Redesign
Selected bottleneck: repeated immutable concatenation in Q1. Replace String += in a loop with one StringBuilder and convert once. This avoids repeated prefix copying and targets amortized O(L) rather than potentially O(n²) copied characters. Task07 compares both approaches for 10, 50, 100 and 500 fields. Small inputs may show little gain due to fixed overhead and JIT effects. Validate with repeated runs under identical conditions.

## Conclusion
Select collections based on dominant operations: ArrayList for indexed playlists, ArrayDeque for double-ended queues, hash-based sets with a correct equals/hashCode contract, maps matching report order, Comparator chains for reusable ranking, and PriorityQueue for severity order. Final conclusions should be based on repeated measurements on the target machine.
