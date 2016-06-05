public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i = Math.max(nums2.length - k, 0); i <= k && i <= nums1.length; i++){
            int[] tmp1 = getMaxSub(nums1, i);
            int[] tmp2 = getMaxSub(nums2, k - i);
            int[] tmp3 = new int[k];
            int pos1 = 0, pos2 = 0, pos3 = 0;
            while(pos1 < tmp1.length || post2 < tmp2.length){
                if(compare(nums1, pos1, nums2, pos2) > 0){
                    tmp3[pos3 ++] = tmp1[pos1 ++];
                }else{
                    tmp3[pos3 ++] = tmp2[pos2 ++];
                }
            }
            if(compare(tmp3, 0, res, 0) < 0){
                res = tmp3;
            }
        }
        return res;
    }
    // In case of 04 0 >> 004, should be 040
    private int compare(int[] nums1, int s1, int[] nums2, int s2){
        while(s1 < nums1.length && s2 < nums2.length && nums1[s1] == nums[s2]){
            s1++;
            s2++;
        }
        if(s1 == nums1.length) return -1;
        if(s2 == nums2.length) return 1;
        return nums1[s1].comparesTo(nums2[s2]);
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