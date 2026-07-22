class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        for(int i : nums){
            numbers.add(i);
            if(numbers.size() > k){
                numbers.poll();
            }
        }
        return numbers.poll();
    }
}
