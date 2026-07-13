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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayList<Integer> rStruct = new ArrayList<>();
        ArrayList<Integer> subStruct = new ArrayList<>();
        struct(root, rStruct);
        struct(subRoot, subStruct);
        for (int i = 0; i + subStruct.size() <= rStruct.size(); i++) {
            if (rStruct.subList(i, i + subStruct.size()).equals(subStruct)) {
                return true;
            }
        }
        return false;
    }

    private void struct(TreeNode t, ArrayList<Integer> list) {
        if (t == null) {
            list.add(null);
            return;
        }
        list.add(t.val);
        struct(t.left, list);
        struct(t.right, list);
    }
}
