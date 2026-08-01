package TreePatterns;

import java.util.*;

public class HeightAndDiameter {

    // Stores the maximum diameter found
    static int diameter = 0;

    public static int height(TreeNode root) {

        /*
        ============================================
        EMPTY TREE

        Height = 0

        ============================================
        */
        if (root == null) {
            return 0;
        }

        /*
        ============================================
        GET LEFT HEIGHT

        ============================================
        */
        int leftHeight =
                height(root.left);

        /*
        ============================================
        GET RIGHT HEIGHT

        ============================================
        */
        int rightHeight =
                height(root.right);

        /*
        ============================================
        DIAMETER THROUGH CURRENT NODE

        leftHeight + rightHeight

        ============================================
        */
        diameter = Math.max(
                diameter,
                leftHeight + rightHeight
        );

        /*
        ============================================
        RETURN HEIGHT

        1 + max(left,right)

        ============================================
        */
        return 1 + Math.max(
                leftHeight,
                rightHeight
        );
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     3
                / \
               4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        height(root);

        System.out.println(
                "Diameter = " + diameter
        );
    }
}