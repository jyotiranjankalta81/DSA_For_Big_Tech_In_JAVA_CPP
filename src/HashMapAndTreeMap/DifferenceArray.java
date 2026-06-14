package HashMapAndTreeMap;
/*
====================================================
PROBLEM
====================================================

Book Room:

10 -> 20

Means:

Room occupied from time 10
until before time 20

----------------------------------------------------

Naive:

Mark every slot occupied.

10 11 12 13 14 15 16 17 18 19

Bad for large ranges.

====================================================
SMART IDEA
====================================================

Store only changes.

At start:

+1

At end:

-1

----------------------------------------------------

Booking:

10 -> 20

Store:

10 = +1
20 = -1

Meaning:

At 10 occupancy increases.

At 20 occupancy decreases.

====================================================
TREEMAP
====================================================


TreeMap<Integer,Integer> diff = new TreeMap<>();

diff.put(10, 1);
diff.put(20, -1);

/*
Map:

{
 10=1,
 20=-1
}

====================================================
SECOND BOOKING
====================================================

15 -> 25

Store:

15 = +1
25 = -1

Map:

{
 10=1,
 15=1,
 20=-1,
 25=-1
}

====================================================
VISUALIZATION
====================================================

Time

10 15 20 25

Changes

+1 +1 -1 -1

====================================================
PREFIX SUM
====================================================

Running Occupancy

current = 0

At 10:

current += 1

current = 1

----------------------------------

At 15:

current += 1

current = 2

----------------------------------

At 20:

current += (-1)

current = 1

----------------------------------

At 25:

current += (-1)

current = 0

====================================================
MEANING
====================================================

10-15

1 room occupied

----------------------------------

15-20

2 rooms occupied

----------------------------------

20-25

1 room occupied

====================================================
WHY PREFIX SUM ?
====================================================

TreeMap stores only changes.

Prefix Sum reconstructs
actual occupancy.

====================================================
INTERVIEW QUESTION
====================================================

Can we detect overlap?

YES

If occupancy > 1

Overlap exists.

====================================================
EXAMPLE
====================================================

10-20
15-25

Scan Prefix Sum

Occupancy:

1
2  <-- overlap
1
0

Since occupancy became 2

Conflict exists.

====================================================
MY CALENDAR II
====================================================

Allow only single booking.

While scanning:

if(current > 1)
    overlap

====================================================
MY CALENDAR III
====================================================

Maximum simultaneous bookings.

answer = max(answer,current)

====================================================
CHEAT CODE
====================================================

start => +1

end => -1

TreeMap keeps times sorted.

Prefix Sum gives:

Current Active Events

====================================================
*/

import java.util.*;

public class DifferenceArray {

    public static void main(String[] args) {

        TreeMap<Integer,Integer> diff = new TreeMap<>();

        int start = 10;
        int end = 20;

        diff.merge(start, 1, Integer::sum);
        diff.merge(end, -1, Integer::sum);

        diff.merge(15, 1, Integer::sum);
        diff.merge(25, -1, Integer::sum);

        int current = 0;

        for(int change : diff.values()) {

            current += change;

            System.out.println(
                    "Current Occupancy = " + current
            );
        }
    }
}

/*
    Difference Array

Start  -> +1
End    -> -1

TreeMap
=
Keeps all events sorted by time

Prefix Sum
=
Tells how many events are active now

Active > 1
=
Overlap

Maximum Active
=
Maximum concurrent bookings




Difference Array + TreeMap Concept

This pattern is heavily used in:

My Calendar
Meeting Rooms
Hotel Booking
Flight Scheduling
Sweep Line Problems
 */