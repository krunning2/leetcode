public class Solution {
    public int calculate(String s) {
        Stack<Integer> ints = new Stack<Integer>();
        Stack<Character> opts = new Stack<Character>();
        int p = 0;
        while(p < s.length()){
            char c = p.charAt(p);
            if(c == ' '){
                continue;
            }else if(c == '+'){
                opts.push(c);
            }else if(c == '-'){
                opts.push(c);
            }else if(c == '('){
                opts.push(c);
            }else if(c == ')'){
                while(!opts.isEmpty() && opts.peek() != '('){
                    ints.push(cal(ints.pop(), ints.pop(), opts.pop()));
                }
                if(!opts.isEmpty()){ 
                    opts.pop();
                }
            }else{
                int tmp = 0;
                while(p < s.length() && Character.isDigital(s.charAt(p))){
                    tmp = tmp * 10 + (s.chatAt(p) - '0');
                    p++;
                }
                ints.push(tmp);
            }
            p++;
        }
        while(!opts.isEmpty()){
            ints.push(cal(ints.pop(), ints.pop(), opts.pop()));
        }
        return ints.isEmpty() ? 0 : ints.pop();
    }
    private int cal(int c1, int c2, char op){
        if(op == '+'){
            return c1 + c2;
        }else{
            return c2 - c1;
        }
    }
}