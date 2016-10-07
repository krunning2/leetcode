public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        if(tokens == null || tokens.length == 0) return 0;
        int p = 0;
        String ops = "+-*/";
        while(p < tokens.length){
            if(ops.contains(tokens[p])){
                stack.push(cal(tokens[p], stack.pop(), stack.pop()));
            }else{
                stack.push(Integer.valueOf(tokens[p]));
            }
            p++;
        }
        if(!stack.isEmpty()) return stack.pop();
        return 0;
    }
    private int cal(String op, int a, int b){
        switch(op){
            case "+": return a + b;
            case "*": return a * b;
            case "-": return b - a;
            case "/": return b / a;
            default: return 0;
        }
    }
}