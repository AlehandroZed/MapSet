package Task1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {


    public static void main(String[] args) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();

        testMap(hashMap);
    }

    public static void testMap(Map<Integer, String> map) {
        map.put(34, "Bob");
        map.put(87, "Rob");
        map.put(0, "Din");
        map.put(1300, "Lin");
        map.put(7, "Ken");

        for (Map.Entry<Integer, String> entry : map.entrySet()
        ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
