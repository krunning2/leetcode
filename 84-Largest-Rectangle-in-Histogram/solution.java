public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int cur = i == heights.length ? -1 : heights[i];
            while(!stack.isEmpty() && cur < heights[stack.peek()]){
                int h = heights[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, len * h);
            }
            stack.push(i);
        }
        return max;
    }
}