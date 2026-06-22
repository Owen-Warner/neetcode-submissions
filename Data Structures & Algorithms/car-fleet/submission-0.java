class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> position[b] - position[a]);
        Deque<Double> stack = new ArrayDeque<>();
        for (int i : index) {
            double t = (double)(target - position[i]) / speed[i];
            if (stack.isEmpty() || t > stack.peek())
                stack.push(t);
        }
        return stack.size();
    }
}
