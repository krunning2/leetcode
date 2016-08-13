public class Solution {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Character> ints = new Stack<>();
        int pos = 0;
        if(s == null || s.length() == 0) return 0;
        while(pos < s.length()){
            char cur = s.charAt(pos);
            if(isOpt(cur)){
                if(priority(ops.peek()) >= priority(cur)){
                    char c2 = ints.pop();
                    char c1 = ints.pop();
                    char op = ops.pop();
                    ints.push(cal(c1, c2, op));
                }
                ops.push(cur);
            }else{
                ints.push(cur);
            }
        }
        while(!ops.isEmpty()){
            char c2 = ints.pop();
            char c1 = ints.pop();
            char op = ops.pop();
            ints.push(cal(c1, c2, op));
        }
        return ints.isEmpty() ? 0 : ints.pop();
    }
    
    private boolean isOpt(char cur){
        return cur == '+' || cur == '-' || cur == '*' || cur == '/';
    }
    
    private int priority(char c1){
        if(c1 == '+' || c1 == '-') return 1;
        if(c1 == '*' || c1 == '/') return 2;
        return 0;
    }
    private int cal(char i1, char i2, char ops){
        switch(ops){
            case '+' : return (i1 - '0') + (i2 - '0');
            case '-' : return (i1 - '0') - (i2 - '0');
            case '*' : return (i1 - '0') * (i2 - '0');
            case '/' : return (i1 - '0') / (i2 - '0');
        }
        return 0;
    }
}