package TreePatterns;

import java.util.*;


public class MaxPathSum {

    // Stores maximum path sum found
    static int maxSum = Integer.MIN_VALUE;

    public static int dfs(TreeNode root) {

        /*
        ============================================
        EMPTY NODE

        Returns 0

        ============================================
        */
        if (root == null) {
            return 0;
        }

        /*
        ============================================
        NEGATIVE PATHS ARE USELESS

        Ignore them

        ============================================
        */
        int leftGain = Math.max(
                0,
                dfs(root.left)
        );

        int rightGain = Math.max(
                0,
                dfs(root.right)
        );

        /*
        ============================================
        PATH PASSING THROUGH
        CURRENT NODE

        ============================================
        */
        int currentPath =
                root.val +
                        leftGain +
                        rightGain;

        /*
        ============================================
        UPDATE GLOBAL ANSWER

        ============================================
        */
        maxSum = Math.max(
                maxSum,
                currentPath
        );

        /*
        ============================================
        RETURN ONLY ONE SIDE

        Parent cannot take both

        ============================================
        */
        return root.val +
                Math.max(
                        leftGain,
                        rightGain
                );
    }

    public static void main(String[] args) {

        /*
                  -10
                 /    \
                9      20
                      /  \
                    15    7
        */

        TreeNode root =
                new TreeNode(-10);

        root.left =
                new TreeNode(9);

        root.right =
                new TreeNode(20);

        root.right.left =
                new TreeNode(15);

        root.right.right =
                new TreeNode(7);

        dfs(root);

        System.out.println(
                "Maximum Path Sum = " + maxSum
        );
    }
}