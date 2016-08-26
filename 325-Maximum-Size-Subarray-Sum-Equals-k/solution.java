public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0 , -1);
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            //because we want max, so if we see the same sum again, we should update the index
            map.putIfAbsent(sum, i);
        }
        return max;
    }
}