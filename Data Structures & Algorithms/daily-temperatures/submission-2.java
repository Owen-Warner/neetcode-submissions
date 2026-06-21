class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<ArrayList<Integer>> stk = new Stack<>();
        int[] output = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int currTemp = temperatures[i];
            int temp = temperatures[i];
            boolean cont = true;
            if(!stk.isEmpty()){
                while(cont){
                    ArrayList<Integer> x = stk.peek();
                    if(x.get(0) < currTemp){
                        stk.pop();
                        output[x.get(1)] = i - x.get(1);
                        if(stk.isEmpty()){
                            cont = false;
                        }
                    }
                    else{
                        cont = false;
                    }
                }
            }
            ArrayList<Integer> pos = new ArrayList<>();
            pos.add(temperatures[i]);
            pos.add(i);
            stk.push(pos);
        }
        return output;
    }
}
