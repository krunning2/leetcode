public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        String[] nums_s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            nums_s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums_s,(a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        if(nums_s[0].equals("0")) return "0";
        for(String s : nums_s){
            sb.append(s);
        }
        return sb.toString();
    }
}