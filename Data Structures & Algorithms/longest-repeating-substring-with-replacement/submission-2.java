class Solution {
    public static int characterReplacement(String s, int k) {
        int maxChars = 0;
        String currStr = "";
        HashMap<Character, Integer> cCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            cCount.put(c, cCount.getOrDefault(c, 0) + 1);
            currStr = currStr + c;
            int[] usage = replacements(cCount);
            while(usage[0] > k){
                char start = currStr.charAt(0);
                cCount.put(start, cCount.get(start) - 1);
                currStr = currStr.substring(1);
                usage = replacements(cCount);
            }
            if(currStr.length() > maxChars){
                maxChars = currStr.length();
            }
        }
        return maxChars;
    }

    public static int[] replacements(HashMap<Character, Integer> cCount){
        int biggest = -1;
        int total = 0;
        char bigChar = 0;
        for(char c : cCount.keySet()){
            int temp = cCount.get(c);
            if(temp > biggest){
                bigChar = c;
                biggest = temp;
            }
            total += temp;
        }
        return new int[]{total - biggest, bigChar};
    }
}
