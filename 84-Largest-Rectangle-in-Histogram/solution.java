public class Solution {
    
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
         int i = 0;
         int maxArea = 0;
         while(i < height.length){
             if(stack.isEmpty() || height[stack.peek()] <= height[i]){
                 stack.push(i++);
             }else {
                 int t = stack.pop();
                 maxArea = Math.max(maxArea, height[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
             }
         }
         return maxArea;
    }
}