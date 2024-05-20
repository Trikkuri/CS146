class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Lab5:
    def is_valid_bst(self, root):
        import sys
        return self._is_valid_bst(root, -sys.maxsize, sys.maxsize)

    def _is_valid_bst(self, node, min_val, max_val):
        if node is None:
            return True
        if not (min_val < node.val < max_val):
            return False
        return (self._is_valid_bst(node.left, min_val, node.val) and
                self._is_valid_bst(node.right, node.val, max_val))

def main():
    root1 = TreeNode(4, TreeNode(3, TreeNode(1), None), TreeNode(8, TreeNode(5), TreeNode(9)))

    root2 = TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4, TreeNode(5), None), None), None), TreeNode(8, TreeNode(5), TreeNode(6)))

    sol = Lab5()
    print("Test Case 1 (4, 3, 8, 1, 5, 9):", sol.is_valid_bst(root1))
    print("Test Case 2 (1, 2, 8, 3, 4, 5, 6):", sol.is_valid_bst(root2))

if __name__ == "__main__":
    main()