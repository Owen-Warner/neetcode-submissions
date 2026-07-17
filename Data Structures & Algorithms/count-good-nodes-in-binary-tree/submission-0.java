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
    public int goodNodes(TreeNode root) {
        return countList(root).size();
    }

    public ArrayList<Integer> countList(TreeNode root){
        if(root == null){
            return null;
        }
        ArrayList<Integer> subLeft = countList(root.left);
        ArrayList<Integer> subRight = countList(root.right);
        ArrayList<Integer> output = new ArrayList<>();
        if(subLeft != null && subRight != null){
            output.addAll(subLeft);
            output.addAll(subRight);
        }
        else if(subLeft != null){
            output = subLeft;
        }
        else if(subRight != null){
            output = subRight;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for(int x : output){
            if(x >= root.val){
                temp.add(x);
            }
        }
        output = new ArrayList<>(temp);
        output.add(root.val);
        return output;
    }
}
