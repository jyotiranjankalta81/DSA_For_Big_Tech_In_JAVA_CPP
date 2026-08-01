package TreePatterns;

/*
====================================================
ALGORITHM

1. Create Queue

2. Add Root

3. While Queue is NOT Empty

    Remove Front Node

    Process Node

    Add Left Child

    Add Right Child

4. Repeat

====================================================

Queue maintains

Level Order automatically.

====================================================
*/

/*
====================================================
BFS (LEVEL ORDER)
====================================================

Visit nodes

LEVEL BY LEVEL

====================================================

Unlike DFS

which goes deep first,

BFS visits all nodes
of current level first.

====================================================

DATA STRUCTURE

QUEUE

====================================================

Why Queue?

FIFO

First In First Out

First node inserted

is processed first.

====================================================
*/

import java.util.*;


public class LevelOrderBFS {

    public static void levelOrder(TreeNode root) {

        if (root == null) {
            return;
        }

        /*
        ============================================
        QUEUE STORES NODES
        TO VISIT NEXT
        ============================================
        */
        Queue<TreeNode> queue =
                new LinkedList<>();

        // Start with root
        queue.offer(root);

        while (!queue.isEmpty()) {

            /*
            ============================================
            REMOVE FRONT NODE
            ============================================
            */
            TreeNode current =
                    queue.poll();

            /*
            ============================================
            PROCESS CURRENT NODE
            ============================================
            */
            System.out.print(
                    current.val + " "
            );

            /*
            ============================================
            ADD LEFT CHILD
            ============================================
            */
            if (current.left != null) {
                queue.offer(current.left);
            }

            /*
            ============================================
            ADD RIGHT CHILD
            ============================================
            */
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }


    public static  List levelOrderList(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right));
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
             /  \   /  \
            4   5  6    7
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Level Order:");

        levelOrder(root);

        System.out.println("Level Order With Level: " + levelOrderList(root));

        System.out.println("Height: " + height(root));

    }
}