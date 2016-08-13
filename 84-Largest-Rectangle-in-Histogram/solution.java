public class Solution {
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = i == height.length ? -1 : height[i];
            while(!stack.isEmpty() && height[stack.peek()] >= cur){
                int h = height[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * len);
            }
            stack.push(i);
        }
        return max;
    }
}