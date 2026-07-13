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
    ArrayList<Integer> subStruct;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        subStruct = treeStruct(subRoot);
        return matcher(root, subRoot);
    }

    public boolean matcher(TreeNode root, TreeNode subRoot){
        if(root == null){
            return false;
        }
        if(root.val == subRoot.val){
            if(treeStruct(root).equals(subStruct)){
                return true;
            }
        }

        boolean first = matcher(root.left, subRoot);
        if(first){
            return true;
        }
        first = matcher(root.right, subRoot);
        return first;
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
