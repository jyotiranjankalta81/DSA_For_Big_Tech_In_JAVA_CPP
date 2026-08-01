package TreePatterns;

import java.util.*;

public class TreeDFSPathSum{

    public static boolean hasPathSum(
            TreeNode root,
            int targetSum){

        if(root == null){
            return false;
        }

        // Leaf node
        if(root.left == null &&
                root.right == null){

            return targetSum == root.val;
        }

        int remaining =
                targetSum - root.val;

        return hasPathSum(
                root.left,
                remaining
        )

                ||

                hasPathSum(
                        root.right,
                        remaining
                );
    }

    public static void main(String[] args){

        /*
                    5
                  /   \
                 4     8
                /     / \
               11    13  4
              /  \         \
             7    2         1
        */

        TreeNode root =
                new TreeNode(5);

        root.left =
                new TreeNode(4);

        root.right =
                new TreeNode(8);

        root.left.left =
                new TreeNode(11);

        root.left.left.left =
                new TreeNode(7);

        root.left.left.right =
                new TreeNode(2);

        root.right.left =
                new TreeNode(13);

        root.right.right =
                new TreeNode(4);

        root.right.right.right =
                new TreeNode(1);

        Scanner sc = new Scanner(System.in);

        System.out.print(
                "Enter Target Sum: "
        );

        int target = sc.nextInt();

        boolean ans =
                hasPathSum(root, target);

        System.out.println(
                "Path Exists = " + ans
        );
    }
}
