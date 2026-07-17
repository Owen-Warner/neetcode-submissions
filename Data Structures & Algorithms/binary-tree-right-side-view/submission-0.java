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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> mostRight = new ArrayList<>();
        Queue<TreeNode> currQueue = new ArrayDeque<>();
        Queue<TreeNode> nextQueue = new ArrayDeque<>();
        if(root != null) currQueue.add(root);
        while(!currQueue.isEmpty()){
            int i = currQueue.size();
            for(int i2 = 0; i2 < i-1; i2++){
                TreeNode temp = currQueue.poll();
                if(temp.left != null){
                    nextQueue.add(temp.left);
                }
                if(temp.right != null){
                    nextQueue.add(temp.right);
                }
            }
            TreeNode temp = currQueue.poll();
            if(temp.left != null){
                nextQueue.add(temp.left);
            }
            if(temp.right != null){
                nextQueue.add(temp.right);
            }
            currQueue = new ArrayDeque<>(nextQueue);
            nextQueue.clear();
            mostRight.add(temp.val);
        }
        return mostRight;
    }
}
