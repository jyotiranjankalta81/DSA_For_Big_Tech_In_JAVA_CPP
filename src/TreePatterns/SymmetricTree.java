package TreePatterns;

public class SymmetricTree {


    public boolean isSymmetricV1(TreeNode root) {
        return isMirrorV1(root.left, root.right);
    }
    private boolean isMirrorV1(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        return l.val == r.val
                && isMirror(l.left, r.right)
                && isMirror(l.right, r.left);
    }

    /*
   ============================================
   CHECK MIRROR
   ============================================
   */
    public static boolean isMirror(
            TreeNode left,
            TreeNode right) {

        /*
        ============================================
        BOTH NULL

        Mirror

        ============================================
        */
        if (left == null && right == null) {
            return true;
        }

        /*
        ============================================
        ONLY ONE NULL

        Not Mirror

        ============================================
        */
        if (left == null || right == null) {
            return false;
        }

        /*
        ============================================
        VALUES DIFFER

        Not Mirror

        ============================================
        */
        if (left.val != right.val) {
            return false;
        }

        /*
        ============================================
        OUTSIDE

        left.left

        right.right

        ============================================

        INSIDE

        left.right

        right.left

        ============================================
        */
        return isMirror(
                left.left,
                right.right
        )

                &&

                isMirror(
                        left.right,
                        right.left
                );
    }

    public static boolean isSymmetric(
            TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(
                root.left,
                root.right
        );
    }

    public static void main(String[] args) {

        /*
                    1
                  /   \
                 2     2
                / \   / \
               3   4 4   3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(
                "Symmetric = " +
                        isSymmetric(root)
        );
    }
}
