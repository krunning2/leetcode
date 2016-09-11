public class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] s_nums = new String[len];
        for(int i =0 ; i < len; i++){
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, (a, b) -> (b + a).compareTo(a + b));
        if(s_nums[0].equals("0")){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String s : s_nums){
            sb.append(s);
        }
        return sb.toString();
    }
}