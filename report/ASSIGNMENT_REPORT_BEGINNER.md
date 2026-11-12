# Assignment 2 — Consolidated Report (Q1–Q7)

**Student:** Rishi Nathan  
**Register number:** 1911260190  
**Course:** CSA0909 — Programming in Java

## Q1 — String, StringBuilder and StringBuffer
String is immutable, so repeated + operations inside a loop may create intermediate String objects and repeatedly copy the text already built. StringBuilder is mutable and append() adds text to its buffer. StringBuffer is also mutable but synchronizes its methods. The program compares 6 fields × 1 ticket, 50 fields × 10,000 tickets, and 500 fields × 1,000 tickets, with five rounds per case. Use StringBuilder for a ticket built by one thread. For a shared multithreaded log, use a thread-safe logger or synchronized access. Repeated String concatenation can approach O(n²) copied characters for n similarly sized fields; StringBuilder is approximately O(L) for L final output characters.

## Q2 — ArrayList, LinkedList and ArrayDeque
ArrayList provides O(1) indexed access and amortized O(1) end insertion, but front or middle insertion/removal requires shifting elements and takes O(n). LinkedList has O(1) end operations, O(n) indexed access and O(n) middle insertion/removal when the node must first be located. ArrayDeque has amortized O(1) operations at both ends but no indexed access. The program compares 1,000, 10,000 and 50,000 elements for end insertion, front and middle operations, indexed access and iteration. ArrayList is suitable for a playlist with frequent jumps to a song index; ArrayDeque is suitable for a separate Up Next queue.

## Q3 — HashSet and the equals/hashCode contract
HashSet uses hashCode() to find a bucket and equals() to compare possible matches. If two objects are equal, they must have the same hash code. BrokenAttendance.java intentionally omits hashCode() to demonstrate the issue. Its observed size can vary because identity hash codes are not based on registration number. Attendance.java fixes the class by using the immutable registration number in both equals() and hashCode(); its expected output is Unique students: 2. A TreeSet with a registration-number comparator is an alternative with O(log n) operations and sorted order. HashSet operations are O(1) average with good hash distribution. Both structures use O(n) space.

## Q4 — Map selection
HashMap has expected O(1) put/get and does not guarantee iteration order. TreeMap has O(log n) put/get and sorted key iteration. LinkedHashMap has expected O(1) basic operations and remembers insertion order. The pharmacy example uses TreeMap for code order and LinkedHashMap for insertion order. The benchmark checks 100, 1,000 and 10,000 entries and performs 100,000 lookups per map. Hashtable is a legacy synchronized map and is not the default choice for new code. A sorted array with binary search has O(log n) lookup, O(n) insertion and O(n) space.

## Q5 — Generics and Comparator
Leaderboard<T> stores a generic list and accepts a Comparator. The comparator orders teams by points descending, goal difference descending and name ascending. Expected output: [Eagles(9,6), Bisons(9,4), Panthers(9,4), Cobras(6,1)]. Bisons is above Panthers because the points and goal difference are equal, so alphabetical order is used. Sorting takes O(n log n) time and the copied list uses O(n) extra space. A separate Comparator is reusable when the same object type needs more than one ordering.

## Q6 — PriorityQueue and fairness
A normal FIFO queue cannot always select the most severe patient. PriorityQueue uses severity ascending (1 is critical) and an arrival counter for FIFO order among equal severities. Adding and removing a patient take O(log n), peek takes O(1), and storage is O(n). Iterating a PriorityQueue does not guarantee sorted order; repeatedly polling a copy displays treatment order. Severity-5 patients may starve if severe cases keep arriving. A possible improvement is priority ageing after a waiting-time threshold. The supplied sample explains this rule but does not implement time-based ageing. A real hospital system needs clinical validation, persistence, monitoring and safe concurrent access.

## Q7 — Diagnose, redesign and validate
The selected bottleneck is repeated String concatenation in the ticket-building loop from Q1. The redesign uses one StringBuilder and append() for all fields. The test compares 10, 50, 100 and 500 fields and averages 1,000 builds per method. The prediction is that StringBuilder will reduce repeated copying for larger tickets; very small inputs may show little difference. The captured results are in results/Task07_output_revised.txt. Timing values vary by JVM and computer, so repeat the measurements on the student's own laptop before making a final claim.

## Conclusion
Use each collection according to the operations required: ArrayList for indexed access, ArrayDeque for double-ended work, HashSet with a correct equals/hashCode contract for uniqueness, maps that match the required report order, Comparator for reusable ranking, and PriorityQueue for priority-based service. Performance conclusions should be based on repeated measurements under consistent conditions.

## Evidence note
The repository includes Java source files, task-specific READMEs, a consolidated report and captured console-output text files. The captured results are from one validation environment and do not replace the student's own repeated measurements or terminal screenshots. Add personal screenshots and raw repeated measurements before final submission.