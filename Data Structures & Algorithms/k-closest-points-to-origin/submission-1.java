class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> vals = new PriorityQueue<>((a, b) -> {
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];
            return distB - distA;
        });
        for(int i = 0; i < points.length; i++){
            vals.add(points[i]);
            if(vals.size() > k){
                vals.poll();
            }
        }
        return vals.toArray(new int[k][]);
    }
}
