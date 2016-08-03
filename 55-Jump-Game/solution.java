public class Solution {
    public boolean canJump(int[] nums) {
        int cur = 0;
        int next = 0;
        for(int i = 0; i < A.length; i++){
            if(cur < i){
                cur = next;
                if(cur < i) return false;
            }
            next = Math.max(next, A[i] + i);
        }
        return true;
    }
}