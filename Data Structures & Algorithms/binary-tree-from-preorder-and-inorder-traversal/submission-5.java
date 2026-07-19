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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndex = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }
        return buildTreeTwo(preorder, new int[]{0}, inorderIndex, 0, inorder.length - 1);
    }

    private TreeNode buildTreeTwo(int[] preorder, int[] preIdx, Map<Integer, Integer> inorderIndex, int inStart, int inEnd) {
        if(inStart > inEnd){
            return null;
        }
        int rootVal = preorder[preIdx[0]++];
        TreeNode output = new TreeNode(rootVal);
        int loc = inorderIndex.get(rootVal);
        output.left = buildTreeTwo(preorder, preIdx, inorderIndex, inStart, loc - 1);
        output.right = buildTreeTwo(preorder, preIdx, inorderIndex, loc + 1, inEnd);
        return output;
    }
}
