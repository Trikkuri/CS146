package Lab;

//Explanation at the bottom

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Lab5 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Constructing a valid BST
        TreeNode root1 = new TreeNode(4, new TreeNode(3, new TreeNode(1), null), new TreeNode(8, new TreeNode(5), new TreeNode(9)));

        // Constructing an invalid BST
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), new TreeNode(8, new TreeNode(5), new TreeNode(6)));

        Lab5 sol = new Lab5();
        System.out.println("Test Case 1 (4, 3, 8, 1, 5, 9): " + sol.isValidBST(root1));
        System.out.println("Test Case 2 (1, 2, 8, 3, 4, 5, 6): " + sol.isValidBST(root2));
    }
}

/*
The isValidBST is used recursively. The original isValidBST method
calls the other isValidBST with bounds min and max. If the tree is
empty the program returns true (empty tree is still a valid BST).
All nodes in the left should be less than the current node and all
nodes to the right must be greater than the current node seen here:
isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max).
If it doesn't satisfy any of those conditions:
(node.val <= min || node.val >= max)
The program will return false.
 */