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
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTExt(root, -1001, 1001);
    }

    private static boolean isValidBSTExt(TreeNode node, int lower, int upper) {
        if (node == null){
            return true;
        }
        if (node.val <= lower || node.val >= upper){
            return false;
        }
        return isValidBSTExt(node.left, lower, node.val) && isValidBSTExt(node.right, node.val, upper);
    }
}
