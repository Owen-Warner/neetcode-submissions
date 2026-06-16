class Solution {
    public static boolean isValid(String s) {
        String vals = "";
        for(String str : s.split("")) {
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                vals = vals + str;
            }
            else if (str.equals(")")) {
                if(!vals.isEmpty()){
                    String last = String.valueOf(vals.charAt(vals.length() - 1));
                    if(last.equals("(")) {
                        vals = vals.substring(0, vals.length()-1);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else if (str.equals("}")) {
                if(!vals.isEmpty()){
                    String last = String.valueOf(vals.charAt(vals.length() - 1));
                    if(last.equals("{")) {
                        vals = vals.substring(0, vals.length()-1);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
            else if (str.equals("]")) {
                if(!vals.isEmpty()){
                    String last = String.valueOf(vals.charAt(vals.length() - 1));
                    if(last.equals("[")) {
                        vals = vals.substring(0, vals.length()-1);
                    }
                    else{
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return vals.isEmpty();
    }
}
