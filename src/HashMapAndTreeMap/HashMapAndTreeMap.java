package HashMapAndTreeMap;

import java.util.*;

public class HashMapAndTreeMap {

    public static  void main (String[] args){
       // Map stores key-value pairs, keys are unique
        Map<String, Integer> map = new HashMap<>(); // unordered, O(1) ops
        Map<String, Integer> tree = new TreeMap<>(); // sorted by key, O(log n)
        Map<String, Integer> linked = new LinkedHashMap<>(); // insertion order
// Common operations
        map.put("a", 1);
        map.get("a"); // 1
        map.put("b",3);
        map.containsKey("a"); // true
        map.containsValue(1); // true (O(n)!)
        map.remove("a");
        map.size();
        map.isEmpty();

// Put / Get
        map.put("apple", 3);
        map.put("banana", 5);
        int val = map.get("apple"); // 3
        int def = map.getOrDefault("cherry", 0); // 0 (key not present)
// Check existence
        map.containsKey("apple"); // true
        map.containsValue(5); // true (O(n))
// Remove
        map.remove("apple"); // remove key, returns old value
        map.remove("banana", 5); // conditional remove (only if value matches)
// Size
        map.size();
        map.isEmpty();
// Iteration
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
        }
        for (String key : map.keySet()) { }
        for (int value : map.values()) { }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
// Advanced operations (Java 8+)
// putIfAbsent — only put if key not present
        map.putIfAbsent("apple", 10); // doesn't overwrite existing
// computeIfAbsent — compute and put if absent
        map.computeIfAbsent("cherry", k -> k.length()); // "cherry" → 6
// Very useful for building adjacency lists:
//        adjList.computeIfAbsent(node, k -> new ArrayList<>()).add(neighbor);
//// computeIfPresent — update only if key exists
//        map.computeIfPresent("banana", (k, v) -> v + 1); // 5 → 6
//// compute — always compute new value
//        map.compute("apple", (k, v) -> (v == null) ? 1 : v + 1);
//
//        map.merge("apple", 1, Integer::sum); // if absent: put 1; if present: sum
//// replaceAll
//        map.replaceAll((k, v) -> v * 2);
//// getOrDefault chaining for frequency maps
//        Map<Character, Integer> freq = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            freq.put(c, freq.getOrDefault(c, 0) + 1);
//        }
//// Or using merge:
//        for (char c : s.toCharArray()) {
//            freq.merge(c, 1, Integer::sum);
//        }
//// Or using compute:
//        for (char c : s.toCharArray()) {
//            freq.compute(c, (k, v) -> v == null ? 1 : v + 1);
//        }

        System.out.println("map**************************"+map);
    }
}
