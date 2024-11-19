package MapDemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "two");
        map.put(1, "one");
        map.put(3, "three");
        map.put(4, null);

        // get element
        System.out.println("Get element from map = get(1): " + map.get(1));

        // iterate over map keys
        System.out.println("Iterating over map keys: ");
        for (Integer key : map.keySet()) {
            System.out.println(key);
        }

        // iterate over entries:
        System.out.println("Iterating over map entries: ");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Entry key: " + entry.getKey() + "\t" + "Entry value: " + entry.getValue());
        }

        // getOrDefaultDemo using our prior map:
        System.out.println("getOrDefault method using key 4: " + map.getOrDefault(4, "Value does exist, even if its null, therefore default won't be triggered."));
        System.out.println("getOrDefault method using key 5: " + map.getOrDefault(5, "defaultValue gets printed"));

        // putIfAbsent:
        map.putIfAbsent(4, "four"); // replacing the null entry in our map
        System.out.println("After we called putOfAbsent for key 4: " + map.get(4));
        
    }
}
