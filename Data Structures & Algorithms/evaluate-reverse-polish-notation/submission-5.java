class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s : tokens){
            switch (s) {
                case "+" -> {
                    int i1 = stk.pop();
                    int i2 = stk.pop();
                    stk.push(i1 + i2);
                }
                case "-" -> {
                    int i1 = stk.pop();
                    int i2 = stk.pop();
                    stk.push(i2 - i1);
                }
                case "/" -> {
                    int i1 = stk.pop();
                    int i2 = stk.pop();
                    stk.push(i2 / i1);
                }
                case "*" -> {
                    int i1 = stk.pop();
                    int i2 = stk.pop();
                    stk.push(i1 * i2);
                }
                default -> stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
}
