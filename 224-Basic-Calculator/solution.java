public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        s = s.trim();
        Stack<Character> ops = new Stack<>();
        Stack<Integer> ints = new Stack<>();
        int p = 0;
        while(p < s.length()){
            char cur = s.charAt(p);
            
            if(cur == ' '){
                p++;
                continue;
            }else if(cur == '+' || cur == '-'){
                while(!ops.isEmpty() && (ops.peek() == '+' || ops.peek() == '-')){
                    ints.push(cal(ints.pop(), ints.pop(), ops.pop()));
                }
                ops.push(cur);
            }else if(cur == '('){
                ops.push(cur);
            }else if(cur == ')'){
                while(!ops.isEmpty() && ops.peek() != '('){
                    ints.push(cal(ints.pop(), ints.pop(), ops.pop()));
                }
                if(!ops.isEmpty()) ops.pop();
            }else{
                int num = 0;
                while(p < s.length() && Character.isDigit(s.charAt(p))){
                    num = num * 10 + s.charAt(p) - '0';
                    p++;
                }
                p--;
                ints.push(num);
            }
            p++;
        }
        while(!ops.isEmpty()){
            ints.push(cal(ints.pop(), ints.pop(), ops.pop()));
        }
        return ints.isEmpty() ? 0 : ints.peek();
    }
    private int cal(int a, int b, char op){
        if(op == '+') return a + b;
        if(op == '-') return b - a;
        return 0;
    }
}