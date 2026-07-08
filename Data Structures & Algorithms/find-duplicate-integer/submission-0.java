class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int pos = Math.abs(nums[i]);
            int newPos = nums[pos];
            if(newPos < 0){
                return pos;
            }
            else{
                nums[pos] = newPos*-1;
            }
        }
        return nums[0];
    }
}
