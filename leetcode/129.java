package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        String s = String.valueOf(root.val);

        if(root.left == null && root.right == null) {
            return Integer.valueOf(s);
        }
        
        if (root.left != null) dfs(root.left, s);
        if (root.right != null) dfs(root.right, s);

        return res;
    }

    static void dfs(TreeNode now, String s) {
        s += String.valueOf(now.val);
        if(now.left == null && now.right == null) {
            res += Integer.valueOf(s);
            return;
        }

        if (now.left != null) dfs(now.left, s);
        if (now.right != null) dfs(now.right, s);
    }
}