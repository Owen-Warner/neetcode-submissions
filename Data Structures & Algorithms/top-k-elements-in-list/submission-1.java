class Solution {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            if(!map.containsKey(x)){
                map.put(x, 1);
            }
            else{
                map.replace(x, map.get(x)+1);
            }
        }
        List<Integer> values = new ArrayList<Integer>(map.values());
        values.sort(Collections.reverseOrder());
        int[] output = new int[k];
        for(int x : map.keySet()){
            int val = map.get(x);
            int temp = values.indexOf(val);
            values.set(temp, 0);
            if(temp < k){
                output[temp] = x;
            }
        }
        return output;
        /*
        HashMap<Integer, Integer> swapped = new HashMap<>();
        map.forEach((key, value) -> swapped.put(value, key));
        Set<Integer> keys = swapped.keySet();
        List<Integer> sorted = new ArrayList<>(keys);
        sorted.sort(Collections.reverseOrder());
        int[] output = new int[k];
        for(int x = 0; x < k; x++){
            output[x] = swapped.get(sorted.get(x));
        }
        return output;

         */
    }
}
