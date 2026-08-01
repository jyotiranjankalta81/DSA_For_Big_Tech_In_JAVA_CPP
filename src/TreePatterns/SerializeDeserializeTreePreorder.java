package TreePatterns;

public class SerializeDeserializeTreePreorder {

    public  static void serialize(TreeNode root,StringBuilder sb){
        if (root == null) {

            sb.append("null,");
            return;
        }

        // Store current node
        sb.append(root.val).append(",");

        // Serialize left subtree
        serialize(root.left, sb);

        // Serialize right subtree
        serialize(root.right, sb);
    }

    /*
    ============================================
    DESERIALIZE
    ============================================
    */

    static int index = 0;

    public static TreeNode deserialize(
            String[] data) {

        // Null node
        if (data[index].equals("null")) {

            index++;
            return null;
        }

        // Create current node
        TreeNode root =
                new TreeNode(
                        Integer.parseInt(
                                data[index++]
                        )
                );

        // Build left subtree
        root.left =
                deserialize(data);

        // Build right subtree
        root.right =
                deserialize(data);

        return root;
    }
    /*
    ============================================
    PREORDER PRINT
    ============================================
    */

    public static void preorder(TreeNode root){

        if(root==null){
            System.out.print("null ");
            return;
        }

        System.out.print(root.val+" ");

        preorder(root.left);

        preorder(root.right);
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
                 / \
                4   5
        */

        TreeNode root =
                new TreeNode(1);

        root.left =
                new TreeNode(2);

        root.right =
                new TreeNode(3);

        root.right.left =
                new TreeNode(4);

        root.right.right =
                new TreeNode(5);

        /*
        ============================================
        SERIALIZE
        ============================================
        */

        StringBuilder sb =
                new StringBuilder();

        serialize(root, sb);

        String serialized =
                sb.toString();

        System.out.println(
                "Serialized:"
        );

        System.out.println(serialized);

        /*
        ============================================
        DESERIALIZE
        ============================================
        */

        String[] data =
                serialized.split(",");

        index = 0;

        TreeNode newRoot =
                deserialize(data);

        System.out.println(
                "\nPreorder After Deserialize:"
        );

        preorder(newRoot);
    }
}
