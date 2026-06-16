class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character, Integer> expected = new HashMap<>();
        for(String c : s1.split("")){
            char c1 = c.charAt(0);
            if(expected.containsKey(c1)){
                expected.replace(c1, expected.get(c1)+1);
            }
            else{
                expected.put(c1, 1);
            }
        }
        HashMap<Character, Integer> current = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char c1 = s2.charAt(i);
            if(current.containsKey(c1)){
                current.replace(c1, current.get(c1)+1);
            }
            else{
                current.put(c1, 1);
            }
        }
        if(current.equals(expected)) return true;
        for(int i = s1.length(); i < s2.length(); i++){
            char oldChar = s2.charAt(i-s1.length());
            char newChar = s2.charAt(i);
            int cVal = current.get(oldChar);
            if(cVal == 1){
                current.remove(oldChar);
            }
            else{
                current.replace(oldChar, cVal-1);
            }
            if(current.containsKey(newChar)){
                current.replace(newChar, current.get(newChar)+1);
            }
            else{
                current.put(newChar, 1);
            }
            if(current.equals(expected)){
                return true;
            }
        }
        return false;
    }
}
