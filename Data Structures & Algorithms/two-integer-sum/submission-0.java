class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> loc = new HashMap<>();
        for(int x = 0; x < nums.length; x++){
            int val = nums[x];
            int key = target - val;
            if(loc.containsKey(val)){
                int[] thing = new int[2];
                thing[0] = loc.get(val);
                thing[1] = x;
                return thing;
            }
            loc.put(key, x);
        }
        return null;
    }
}
