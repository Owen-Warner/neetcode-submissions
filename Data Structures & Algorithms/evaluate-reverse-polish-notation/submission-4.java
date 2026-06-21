class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                int i1 = stk.pop();
                int i2 = stk.pop();
                switch (s) {
                    case "+" -> stk.push(i1 + i2);
                    case "-" -> stk.push(i2 - i1);
                    case "/" -> stk.push(i2 / i1);
                    default -> stk.push(i1 * i2);
                }
            }
            else{
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}
