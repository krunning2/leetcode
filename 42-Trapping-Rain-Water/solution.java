public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(start < end){
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);
            int min = Math.min(leftMax, rightMax);
            if(height[start] < min){
                res += min - height[start];
            }
            if(height[end] < min){
                res += min - height[end];
            }
            if(height[end] > height[start]){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}