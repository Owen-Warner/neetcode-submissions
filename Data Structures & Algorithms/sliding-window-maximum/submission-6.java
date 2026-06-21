class Solution {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int biggest = nums[0];
        int age = 0;
        ArrayList<Integer> vals = new ArrayList<>();
        int[] bigVals = new int[nums.length-k+1];
        for(int i = 0; i < k; i++){
            int num = nums[i];
            vals.add(num);
            age++;
            if(num >= biggest){
                biggest = num;
                age = 0;
            }
        }
        bigVals[0] = biggest;
        for(int i = k; i < nums.length; i++){
            int num = nums[i];
            vals.remove(0);
            vals.add(num);
            if(age == k-1){
                age = -1;
                biggest = vals.get(0);
                for(int x:vals){
                    age++;
                    if(x>biggest){
                        biggest = x;
                        age = 0;
                    }
                }
            }
            else{
                age++;
                if(num > biggest){
                    biggest = num;
                    age = 0;
                }
            }
            bigVals[i-k+1] = biggest;
        }
        return bigVals;
    }
}
