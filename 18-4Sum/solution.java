public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                int start = j + 1;
                int end = nums.length - 1;
                int t = target - nums[i] - nums[j];
                while(start < end){
                    if(nums[start] + nums[end] == t){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[start]);
                        tmp.add(nums[end]);
                        res.add(tmp);
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start - 1]){
                            start ++;
                        }
                        while(start < end && nums[end] == nums[end + 1]){
                            end --;
                        }
                    }else if(nums[start] + nums[end] > t){
                        end--;
                    }else{
                        start++;
                    }
                }
                while(j < nums.length - 3 && nums[j] == nums[j + 1]){
                    j++;
                }
            }
            while(i < nums.length - 4 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }
}