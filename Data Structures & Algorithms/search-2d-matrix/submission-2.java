class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix[0][0] > target){
            return false;
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] > target){
                int temp = search(matrix[i-1], target);
                return temp != -1;
            }
        }
        int temp = search(matrix[matrix.length-1], target);
        return temp != -1;
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            else if (nums[m] < target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return -1;
    }
}
