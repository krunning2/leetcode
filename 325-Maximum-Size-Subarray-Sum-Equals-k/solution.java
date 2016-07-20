public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        map.put(0, -1);
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            if(map.containsKey(sum - k)){
                res = Math.max(res, i - map.get(sum - k));
            }
        }
        return res;
    }
}