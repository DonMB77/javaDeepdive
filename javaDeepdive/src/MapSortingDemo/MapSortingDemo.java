package MapSortingDemo;

import java.util.*;

public class MapSortingDemo {

    public static void main (String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");

        System.out.println("Sorting Map by Comparable Key :");
        List<Map.Entry<Integer, String>> list = new ArrayList<Map.Entry<Integer, String>>(map.entrySet());

        Collections.shuffle(list);
        System.out.println("Entries before sorting: " + list);

        list.sort(Map.Entry.comparingByKey());
        System.out.println("Entries after sorting: " + list);

        // Sorting Map by Comparable Key using TreeMap
        Map<Integer, String> sortedMap = new TreeMap<>(map);
        System.out.println("Elements in TreeMap: " + sortedMap);

        // Sorting Map by Comparable Value:
        Collections.shuffle(list);
        System.out.println("Entries after sorting: " + list);

        list.sort(Map.Entry.comparingByValue());
        Collections.sort(list, Map.Entry.comparingByValue()); // that also works

        Map<Integer, String> map2 = Map.ofEntries(list.toArray(Map.Entry[]::new)); // TODO: look into this more after deepdive through functional programming using java
    }
}
