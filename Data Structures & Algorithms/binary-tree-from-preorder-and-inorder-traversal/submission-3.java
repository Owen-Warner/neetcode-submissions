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
        if(preorder.length == 0){
            return null;
        }
        int loc = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                loc = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0, loc);
        int[] rightIn = Arrays.copyOfRange(inorder, loc+1, inorder.length);
        int[] leftPre = Arrays.copyOfRange(preorder, 1, 1 + leftIn.length);
        int[] rightPre = Arrays.copyOfRange(preorder, 1 + leftIn.length, preorder.length);

        TreeNode output = new TreeNode(preorder[0]);
        output.left = buildTree(leftPre, leftIn);
        output.right = buildTree(rightPre, rightIn);
        return output;
    }
}
