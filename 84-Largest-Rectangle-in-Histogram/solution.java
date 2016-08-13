public class Solution {
    // Try to find the left first element and right element which are less than current element, so we can get the max area.
    // So we can maintain a increasing stack
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int cur = i == heights.length ? -1 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] >= cur){
                int index = stack.pop();
                int h = heights[index];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * len);
            }
            stack.push(i);
        }
        return max;
    }
}