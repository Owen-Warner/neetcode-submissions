class Solution {
    public boolean hasDuplicate(int[] nums) {
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        for(int x : nums){
            if(num2.contains(x)){
                return true;
            }
            else{
                num2.add(x);
            }
        }
        return false;
    }
}