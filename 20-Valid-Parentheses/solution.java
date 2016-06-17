public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                char cur = get(c);
                if(stack.isEmpty() || stack.peek() != cur) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private char get(char c){
        switch(c) {
            case ')': return '(';
            case '}': return '{';
            case ']': return '[';
            default : return '0';
        }
    }
}