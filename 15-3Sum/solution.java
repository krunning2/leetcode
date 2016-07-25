public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 2; i++){
            int cur = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + cur == 0){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(cur);
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    res.add(tmp);
                    start ++;
                    end --;
                    while(start < end && nums[start] == nums[start - 1]){
                        start ++;
                    }
                    while(start < end && nums[end] == nums[end + 1]){
                        end --;
                    }
                }else if(nums[start] + nums[end] + cur > 0){
                    end --;
                }else{
                    start ++;
                }
            }
            while(i < nums.length - 3 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }
}