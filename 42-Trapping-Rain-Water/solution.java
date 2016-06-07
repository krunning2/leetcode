public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int start = 0, end = height.length - 1;
        int rightMax = 0, leftMax = 0;
        int res = 0;
        while(start < end){
            rightMax = Math.max(rightMax, height[end]);
            leftMax = Math.max(leftMax, height[start]);
            int min = Math.min(rightMax, leftMax);
            if(height[start] > height[end]){
                if(height[end] < min){
                    res += min - height[end];
                }
                end--;
            } else {
                if(height[start] < min){
                    res += min - height[start];
                }
                start++;
            }
        }
        return res;
    }
}