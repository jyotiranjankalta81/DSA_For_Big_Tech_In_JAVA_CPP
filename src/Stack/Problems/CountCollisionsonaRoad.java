package Stack.Problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class CountCollisionsonaRoad {


        public int countCollisions(String directions) {

            int collisions = 0;
            char prev = directions.charAt(0);

            for (int i = 1; i < directions.length(); i++) {

                char curr = directions.charAt(i);

                if (prev == 'R' && curr == 'L') {

                    collisions += 2;
                    prev = 'S';

                } else if (prev == 'R' && curr == 'S') {

                    collisions += 1;
                    prev = 'S';

                } else if (prev == 'S' && curr == 'L') {

                    collisions += 1;
                    prev = 'S';

                } else {

                    prev = curr;
                }
            }

            return collisions;
        }

}
