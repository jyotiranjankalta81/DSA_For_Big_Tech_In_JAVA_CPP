# DSA for Big Tech in Java

Interview notes for data structures, core Java, collections, and concurrency. Each file is a short, runnable example: the idea is written next to the code, and a `main` method is there so you can run that one topic on its own.

The repository is a set of IntelliJ modules. Open a class and run it. There is no shared library and no Maven or Gradle build.

## Requirements

- **JDK 17 or newer.** Stream examples use `record`, which needs Java 16+. JDK 21 works.
- **IntelliJ IDEA** matches the `.iml` modules already in the tree. The JDK command line works the same way.

## Modules

| Module | Path | What it is |
| --- | --- | --- |
| DSA patterns | `src/` | The main notebook: searching, windows, hashing, lists, trees, graphs, sorting |
| Core Java | `OopsAndCoreJava/` | Language and OOP: keywords, inheritance, immutability, lambdas, date/time |
| Collections | `CollectionTheory/` | Streams, collectors, functional interfaces, and stream drills |
| Concurrency | `ConcurrencyyAndMultiThreading/` | Threads, locks, pools, and the usual concurrency interview designs |
| Service-company set | `ServiceBasedPreparation/` | Shorter classic array, string, and linked-list problems, plus a small threading practice set |

`ServiceBasedPreparation` contains three nested modules, each with its own `src`: `Collection`, `Practice`, and `Practice/Threading`.

## Running a file

Most classes under `src/` declare a package that matches the folder (`package BinarySearch` lives in `src/BinarySearch`). Core Java, concurrency, and the service-company collection files sit in the default package. Collection Theory uses the packages `Theories` and `Problems`.

Several `main` methods read from the console with `Scanner`: array size first, then the elements, one per line or separated by spaces.

### IntelliJ IDEA

1. **File → Open** and choose this repository.
2. Use the module that already points at the folder you want. Source roots are each module’s `src` directory (`DSA_java.iml` at the repository root uses `src/`).
3. Open a class that has a `main` method and run it. Console input goes in the Run tool window.

### Command line

From the source root of the module, compile the package (classes in one folder call each other), then run the class.

Pattern notes, packaged under `src/`:

```bash
cd src
javac BinarySearch/*.java
java BinarySearch.CoreBinarySearch
```

Core Java, default package:

```bash
cd OopsAndCoreJava/src
javac ImportantKeywords.java
java ImportantKeywords
```

Collections, packaged under `CollectionTheory/src`:

```bash
cd CollectionTheory/src
javac Theories/*.java Problems/*.java
java Theories.StreamAndRecordsAndReference
```

Concurrency, default package:

```bash
cd ConcurrencyyAndMultiThreading/src
javac DeadLockThread.java
java DeadLockThread
```

`javac` writes `.class` files next to the sources. Delete them when you are done, or leave them out of commits.

## Pattern index

Folders below are relative to `src/` unless noted. Concept files (`Core*`, `*Concept`) walk through the structure. The other files are interview-style problems.

### Searching, pointers, and ranges

| Topic | Folder | In the folder |
| --- | --- | --- |
| Binary search | `BinarySearch/` | Classic search, lower/upper boundary, peak, rotated array, 2D matrix, unbounded array, binary search on the answer |
| Two pointers | `TwoPointers/` | Converging, fast/slow, merge, partition, remove duplicates, 3Sum |
| Sliding window | `SlidingWindow/` | Fixed window, variable window, multi-pointer window, window plus a hash map, string permutation, longest substring without repeating characters |
| Prefix sums | `PrefixSum/` | 1D and 2D prefix sums, continuous subarray sum, product of array except self, find the duplicate number |

### Hashing and ordered sets

| Topic | Folder | In the folder |
| --- | --- | --- |
| HashMap and TreeMap | `HashMapAndTreeMap/` | Frequency map, two sum, anagrams and group anagrams, LRU cache, range counting, coordinate compression, difference array, sliding-window maximum, first-occurrence index |
| HashSet | `HashSet/` | Duplicate detection, two sum, longest consecutive sequence, character set for a sliding window, minimum-area rectangle |
| TreeSet | `TreeSet/` | Kth smallest or largest, count of elements in a range, room scheduling |

### Linear structures

| Topic | Folder | In the folder |
| --- | --- | --- |
| Stack | `Stack/` | `ArrayDeque` as a stack, balanced brackets, reverse Polish notation, collisions on a road |
| Queue | `Queue/` | Queue operations |
| Deque | `Deque/` | Deque basics and a monotonic deque |
| Priority queue | `PriorityQueue/` | Kth largest, median from a data stream, merge k sorted lists |
| Linked list | `LinkedList/` | `ListNode`, merge two sorted lists. `src/LinkedLists.java` is a separate default-package sketch |

### Trees, graphs, and sorting

| Topic | Folder | In the folder |
| --- | --- | --- |
| Trees | `TreePatterns/` | Recursive and iterative traversals, level-order BFS, height and diameter, path sum, max path sum, symmetric tree, BST validation, LCA, serialize/deserialize, height-balanced tree |
| Graphs | `GraphPatterns/` | Unweighted shortest path (BFS), Dijkstra, Kahn’s algorithm for topological sort |
| Sorting | `Sorting/` | Insertion sort, merge sort, quick sort, counting sort |
| Ordering | `ComparatorComparableAndCollections/` | `Comparable`, `Comparator`, and `Collections` helpers |

`src/ArrayLists.java` is a short default-package `ArrayList` walkthrough.

## Core Java

`OopsAndCoreJava/src` covers the language topics that show up beside DSA rounds:

- Relations and SOLID notes in `OOPSRelation.java`
- Inheritance, polymorphism, abstract classes, interfaces
- `static`, blocks, and the other keywords in `ImportantKeywords.java`
- Immutability and an immutable class
- Functional interfaces, and lambdas compared with anonymous classes
- `Comparable` and `Comparator`
- Primitives and wrapper classes
- `java.time` in `LocaleTimeAndDate.java`

## Collections and streams

`CollectionTheory/src/Theories` is the reference set: stream operations, method references, records, collectors, and functional interfaces.

`CollectionTheory/src/Problems` is a sequence of stream drills on small records (`Employee`, orders, logs, transactions): group and count, highest paid per department, and similar collector pipelines. `Problems1.java` states the task in the file header.

## Concurrency

Everything lives in `ConcurrencyyAndMultiThreading/src` (the folder name keeps the doubled `y`). The files group like this:

- **Visibility and locking** — `VolatileExample`, deadlock and the fixed version, double-checked singleton
- **Waiting and hand-off** — one thread waits for another, print numbers with two threads, alternate printing, print `ABC`
- **`java.util.concurrent`** — blocking queue and a custom blocking queue, `CountDownLatch`, `CyclicBarrier` and a custom barrier, semaphore, read/write lock, scheduled executor, a small thread pool and shutdown, `CompletableFuture`
- **Design questions** — producer/consumer, API rate limiter, three rate-limiter variants, semaphore-based limiting, a parking-slot booking demo built on `ReentrantLock`

`ServiceBasedPreparation/Practice/Threading` repeats a few of those designs (producer/consumer, rate limiter, `ReentrantLock`) as a separate practice module.

## Service-company problem set

`ServiceBasedPreparation/Collection/src` is the short-problem list used for service-company screens:

- Arrays: reverse, rotate by k, move zeros, missing number, remove duplicates, pair/target sum, Kadane, product except self, trapping rain water
- Strings: palindrome, valid palindrome, anagrams, compression, longest common prefix, first non-repeating character, reverse words, string rotation, permutations
- Linked lists: reverse, middle node, detect a cycle, find the cycle start, merge two sorted lists
- Intervals: overlapping intervals

`ServiceBasedPreparation/Practice/src` holds extra drills (longest substring without repeating characters, pair sum and difference, reverse words, palindrome with spaces).

## A useful order

1. `OopsAndCoreJava` when the language itself needs a pass.
2. Two pointers, sliding window, binary search, and prefix sums.
3. HashMap, HashSet, then TreeMap and TreeSet where order matters.
4. Stack, queue, deque, priority queue, linked list.
5. Trees, then the three graph files.
6. `CollectionTheory` once the Stream API is in play.
7. `ConcurrencyyAndMultiThreading` as its own block. These files are easier after the core-Java keywords file.
8. `ServiceBasedPreparation` as timed practice on the classic problems.

## Adding a note

Put a new pattern file in the matching folder under `src/` and give it that folder’s package name. Core Java, concurrency, and `ServiceBasedPreparation/Collection` stay in the default package, so a new file there has no `package` line. Give the class a `main` so it can be run the same way as the rest.
