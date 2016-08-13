public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2) return 0;
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            int min = Math.min(height[start], height[end]);
            int len = end - start;
            max = Math.max(max, len * min);
            if(height[start] > height[end]){
                end --;
            }else{
                start ++;
            }
        }
        return max;
    }
}