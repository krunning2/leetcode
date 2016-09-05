public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int x : preorder){
            if(x < min){
                return false;
            }
            while(!stack.isEmpty() && x > stack.peek()){
                min = stack.pop();
            }
            stack.push(x);
        }
        return true;
    }
}