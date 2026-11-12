import java.util.Comparator;
import java.util.PriorityQueue;

class WaitingPatientBeginner {
    int severity;
    long arrival;

    WaitingPatientBeginner(int severity, long arrival) {
        this.severity = severity;
        this.arrival = arrival;
    }
}

public class TriageScalingBenchmarkBeginner {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 50000};
        System.out.println("Patients,Add ns per patient,Poll ns per patient");

        for (int size : sizes) {
            PriorityQueue<WaitingPatientBeginner> queue = new PriorityQueue<WaitingPatientBeginner>(new Comparator<WaitingPatientBeginner>() {
                public int compare(WaitingPatientBeginner first, WaitingPatientBeginner second) {
                    if (first.severity != second.severity) {
                        return Integer.compare(first.severity, second.severity);
                    }
                    return Long.compare(first.arrival, second.arrival);
                }
            });

            long start = System.nanoTime();
            for (int i = 0; i < size; i++) {
                queue.add(new WaitingPatientBeginner(i % 5 + 1, i));
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