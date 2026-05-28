class Solution {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> letter = new HashMap<Character, Integer>();
        for(int x = 0; x < s.length(); x++){
            char let = s.charAt(x);
            if(!letter.containsKey(let)){
                letter.put(let, 1);
            }
            else{
                letter.replace(let, letter.get(let)+1);
            }
        }
        for(int x = 0; x < t.length(); x++){
            char let = t.charAt(x);
            if(!letter.containsKey(let)){
                return false;
            }
            else{
                int temp = letter.get(let);
                if(temp == 1){
                    letter.remove(let);
                }
                else{
                    letter.replace(let, letter.get(let)-1);
                }
            }
        }
        return letter.isEmpty();
    }
}
