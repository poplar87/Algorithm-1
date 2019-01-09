
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int _val,TreeNode _left,TreeNode _right)
    {
        this.val=_val;
        this.left=_left;
        this.right=_right;
    }
}
public class SortArrToBinaryTree {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortArrToBinaryTree sortArrToBinaryTree = new SortArrToBinaryTree();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        TreeNode root = null;
        for (int i : arr) {
            root=sortArrToBinaryTree.insertNode(root, i);
        }
    }
    TreeNode insertNode(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val, null, null);
        if (val < root.val)
            root.left = insertNode(root.left, val);
        else if (val > root.val)
            root.right = insertNode(root.right, val);
        return root;
    }
}
