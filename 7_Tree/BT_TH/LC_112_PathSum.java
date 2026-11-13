package BT_TH;
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


public class LC_112_PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum2(root, targetSum, 0);
    }

    public boolean hasPathSum2(TreeNode root, int targetSum, int cur) {
        if (root == null) return false;

        if (cur + root.val == targetSum) return true;

        return hasPathSum2(root.left, targetSum, cur + root.val) || hasPathSum2(root.right, targetSum, cur + root.val);
    }
}
