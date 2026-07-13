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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        else if(p == null || q == null){
            return false;
        }
        ArrayList<Integer> t1 = treeStruct(p);
        ArrayList<Integer> t2 = treeStruct(q);
        return t1.equals(t2);
    }

    public ArrayList<Integer> treeStruct(TreeNode t){
        if(t == null){
            return null;
        }
        else{
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(t.val);
            ArrayList<Integer> temp2 = treeStruct(t.left);
            if(temp2 == null){
                temp.add(null);
            }
            else{
                temp.addAll(temp2);
            }
            temp2 = treeStruct(t.right);
            if(temp2 == null){
                temp.add(null);
            }
            else{
                temp.addAll(temp2);
            }
            return temp;
        }
    }
}
