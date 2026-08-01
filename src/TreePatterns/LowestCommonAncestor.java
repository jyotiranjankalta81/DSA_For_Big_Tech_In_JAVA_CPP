package TreePatterns;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        /*
        ============================================
        BASE CASE

        Tree ended

        ============================================
        */
        if (root == null) {
            return null;
        }

        /*
        ============================================
        FOUND P OR Q

        Return current node

        ============================================
        */
        if (root == p || root == q) {
            return root;
        }

        /*
        ============================================
        SEARCH LEFT SUBTREE

        ============================================
        */
        TreeNode left =
                lowestCommonAncestor(
                        root.left,
                        p,
                        q
                );

        /*
        ============================================
        SEARCH RIGHT SUBTREE

        ============================================
        */
        TreeNode right =
                lowestCommonAncestor(
                        root.right,
                        p,
                        q
                );

        /*
        ============================================
        BOTH SIDES FOUND

        Current node is LCA

        ============================================
        */
        if (left != null && right != null) {
            return root;
        }

        /*
        ============================================
        ONLY ONE SIDE FOUND

        Return that side

        ============================================
        */
        if (left != null) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {

        /*
                      3
                    /   \
                   5     1
                 /  \   / \
                6    2 0   8
                    / \
                   7   4
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left.right.left;   // 7
        TreeNode q = root.left.right.right;  // 4

        TreeNode ans =
                lowestCommonAncestor(root, p, q);

        System.out.println(
                "LCA = " + ans.val
        );
    }
}