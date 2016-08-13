public class Solution {
    
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = i == height.length ? -1 : height[i];
            while(!stack.isEmpty() && height[stack.peek()] >= cur){
                int h = height[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * len);
            }
        }
        return max;
    }
}