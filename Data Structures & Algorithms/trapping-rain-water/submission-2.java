class Solution {
    public static int trap(int[] height) {
        int water = 0;
        int prevHeight = -1;
        for(int x = 0; x < height.length; x++){
            //System.out.println(x);
            int ht = height[x];
            if(prevHeight == -1 && ht == 0){
                prevHeight = -1;
            }
            else if(ht>prevHeight){
                prevHeight = ht;
            }
            else if(prevHeight > ht){
                int[] wt = waterAmt(height, x-1);
                x = wt[0]-1;
                water += wt[1];
                prevHeight = height[x+1];
            }
        }
        return water;
    }

    public static int[] waterAmt(int[] height, int start){
        int[] output = new int[2];
        int sHt = height[start];
        int highest = -1;
        int highPos = -1;
        for(int x = start+1; x < height.length; x++){
            int testHt = height[x];
            if(testHt >= sHt){
                highest = testHt;
                highPos = x;
                x = height.length;
            }
            else if((testHt > highest) && testHt != 0){
                highest = testHt;
                highPos = x;
            }
        }
        if(highest == -1){
            output[0] = height.length-1;
        }
        else{
            int water = 0;
            int lp;
            if(sHt > highest){
                lp = highest;
            }
            else{
                lp = sHt;
            }
            for(int x = start+1; x < highPos; x++){
                int testHt = height[x];
                water += lp-testHt;
            }
            output[0] = highPos;
            output[1] = water;
        }
        return output;
    }
}
