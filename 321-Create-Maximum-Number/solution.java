public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
            int[] res1 = getMaxSub(nums1, i);
            int[] res2 = getMaxSub(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;

            while (pos1 < res1.length || pos2 < res2.length) {
                res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
            }

            if (!greater(ans, 0, res, 0))
                ans = res;
        }
        return res;
    }
    // In case of 04 0 >> 004, should be 040
    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }
    
    private int[] getMaxSub(int[] num, int k){
        int[] res = new int[k];
        int p = 0;
        for(int i = 0; i < num.length; i ++){
            //res[p - 1] means the last elements, p will be the next element
            while(p > 0 && p + num.length - i > k && res[p - 1] < num[i]){
                p --;
            }
            if(p < k){
                res[p++] = num[i];
            }
        }
        return res;
    }
}