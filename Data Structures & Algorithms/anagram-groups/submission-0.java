class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();
        for(String str : strs){
            Map<Character, Integer> gram = anagramInator(str);
            if(!anagrams.containsKey(gram)){
                List<String> strLst = new ArrayList<>();
                strLst.add(str);
                anagrams.put(gram, strLst);
            }
            else{
                List<String> temp = anagrams.get(gram);
                temp.add(str);
                anagrams.replace(gram, temp);
            }
        }
        return new ArrayList<>(anagrams.values());
    }
    
    public Map<Character, Integer> anagramInator (String str){
        Map<Character, Integer> output = new HashMap<>();
        for(int x = 0; x < str.length(); x++){
            char c = str.charAt(x);
            if(!output.containsKey(c)){
                output.put(c, 1);
            }
            else{
                output.replace(c, output.get(c)+1);
            }
        }
        return output;
    }
}
