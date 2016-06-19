public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int t = n - 1;
        int mid = n / 2 - 1;
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                tmp[i] = nums[mid--];
            }else{
                tmp[i] = nums[t--];
            }
        }
        for(int i = 0; i < n; i++){
            nums[i] = tmp[i];
        }
    }
}