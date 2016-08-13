public class Solution {
    public int calculate(String s) {
        Stack<Character> ops = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        int pos = 0;
        if(s == null || s.length() == 0) return 0;
        while(pos < s.length()){
            char cur = s.charAt(pos);
            pos ++;
            if(isOpt(cur)){
                // because once lower/equal priority operation comes, all the calculation should be done.
                while(!ops.isEmpty() && priority(ops.peek()) >= priority(cur)){
                    int c2 = ints.pop();
                    int c1 = ints.pop();
                    char op = ops.pop();
                    ints.push(cal(c1, c2, op));
                }
                ops.push(cur);
            }else if(cur == ' '){
                continue;
            }else{
                int tmp = cur - '0';
                while(pos < s.length() && Character.isDigit(s.charAt(pos))){
                    tmp = tmp * 10 + (s.charAt(pos) - '0');
                    pos ++;
                }
                ints.push(tmp);
            }
        }
        while(!ops.isEmpty()){
            int c2 = ints.pop();
            int c1 = ints.pop();
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
    private int cal(int i1, int i2, char ops){
        switch(ops){
            case '+' : return i1 + i2;
            case '-' : return i1 - i2;
            case '*' : return i1 * i2;
            case '/' : return i1 / i2;
        }
        return 0;
    }
}