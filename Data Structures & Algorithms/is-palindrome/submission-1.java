class Solution {
   public static boolean isPalindrome(String s) {
        s = keepAlphanumeric(s);
        for(int i = 0; i < s.length()/2; i++){
            char fChar = s.charAt(i);
            char bChar = s.charAt(s.length()-i-1);
            if(fChar != bChar){
                return false;
            }
        }
        return true;
    }

    public static String keepAlphanumeric(String s){
        String output = "";
        for(int i = 0; i < s.length(); i++){
            char fChar = s.charAt(i);
            if(((fChar <= 57 && fChar >= 48) || (fChar >= 97 && fChar <= 122))){
                output = output + fChar;
            }
            else if(fChar >= 65 && fChar <= 90){
                output = output + (char)(fChar+32);
            }
        }
        return output;
    }
}
