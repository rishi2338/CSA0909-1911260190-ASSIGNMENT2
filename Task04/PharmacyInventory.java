import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PharmacyInventory {
    static int total;

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        Map<String, Integer> linkedMap = new LinkedHashMap<String, Integer>();

        String[] codes = {"MED103", "MED101", "MED104", "MED102"};
        int[] stocks = {40, 12, 8, 25};

        for (int i = 0; i < codes.length; i++) {
            hashMap.put(codes[i], stocks[i]);
            treeMap.put(codes[i], stocks[i]);
            linkedMap.put(codes[i], stocks[i]);
        }

        System.out.println("HashMap stock for MED101: " + hashMap.get("MED101"));
        System.out.println("TreeMap stock for MED101: " + treeMap.get("MED101"));
        System.out.println("LinkedHashMap stock for MED101: " + linkedMap.get("MED101"));

        System.out.println("Medicine code order: " + treeMap);
        System.out.println("Medicine insertion order: " + linkedMap);

        int[] sizes = {100, 1000, 10000};
        System.out.println("\nMap size,HashMap lookup ns,TreeMap lookup ns,LinkedHashMap lookup ns,TreeMap report ns,LinkedHashMap report ns");

        for (int size : sizes) {
            Map<String, Integer> h = new HashMap<String, Integer>();
            Map<String, Integer> t = new TreeMap<String, Integer>();
            Map<String, Integer> l = new LinkedHashMap<String, Integer>();

            for (int i = 0; i < size; i++) {
                String code = "MED" + i;
                h.put(code, i);
                t.put(code, i);
                l.put(code, i);
            }

            int repeats = 100000;
            long start = System.nanoTime();
            for (int i = 0; i < repeats; i++) h.get("MED" + (i % size));
            long hashTime = (System.nanoTime() - start) / repeats;

            start = System.nanoTime();
            for (int i = 0; i < repeats; i++) t.get("MED" + (i % size));
            long treeTime = (System.nanoTime() - start) / repeats;

            start = System.nanoTime();
            for (int i = 0; i < repeats; i++) l.get("MED" + (i % size));
            long linkedTime = (System.nanoTime() - start) / repeats;

            start = System.nanoTime();
            for (String code : t.keySet()) total = total + code.length();
            long treeReport = System.nanoTime() - start;

            start = System.nanoTime();
            for (String code : l.keySet()) total = total + code.length();
            long linkedReport = System.nanoTime() - start;

            System.out.println(size + "," + hashTime + "," + treeTime + "," + linkedTime + "," + treeReport + "," + linkedReport);
        }
    }
}