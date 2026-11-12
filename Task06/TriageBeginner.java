import java.util.Comparator;
import java.util.PriorityQueue;

class PatientBeginner {
    String name;
    int severity;
    long arrival;

    PatientBeginner(String name, int severity, long arrival) {
        this.name = name;
        this.severity = severity;
        this.arrival = arrival;
    }

    public String toString() {
        return name + "(S" + severity + ")";
    }
}

public class TriageBeginner {
    long counter = 0;

    PriorityQueue<PatientBeginner> queue = new PriorityQueue<PatientBeginner>(new Comparator<PatientBeginner>() {
        public int compare(PatientBeginner first, PatientBeginner second) {
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
        queue.add(new PatientBeginner(name, severity, counter));
        counter++;
    }

    PatientBeginner next() {
        return queue.poll();
    }

    public static void main(String[] args) {
        TriageBeginner er = new TriageBeginner();

        er.admit("Ravi", 3);
        er.admit("Meena", 1);
        er.admit("John", 3);
        er.admit("Asha", 5);
        er.admit("Kumar", 1);
        er.admit("Lata", 2);

        StringBuilder order = new StringBuilder();
        PatientBeginner patient;

        while ((patient = er.next()) != null) {
            order.append(patient).append(" ");
        }

        System.out.println(order.toString().trim());
    }
}