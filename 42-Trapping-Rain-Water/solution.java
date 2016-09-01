public class Solution {
    public int trap(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int res = 0;
        int rightMax = 0, leftMax = 0;
        while(start < end){
            rightMax = Math.max(rightMax, height[start]);
            leftMax = Math.max(leftMax, height[end]);
            int min = Math.min(rightMax, leftMax);
            if(height[start] > height[end]){
                if(height[end] < min){
                    res += min - height[end];
                }
                end --;
            }else{
                if(height[start] < min){
                    res += min - height[start];
                }
                start++;
            }
        }
        return res;
    }
}