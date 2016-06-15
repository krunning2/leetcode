public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for(int n : nums){
            map.put(n, false);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i])){
                continue;
            }
            int cur = nums[i];
            int count = 1;
            while(map.containsKey(cur + 1)){
                count++;
                map.put(cur + 1, true);
                cur++;
            }
            cur = nums[i];
            while(map.containsKey(cur - 1)){
                count++;
                map.put(cur - 1, true);
                cur--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}