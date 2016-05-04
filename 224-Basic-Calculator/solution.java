public class Solution {
    public int calculate(String s) {
        Stack<Character> ints = new Stack<Character>();
        Stack<Character> opts = new Stack<Character>();
        for(char c : s.toCharArray()){
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
                ints.push(c - 'a');
            }
        }
        while(!opts.isEmpty()){
            ints.push(cal(ins.pop(), ints.pop(), opts.pop()));
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