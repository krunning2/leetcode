public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '{' || cur == '(' || cur == '['){
                stack.push(cur);
            }else{
                if(stack.isEmpty()) return false;
                char peek = stack.pop();
                if(cur == '}' && peek != '{' || cur == ']' && peek != '[' || cur == ')' && peek != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}