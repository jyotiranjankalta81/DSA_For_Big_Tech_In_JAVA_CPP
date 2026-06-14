package HashMapAndTreeMap;

/*
====================================================
LRU CACHE
====================================================

Capacity = 3

Put(1)
Put(2)
Put(3)

Cache:

3 -> 2 -> 1

3 = Most Recently Used (MRU)
1 = Least Recently Used (LRU)

----------------------------------------------------

Now get(1)

Since 1 was used recently,
move it to front.

Before:

3 -> 2 -> 1

After:

1 -> 3 -> 2

----------------------------------------------------

Now put(4)

Cache already full.

Need to remove least recently used.

Current:

1 -> 3 -> 2

2 is LRU.

Remove 2.

Insert 4 at front.

Result:

4 -> 1 -> 3

====================================================
WHY HASHMAP ?
====================================================

Need O(1) search.

Without HashMap:

Find key = 3

1 -> 3 -> 2

Need traversal.

O(n)

Bad.

HashMap stores:

1 -> Node1
2 -> Node2
3 -> Node3

Now find key instantly.

O(1)

====================================================
WHY DOUBLY LINKED LIST ?
====================================================

Need O(1) move.

Suppose:

1 -> 3 -> 2

Access key = 3

Need:

3 -> 1 -> 2

Doubly Linked List allows:

Remove node in O(1)
Insert node in O(1)

====================================================
COMBINATION
====================================================

HashMap
=
Fast Search

Doubly Linked List
=
Track Recent Usage

Together:

get() = O(1)
put() = O(1)

====================================================
HEAD AND TAIL
====================================================

HEAD <-> 4 <-> 1 <-> 3 <-> TAIL

HEAD.next
=
Most Recently Used

TAIL.prev
=
Least Recently Used

To remove LRU:

Node lru = tail.prev;

====================================================
GET(key)
====================================================

1. Find node from HashMap
2. Remove node from current position
3. Move node to front
4. Return value

====================================================
PUT(key,value)
====================================================

If key exists:

1. Update value
2. Move node to front

Else:

1. If full
      Remove tail.prev
2. Create new node
3. Insert at front
4. Add to HashMap

====================================================
INTERVIEW CHEAT CODE
====================================================

Question:

Design LRU Cache
get() O(1)
put() O(1)

Immediate Answer:

HashMap<Key, Node>
+
Doubly Linked List

HashMap => Search O(1)

DLL => Insert/Delete/Move O(1)

====================================================
*/

import java.util.*;

public class LRU {

    static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        private final int capacity;
        private final HashMap<Integer, Node> map;

        private final Node head;
        private final Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insertAtFront(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        public int get(int key) {

            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);

            remove(node);
            insertAtFront(node);

            return node.value;
        }

        public void put(int key, int value) {

            if (map.containsKey(key)) {

                Node node = map.get(key);
                node.value = value;

                remove(node);
                insertAtFront(node);

            } else {

                if (map.size() == capacity) {

                    Node lru = tail.prev;

                    remove(lru);
                    map.remove(lru.key);
                }

                Node newNode = new Node(key, value);

                insertAtFront(newNode);
                map.put(key, newNode);
            }
        }

        public void printCache() {

            Node curr = head.next;

            while (curr != tail) {
                System.out.print("(" + curr.key + "," + curr.value + ") ");
                curr = curr.next;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        cache.printCache(); // (3,300) (2,200) (1,100)

        cache.get(1);

        cache.printCache(); // (1,100) (3,300) (2,200)

        cache.put(4, 400);

        cache.printCache(); // (4,400) (1,100) (3,300)

        System.out.println(cache.get(2)); // -1 (evicted)
        System.out.println(cache.get(3)); // 300
    }
}



//HashMap<Key, Node>     => O(1) lookup
//Doubly Linked List     => O(1) remove/add
//
//        Head = Most Recently Used (MRU)
//Tail = Least Recently Used (LRU)
//
//get(key):
//move node to front
//
//put(key, value):
//update + move front
//OR insert front
//
//if capacity exceeded:
//remove tail.prev (LRU)