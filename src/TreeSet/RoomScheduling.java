package TreeSet;
/*
====================================================
MEETING ROOMS
====================================================

Question:

Meetings:

[1,4]
[2,5]
[7,9]

How many rooms are needed?

====================================================
IDEA
====================================================

At meeting start:

Room occupied

+1

----------------------------------------------------

At meeting end:

Room freed

-1

Store changes in TreeMap.

====================================================
MEETING 1
====================================================

[1,4]

1 -> +1
4 -> -1

TreeMap:

{
1=1,
4=-1
}

====================================================
MEETING 2
====================================================

[2,5]

2 -> +1
5 -> -1

TreeMap:

{
1=1,
2=1,
4=-1,
5=-1
}

====================================================
MEETING 3
====================================================

[7,9]

7 -> +1
9 -> -1

TreeMap:

{
1=1,
2=1,
4=-1,
5=-1,
7=1,
9=-1
}

====================================================
PREFIX SUM
====================================================

Current Rooms = 0

Time=1

Current += 1

Rooms = 1

----------------------------------------------------

Time=2

Current += 1

Rooms = 2

Maximum = 2

----------------------------------------------------

Time=4

Current += (-1)

Rooms = 1

----------------------------------------------------

Time=5

Current += (-1)

Rooms = 0

----------------------------------------------------

Time=7

Current += 1

Rooms = 1

----------------------------------------------------

Time=9

Current += (-1)

Rooms = 0

====================================================
ANSWER
====================================================

Maximum rooms used simultaneously

= 2

Need 2 rooms.

====================================================
WHY TREEMAP?
====================================================

Keeps time points sorted.

1
2
4
5
7
9

Automatically.

====================================================
INTERVIEW CHEAT CODE
====================================================

Meeting Start

+1

Meeting End

-1

Prefix Sum

Current Active Meetings

Maximum Prefix Sum

= Minimum Rooms Needed

====================================================
*/
import java.util.*;

public class RoomScheduling {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of meetings: ");
        int n = sc.nextInt();

        TreeMap<Integer, Integer> timeline = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            System.out.print("Start Time: ");
            int start = sc.nextInt();

            System.out.print("End Time: ");
            int end = sc.nextInt();

            timeline.merge(start, 1, Integer::sum);
            timeline.merge(end, -1, Integer::sum);
        }

        int currentRooms = 0;
        int maxRooms = 0;

        for (int change : timeline.values()) {

            currentRooms += change;

            maxRooms =
                    Math.max(maxRooms, currentRooms);
        }

        System.out.println(
                "Minimum Rooms Needed = " + maxRooms
        );
    }
}


//
//// Pattern 4: Meeting rooms / room scheduling
//TreeSet<Integer> rooms = new TreeSet<>(); // end times of ongoing meetings
//for (int[] meeting : sortedByStart) {
//        if (!rooms.isEmpty() && rooms.first() <= meeting[0]) {
//        rooms.pollFirst(); // reuse a room
//    }
//            rooms.add(meeting[1]); // assign room, track end time
//}
//        return rooms.size(); // minimum rooms needed