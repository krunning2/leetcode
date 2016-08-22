public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> digs = new Stack<>();
        for(String t : tokens){
            if("+-*/".contains(t)){
                int d1 = Integer.valueOf(digs.pop());
                int d2 = Integer.valueOf(digs.pop());
                digs.push(String.valueOf(cal(d1, d2, t)));
            }else{
                digs.push(t);
            }
        }
        return Integer.valueOf(digs.pop());
    }
    private int cal(int d1, int d2, String op){
        switch(op){
            case "+" : return d1 + d2;
            case "*" : return d1 * d2;
            case "/" : return d2 / d1;
            case "-" : return d2 - d1;
            default: return 0;
        }
    }
}