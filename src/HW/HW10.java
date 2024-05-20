package HW;

import java.util.*;

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

public class HW10 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static TreeNode buildTree(String[] parts) {
        if (parts[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < parts.length) {
            TreeNode currentNode = queue.poll();

            if (!parts[i].equals("null")) {
                currentNode.left = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(currentNode.left);
            }
            i++;

            if (i < parts.length && !parts[i].equals("null")) {
                currentNode.right = new TreeNode(Integer.parseInt(parts[i]));
                queue.offer(currentNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the nodes for binary tree, use 'null' for empty nodes:");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");

        TreeNode root = buildTree(parts);
        List<List<Integer>> result = new HW10().levelOrder(root);

        if (result.isEmpty()) {
            System.out.println("none");
        } else {
            for (List<Integer> level : result) {
                System.out.println(level);
            }
        }
        scanner.close();
    }
}
