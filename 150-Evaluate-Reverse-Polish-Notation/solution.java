public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack();
        for(int i = 0 ; i < tokens.length; i++){
            String cur = tokens[i];
            if("+-*/".contains(cur)){
                int d1 = Integer.valueOf(stack.pop());
                int d2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(cal(d1, d2, cur)));
            }else{
                stack.push(cur);
            }
        }
        return Integer.valueOf(stack.pop());
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