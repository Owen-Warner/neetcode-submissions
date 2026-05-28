class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int max = -1;

        while(end != start){
            int e = heights[end];
            int s = heights[start];
            int val;
            if(s > e){
                val = e*(end-start);
                end--;
            }
            else{
                val = s*(end-start);
                start++;
            }
            if(val > max){
                max = val;
            }
        }
        return max;
    }
}
