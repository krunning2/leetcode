public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ints = new Stack<>();
        String op = "+-*/";
        for(String s : tokens){
            if(op.contains(s)){
                ints.push(cal(ints.pop(), ints.pop(), s));
            }else{
                ints.push(Integer.valueOf(s));
            }
        }
        return ints.isEmpty() ? 0 : ints.peek();
    }
    private int cal(int i1, int i2, String c){
        switch(c){
            case "+" : return i1 + i2;
            case "*" : return i1 * i2;
            case "-" : return i2 - i1;
            case "/": return i2 / i1;
            default : return 0;
        }
    }
}