package TreePatterns;

/*
====================================================
PREORDER
====================================================

Root Left Right

PRINT FIRST

node
left
right

====================================================
INORDER
====================================================

Left Root Right

PRINT MIDDLE

left
node
right

====================================================
POSTORDER
====================================================

Left Right Root

PRINT LAST

left
right
node

====================================================
BFS
====================================================

LEVEL BY LEVEL

Queue

====================================================
*/


    /*
====================================================
INORDER TEMPLATE
====================================================

Left
Root
Right

====================================================
*/
//    inorder(1)
//|
//        +---- inorder(2)
//      |
//              +---- inorder(4)
//              |
//                      +---- null
//                      |
//    Print 4
//            |
//            +---- null
//
//    Print 2
//
//            |
//            +---- inorder(5)
//              |
//    Print 5
//
//    Print 1
//
//            |
//            +---- inorder(3)
//        |
//    Print 3


import java.util.*;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}

public class TreeTraversalRecursive {

    public static void inorder(TreeNode node){

        // Base Case
        if(node == null){
            return;
        }

        // Left
        inorder(node.left);

        // Root
        System.out.print(node.val + "->");

        // Right
        inorder(node.right);
    }
    public static void postorder(TreeNode node){

        // Base Case
        if(node == null){
            return;
        }

        // Left
        inorder(node.left);


        // Right
        inorder(node.right);
        // Root
        System.out.print(node.val + "->");
    }
    public static void preorder(TreeNode node){

        // Base Case
        if(node == null){
            return;
        }


        // Root
        System.out.print(node.val + "->");

        // Left
        inorder(node.left);

        // Right
        inorder(node.right);
    }

    public static void main(String[] args){

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Inorder Traversal:");
        inorder(root);

        System.out.println("preorder Traversal:");
        preorder(root);

        System.out.println("postorder Traversal:");
        postorder(root);

    }
}


/*
====================================================
PREORDER
====================================================

Print First

print(node)

left

right

====================================================

INORDER
====================================================

Print Middle

left

print(node)

right

====================================================

POSTORDER
====================================================

Print Last

left

right

print(node)

====================================================
*/