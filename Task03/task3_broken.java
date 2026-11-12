class OldStudent {
    String regNo;

    OldStudent(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OldStudent)) return false;
        OldStudent other = (OldStudent) obj;
        return regNo.equals(other.regNo);
    }
    // hashCode() is intentionally missing for this experiment.
}

public class task3_broken {
    public static void main(String[] args) {
        java.util.Set<OldStudent> scans = new java.util.HashSet<OldStudent>();
        scans.add(new OldStudent("192311001"));
        scans.add(new OldStudent("192311001"));
        scans.add(new OldStudent("192311002"));

        System.out.println("Set size with equals() only: " + scans.size());
        System.out.println("The result demonstrates why equals() and hashCode() must agree.");
    }
}