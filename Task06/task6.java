import java.util.Comparator;
import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;
    long arrival;

    Patient(String name, int severity, long arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String toString() {
        return name + "(S" + severity + ")";
    }
}

public class task6 {
    long counter = 0;

    PriorityQueue<Patient> queue = new PriorityQueue<Patient>(new Comparator<Patient>() {
        public int compare(Patient first, Patient second) {
            if (first.severity != second.severity) {
                return Integer.compare(first.severity, second.severity);
            }
            return Long.compare(first.arrival, second.arrival);
        }
    });

    void admit(String name, int severity) {
        if (severity < 1 || severity > 5) {
            System.out.println("Severity must be from 1 to 5");
            return;
        }
        queue.add(new Patient(name, severity, counter));
        counter++;
    }

    Patient next() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Triage er = new Triage();

        er.admit("Ravi", 3);
        er.admit("Meena", 1);
        er.admit("John", 3);
        er.admit("Asha", 5);
        er.admit("Kumar", 1);
        er.admit("Lata", 2);

        StringBuilder order = new StringBuilder();
        Patient patient;

        while ((patient = er.next()) != null) {
            order.append(patient).append(" ");
        }

        System.out.println(order.toString().trim());
    }
}