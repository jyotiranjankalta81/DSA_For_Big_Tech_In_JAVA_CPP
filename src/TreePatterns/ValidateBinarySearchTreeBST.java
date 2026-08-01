package TreePatterns;
import java.util.*;
public class ValidateBinarySearchTreeBST {

    /*
    ====================================================
    ROOT

    Allowed Range

    (-∞ , +∞)

    ====================================================

    LEFT CHILD

    (-∞ , root)

    ====================================================

    RIGHT CHILD

    (root , +∞)

    ====================================================

    As we go down,

    range becomes smaller.

    ====================================================
    */
    public static boolean CheckAndValidateBst(TreeNode node,long min ,long max){
        if(node == null){
            return true;
        }

/*
        ============================================
        CURRENT NODE MUST BE

        min < value < max

        ============================================
        */


        System.out.println("Minval " + min + " MaxVal "+ max + " Val " + node.val);

        if(node.val <= min || node.val >= max){
            return false;
        }

        /*
        ============================================
        CHECK LEFT SUBTREE

        Max becomes current value

        ============================================
        */
        boolean left =
                CheckAndValidateBst(
                        node.left,
                        min,
                        node.val
                );

        /*
        ============================================
        CHECK RIGHT SUBTREE

        Min becomes current value

        ============================================
        */
        boolean right =
                CheckAndValidateBst(
                        node.right,
                        node.val,
                        max
                );

        return left && right;
    }

    public static void main(String[] args) {

        /*
                 5
               /   \
              3     8
             / \   / \
            2   4 6   9
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        boolean ans =
                CheckAndValidateBst(
                        root,
                        Long.MIN_VALUE,
                        Long.MAX_VALUE
                );

        System.out.println(
                "Valid BST = " + ans
        );
    }
}
