public class Solution {
    public int maxArea(int[] heights) {
        if(height == null || height.length < 2) return 0;
        int max = 0;
        int start = 0;
        int end = heights.length - 1;
        while(start < end){
            max = Math.max(max, Math.min(heights[end], heights[start]) * (end - start));
            if(heights[start] <= heights[end]){
                start++;
            }else{
                end --;
            }
        }
        return max;
    }
}