public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(arr[i] == ')' && !stack.isEmpty() && arr[stack.peek()] == '('){
                stack.pop();
                if(!stack.isEmpty()){
                    res = Math.max(res, i - stack.peek());
                }else{
                    res = Math.max(i + 1, res);
                }
            }else{
                stack.push(i);
            }
        }
        return res;
    }
}