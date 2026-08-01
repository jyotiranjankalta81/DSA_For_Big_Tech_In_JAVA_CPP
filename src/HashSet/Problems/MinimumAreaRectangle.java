package HashSet.Problems;

import java.util.HashSet;

public class MinimumAreaRectangle {

    public static int minArea(int[][] arr) {

        HashSet<String> set = new HashSet<>();

        // Store all points
        for (int i = 0; i < arr.length; i++) {

            int x = arr[i][0];
            int y = arr[i][1];

            set.add(x + "," + y);
        }

        int area = Integer.MAX_VALUE;

        // Compare every pair of points
        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int x1 = arr[i][0];
                int y1 = arr[i][1];

                int x2 = arr[j][0];
                int y2 = arr[j][1];

                // Same row or same column cannot be diagonal
                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                // Check the other two corners
                if (set.contains(x1 + "," + y2) &&
                        set.contains(x2 + "," + y1)) {

                    int currentArea = Math.abs(x1 - x2) * Math.abs(y1 - y2);

                    area = Math.min(area, currentArea);
                }
            }
        }

        return area == Integer.MAX_VALUE ? 0 : area;
    }

    public static void main(String[] args) {

        int[][] points = {
                {1, 1},
                {1, 3},
                {3, 1},
                {3, 3},
                {2, 2}
        };

        int ans = minArea(points);

        System.out.println("Minimum Area = " + ans);
    }
}