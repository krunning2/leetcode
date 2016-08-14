public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] s_nums = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s_nums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s_nums, (a, b) -> (b+a).compareTo(a+b));
        if(nums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : s_nums){
            sb.append(s);
        }
        return sb.toString();
    }
}