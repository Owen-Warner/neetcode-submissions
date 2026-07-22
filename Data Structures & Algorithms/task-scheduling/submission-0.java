class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] letCounts = new int[26];
        for(char x : tasks){
            letCounts[x-65] = letCounts[x-65]+1;
        }
        PriorityQueue<Integer> order = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : letCounts){
            if(x != 0){
                order.add(x);
            }
        }
        Queue<int[]> cooldown = new ArrayDeque<>();
        while(!order.isEmpty() || !cooldown.isEmpty()){
            if(!order.isEmpty()){
                int temp = order.poll()-1;
                if(temp != 0){
                    int[] temp2 = {time+n, temp};
                    cooldown.add(temp2);
                }
            }
            if(!cooldown.isEmpty()){
                int[] temp3 = cooldown.peek();
                if(temp3[0] == time){
                    order.add(temp3[1]);
                    cooldown.poll();
                }
            }
            time++;
        }
        return time;
    }
}
