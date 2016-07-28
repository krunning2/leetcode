public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        for(int i = 0 ; i < tokens.length; i++){
            String cur = tokens[i];
            if("+-*/".contains(cur)){
                int d1 = Integer.valueOf(stack.pop());
                int d2 = Integer.valueOf(stack.pop());
                stack.push(cal(d1, d2, cur));
            }else{
                stack.push(cur);
            }
        }
        if(!stack.isEmpty()){
            int d1 = Integer.valueOf(stack.pop());
            int d2 = Integer.valueOf(stack.pop());
            return cal(d1, d2, op);
        }
        return 0;
    }
    private int cal(int d1, int d2, String op){
        switch(op){
            case "+" : return (d1 + d2);
            case "*" : return (d1 * d2);
            case "-" : return (d2 - d1);
            case "/" : return (d2 / d1);
            default : return 0;
        }
    }
}