public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int p = 0;
        Stack<Character> ops = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        while(p < s.length()){
            char c = s.charAt(p);
            p++;
            if(isOps(c)){
                while(!ops.isEmpty() && getPriority(ops.peek()) >= getPriority(c)){
                    ints.push(cal(ints.pop(), ints.pop(), ops.pop()));
                }
                ops.push(c);
            }else if(c == ' '){
                continue;
            } else{
                int num = c - '0';
                while(p < s.length() && Character.isDigit(s.charAt(p))){
                    num = num * 10 + s.charAt(p) - '0';
                    p++;
                }
                ints.push(num);
            }
        }
         while(!ops.isEmpty()){
            ints.push(cal(ints.pop(), ints.pop(), ops.pop()));
        }
        return ints.isEmpty() ? 0 : ints.pop();
    }
    
    private boolean isOps(char c){
        return c == '+' || c == '-' || c == '/' || c == '*';
    }
    
    private int getPriority(char c){
        if(c == '-' || c == '+') return 1;
        if(c == '/' || c == '*') return 2;
        return 0;
    }
    
    private int cal(int c1, int c2, char op){
        switch(op){
            case '-' : return c2 - c1;
            case '+' : return c2 + c1;
            case '/' : return c2 / c1;
            case '*' : return c2 * c1;
            default : return 0;
        }
    }
}