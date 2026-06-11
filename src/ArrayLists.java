import java.util.*;
public class ArrayLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
// Adding elements
        list.add(1); // [1]
        list.add(2); // [1, 2]
        list.add(3); // [1, 2, 3]
        list.add(0, 0); // [0, 1, 2, 3] — O(n)
        list.addAll(Arrays.asList(4, 5, 6)); // [0, 1, 2, 3, 4, 5, 6]
        list.addAll(2, Arrays.asList(10, 11)); // insert at index 2
// Accessing elements
        list.get(0); // 0
        list.size(); // size
        list.isEmpty(); // false
// Modifying elements
        list.set(0, 99); // replace index 0 with 99
// Removing elements
        list.remove(0); // remove by index, returns removed element
        list.remove(Integer.valueOf(99)); // remove by value (first occurrence)
        list.removeAll(Arrays.asList(1, 2)); // remove all matching
        list.retainAll(Arrays.asList(3, 4)); // keep only these values
// Searching
        list.contains(3); // true
        list.indexOf(3); // first occurrence
        list.lastIndexOf(3); // last occurrence
// Sorting
        Collections.sort(list); // ascending
        Collections.sort(list, Collections.reverseOrder()); // descending DSA Patterns with ArrayList
        list.sort((a, b) -> b - a); // lambda comparator
// Sub-list (view, not copy — modifications affect original)
        list.add(1); // [1]
        list.add(2); // [1, 2]
        list.add(3); // [1, 2, 3]
        System.out.println(list);
        List<Integer> sub = list.subList(1, 4); // [1, 4) elements
// Convert to array
        Object[] arr = list.toArray();
        Integer[] intArr = list.toArray(new Integer[0]);
        int[] primitiveArr = list.stream().mapToInt(Integer::intValue).toArray();
// Create from array
        List<Integer> fromArr = Arrays.asList(1, 2, 3); // Fixed size!
        List<Integer> mutable = new ArrayList<>(Arrays.asList(1, 2, 3)); // Mutable
// Immutable list (Java 9+)
        List<Integer> immutable = List.of(1, 2, 3); // cannot add/remove/set
// Iterate
        for (int val : list) { }
        list.forEach(System.out::println);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val < 0) it.remove(); // safe removal during iteration
        }
// Capacity management (optimization)
        ArrayList<Integer> al = new ArrayList<>(1000); // pre-allocate capacity
        al.ensureCapacity(2000); // grow if needed
        al.trimToSize(); // release unused memory
        // Dynamic array as stack
        List<Integer> stack = new ArrayList<>();
        stack.add(5); // push
        stack.add(25); // push
        stack.remove(stack.size() - 1); // pop (O(1))
        stack.add(15); // push
        stack.get(stack.size() - 1); // peek (O(1))
// Building result list during DFS/BFS
        System.out.println(list);
        System.out.println("stack***********************"+stack);


        List<Integer> path = new ArrayList<>();
        path.add(5);
        path.add(5);
// ... recurse ...
        path.remove(path.size() - 1); // backtrack
// Frequency counting with List

        int n = path.size();

        List<Integer>[] buckets = new ArrayList[n + 1];
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : path) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : freqMap.keySet()) {
            int frequency = freqMap.get(num);
            buckets[frequency].add(num);
        }
// 2D result
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1); row.add(2);
        result.add(row);
    }
}
