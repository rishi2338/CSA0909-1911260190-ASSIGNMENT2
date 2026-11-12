import java.util.Comparator;
import java.util.PriorityQueue;

class WaitingPatient {
    int severity;
    long arrival;

    WaitingPatient(int severity, long arrival) {
        this.severity = severity;
        this.arrival = arrival;
    }
}

public class task6_benchmark {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};
        System.out.println("Patients,Add ns per patient,Poll ns per patient");

        for (int size : sizes) {
            PriorityQueue<WaitingPatient> queue = new PriorityQueue<WaitingPatient>(new Comparator<WaitingPatient>() {
                public int compare(WaitingPatient first, WaitingPatient second) {
                    if (first.severity != second.severity) {
                        return Integer.compare(first.severity, second.severity);
                    }
                    return Long.compare(first.arrival, second.arrival);
                }
            });

            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                queue.add(new WaitingPatient(i % 5 + 1, i));
            }
            long addTime = (System.nanoTime() - start) / size;

            start = System.nanoTime();
            while (!queue.isEmpty()) {
                queue.poll();
            }
            long pollTime = (System.nanoTime() - start) / size;

            System.out.println(size + "," + addTime + "," + pollTime);
        }
    }
}