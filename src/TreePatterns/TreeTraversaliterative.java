package TreePatterns;
import com.sun.source.tree.Tree;

import java.util.*;


public class TreeTraversaliterative {


    public static List<Integer> inorderIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr= root;
        while (curr !=null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr=curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static List<Integer> preOrderIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root== null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) stack.push(node.right);//right first (LIFO)
            if(node.left != null) stack.push(node.left);
        }
        return result;
    }
    /*
====================================================
STACK 1

Creates order:

Root Right Left

====================================================

STACK 2

Reverses it into:

Left Right Root

====================================================

That's exactly

POSTORDER

====================================================
*/
    /*
====================================================
PREORDER

Root Left Right

====================================================

If we change it to

Root Right Left

====================================================

Then reverse it

====================================================

Left Right Root

====================================================

Exactly Postorder!

====================================================
*/

    public static void postorderIterative(TreeNode root) {

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        /*
        ============================================
        START WITH ROOT
        ============================================
        */
        stack1.push(root);

        while (!stack1.isEmpty()) {

            /*
            ============================================
            POP FROM STACK1
            ============================================
            */
            TreeNode current = stack1.pop();

            /*
            ============================================
            STORE INTO STACK2
            ============================================
            */
            stack2.push(current);

            /*
            ============================================
            PUSH LEFT FIRST
            ============================================
            */
            if (current.left != null) {
                stack1.push(current.left);
            }

            /*
            ============================================
            PUSH RIGHT SECOND
            ============================================
            */
            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        /*
        ============================================
        STACK2 GIVES POSTORDER
        ============================================
        */
        while (!stack2.isEmpty()) {

            System.out.print(
                    stack2.pop().val + " "
            );
        }
    }

    public static void main (String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right= new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);


        System.out.println(
                "Iterative Inorder:" + inorderIterative(root)
        );

        System.out.println(
                "Iterative preorder:" + preOrderIterative(root)
        );

        System.out.println("Postorder Traversal:");

        postorderIterative(root);



    }
}
