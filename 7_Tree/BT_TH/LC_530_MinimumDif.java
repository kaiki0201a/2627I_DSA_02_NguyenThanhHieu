package BT_TH;

import edu.princeton.cs.algs4.In;

public class LC_530_MinimumDif {
    public int getMinimumDifference(TreeNode root) {
        return miniMum(root, Integer.MAX_VALUE);
    }

    public int findMin(TreeNode root) {
        int res = root.val;
        while (root.left != null){
            root = root.left;
            res = root.val;
        }

        return res;
    }
    public int findMax(TreeNode root) {
        int res = root.val;
        while (root.right != null){
            root = root.right;
            res = root.val;
        }

        return res;
    }

    public int miniMum(TreeNode root, int res){
        if (root == null){
            return res;
        }

        int left = (root.left != null) ? root.val - findMax(root.left) : Integer.MAX_VALUE;
        int right = (root.right != null) ? findMin(root.right) - root.val: Integer.MAX_VALUE;
        res = Math.min(res, left);
        res = Math.min(res, right);

        int nL = miniMum(root.left, res);
        int nR = miniMum(root.right, res);

        res = Math.min(res, nL);
        res = Math.min(res, nR);

        return res;
    }

}
