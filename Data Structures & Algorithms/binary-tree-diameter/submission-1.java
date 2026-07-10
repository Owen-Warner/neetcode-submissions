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
    private int best;

    public int diameterOfBinaryTree(TreeNode root) {
        best = 0;
        maxDepth(root);
        return best;
    }

  private int maxDepth(TreeNode node) {
      if (node == null) return 0;
      int left = maxDepth(node.left);
      int right = maxDepth(node.right);
      best = Math.max(best, left + right);
      return Math.max(left, right) + 1;
  }
}
