public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int p1 = 0, p2 = 0;
        List<int[]> res = new ArrayList<int[]>();
        while(p1 < nums1.length && p2 < nums2.length && k > 0){
            if(nums1[p1] < nums[p2]){
                res.add(new int[]{nums1[p1], nums2[p2]});
                p2 ++;
            }else if(nums1[p1] > nums[p2]){
                res.add(new int[]{nums2[p2], nums1[p1]});
                p1 ++;
            }else{
                res.add(new int[]{nums2[p2], nums1[p1]});
                if(p1 < nums1.length - 1 && p2 < nums2.length - 1){
                    if(nums1[p1 + 1] < nums2[p2 + 1]){
                        p1 ++;
                    }else{
                        p2++;
                    }
                }else if(p1 == nums1.length - 1){
                    p2++;
                }else{
                    p1++;
                }
            }
            k--;
        }
        return res;
    }
}