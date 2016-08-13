public class Solution {
    public int maxArea(int[] heights) {
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