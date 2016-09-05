public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];
        while(true){
            fast = nums[nums[fast]];
            slow = nums[slow];
            if(slow == fast) break;
        }
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}