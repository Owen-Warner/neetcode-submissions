class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()){
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()){
            need.merge(c, 1, Integer::sum);
        }
        HashMap<Character, Integer> window = new HashMap<>();
        int have = 0;
        int required = need.size();
        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int minL = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.merge(c, 1, Integer::sum);
            if (need.containsKey(c) && window.get(c).equals(need.get(c))){
                have++;
            }
            while (have == required) {
                if (r - l + 1 < minLen) { minLen = r - l + 1; minL = l; }
                char lc = s.charAt(l++);
                window.merge(lc, -1, Integer::sum);
                if (need.containsKey(lc) && window.get(lc) < need.get(lc)){
                    have--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minL, minL + minLen);
    }
}
