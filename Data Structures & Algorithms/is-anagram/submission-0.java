class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        for(String x : s.split("")){
            int loc = t.indexOf(x);
            if(loc == -1){
                return false;
            }
            else{
                t = t.substring(0, loc) + t.substring(loc+1);
            }
        }
        return t.isEmpty();
    }
}
