public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<Integer>();
        int low = Integer.MIN_VALUE;
        for(int x : preorder){
            if(x < low){
                return false;
            }
            while(!stack.isEmpty() && x > stack.peek()){
                low = stack.pop();
            }
            stack.push(x);
        }
        return true;
    }
}