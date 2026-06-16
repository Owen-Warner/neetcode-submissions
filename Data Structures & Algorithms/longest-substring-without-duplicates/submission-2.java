class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        String currStr = "";
        Set<Character> chars = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int setLen = chars.size();
            chars.add(c);
            if(setLen != chars.size()){
                currStr = currStr + c;
            }
            else{
                int pos = currStr.indexOf(c);
                if(currStr.length() > maxLen){
                    maxLen = currStr.length();
                }
                for(int p = 0; p <= pos; p++){
                    chars.remove(currStr.charAt(0));
                    currStr = currStr.substring(1);
                }
                chars.add(c);
                currStr = currStr + c;
            }
        }
        if(currStr.length() > maxLen){
            maxLen = currStr.length();
        }
        return maxLen;
    }
}
