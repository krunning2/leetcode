public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int n : nums){
            map.put(n, false);
        }
        int max = 1;
        for(int i = 0; i < nums.length; i ++){
            if(map.get(nums[i])) continue;
            int cur = nums[i];
            int count = 1;
            while(map.containsKey(cur + 1) && !map.get(cur + 1)){
                map.put(cur + 1, true);
                cur ++;
                count++;
            }
            cur = nums[i];
            while(map.containsKey(cur - 1) && !map.get(cur - 1)){
                map.put(cur - 1, true);
                cur--;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}