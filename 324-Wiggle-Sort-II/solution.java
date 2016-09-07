public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = (len - 1) / 2;
        int end = len - 1;
        int[] tmp = new int[len];
        for(int i = 0; i < len; i++){
            if(i % 2 == 0){
                tmp[i] = nums[mid--];
            }else{
                tmp[i] = nums[end --];
            }
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
    }
}