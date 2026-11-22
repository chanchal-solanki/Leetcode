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
    public int sumNumbers(TreeNode root) {
        return helper(0,root);        
    }

    public int helper(int prev , TreeNode node){
        if(node == null) return 0;

        int path = prev*10 + node.val;
        if(node.left == null && node.right == null) return path;
        return helper(path,node.left) + helper(path,node.right);
    }
}