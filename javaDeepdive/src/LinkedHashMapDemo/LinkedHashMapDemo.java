package LinkedHashMapDemo;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo extends LinkedHashMap<Integer, String> {

    private int capacity = 3;

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
        return size() > this.capacity;
    }

    public static void main (String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");

        System.out.println(map);
    }
}
