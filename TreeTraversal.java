import java.util.*; // Import List and ArrayList

public class TreeTraversal {

    // Inner static class for TreeNode
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // --- Inorder Traversal (Left → Root → Right) ---
    List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }

    void inorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderHelper(node.left, res);
        res.add(node.val);
        inorderHelper(node.right, res);
    }

    // --- Preorder Traversal (Root → Left → Right) ---
    List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }

    void preorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorderHelper(node.left, res);
        preorderHelper(node.right, res);
    }

    // --- Postorder Traversal (Left → Right → Root) ---
    List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    void postorderHelper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        postorderHelper(node.left, res);
        postorderHelper(node.right, res);
        res.add(node.val);
    }

    // --- Main method to execute ---
    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();

        // Building a sample binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \   / \
        //    4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // Perform traversals
        List<Integer> inorder = tree.inorder(root);
        List<Integer> preorder = tree.preorder(root);
        List<Integer> postorder = tree.postorder(root);

        // Print results
        System.out.println("Inorder Traversal: " + inorder);
        System.out.println("Preorder Traversal: " + preorder);
        System.out.println("Postorder Traversal: " + postorder);
    }
}
