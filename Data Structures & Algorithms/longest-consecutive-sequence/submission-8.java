class Solution {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int maxLength = 0;
        Set<Integer> visited = new HashSet<>();
        for (int num : numSet) {
            if (!visited.contains(num) && !numSet.contains(num - 1)) {
                int current = num;
                int length = 0;
                while (numSet.contains(current)) {
                    visited.add(current);
                    current++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}