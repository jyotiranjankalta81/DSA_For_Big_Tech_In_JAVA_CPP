package HashMapAndTreeMap;

/*
====================================================
RANGE COUNTING USING TREEMAP
====================================================

Question:

Count how many elements lie between

L and R

Example:

[10, 20, 20, 30, 40, 50]

Range:

20 to 40

Answer:

20,20,30,40

Count = 4

====================================================
WHY TREEMAP ?
====================================================

TreeMap keeps keys sorted.

10 -> 1
20 -> 2
30 -> 1
40 -> 1
50 -> 1

(key -> frequency)

====================================================
STEP 1
STORE FREQUENCIES
====================================================


TreeMap<Integer,Integer> map = new TreeMap<>();

int[] arr = {10,20,20,30,40,50};

for(int num : arr){
        map.put(num, map.getOrDefault(num,0)+1);
        }

/*
Map:

{
10=1,
20=2,
30=1,
40=1,
50=1
}

====================================================
STEP 2
GET RANGE
====================================================


NavigableMap<Integer,Integer> range =
        map.subMap(20,true,40,true);

/*
Result:

{
20=2,
30=1,
40=1
}

====================================================
STEP 3
COUNT FREQUENCIES
====================================================


int count = 0;

for(int freq : range.values()){
count += freq;
}

/*
count = 4

====================================================
FULL CODE
====================================================
*/

        import java.util.*;

public class RangeCounting {

    public static void main(String[] args) {

        int[] arr = {10,20,20,30,40,50};

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int num : arr){
            map.put(num,
                    map.getOrDefault(num,0)+1);
        }

        int L = 20;
        int R = 40;

        int count = 0;

        NavigableMap<Integer,Integer> range =
                map.subMap(L,true,R,true);

        for(int freq : range.values()){
            count += freq;
        }

        System.out.println(count);
    }
}

/*
Output:

4

====================================================
INTERVIEW PATTERN
====================================================

TreeMap Frequency Map

number -> count

Then:

subMap(L,true,R,true)

gives all keys in range.

====================================================
TREEMAP RANGE METHODS
====================================================

subMap(a,b)
=
between a and b

headMap(x)
=
less than x

tailMap(x)
=
greater than x

higherKey(x)
=
next greater

lowerKey(x)
=
next smaller

====================================================
INTERVIEW CHEAT CODE
====================================================

Need:

Count elements in range [L,R]

Think:

TreeMap<Integer,Integer>

Store frequencies

Use:

subMap(L,true,R,true)

Because TreeMap keys are sorted.
====================================================

Even More Advanced (Frequently Asked)

If the interviewer asks:

"Range count queries many times on a large array"

Then TreeMap + frequency is not optimal because each query may still scan many keys.

The progression is:

Few range queries      -> TreeMap
Many range queries     -> Prefix Sum
Updates + range query  -> Segment Tree
Updates + prefix query -> Fenwick Tree (BIT)
*/