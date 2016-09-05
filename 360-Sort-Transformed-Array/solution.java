public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return nums;
        int start = 0;
        int end = nums.length - 1;
        int [] res = new int[nums.length];
        int p = a >= 0 ? nums.length - 1 : 0;
        while(start <= end){
            int left = cal(a, b, c, nums[start]);
            int right = cal(a, b, c, nums[end]);
            if(a >= 0){
                if(left > right){
                    res[p--] = left;
                    start++;
                }else{
                    res[p--] = right;
                    end--;
                }
            }else{
                if(left > right){
                    res[p++] = right;
                    end --;
                }else{
                    res[p++] = left;
                    start++;
                }
            }
        }
        return res;
    }
    private int cal(int a, int b, int c, int x){
        return a * x * x + b * x + c;
    }
}