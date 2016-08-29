public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> tmp = new ArrayList<>();
        while(p1 < nums1.length && p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                tmp.add(nums1[p1]);
                p2++;
                p1++;
            }else if(nums1[p1] > nums2[p2]){
                p2++;
            }else{
                p1++;
            }
        }
        int[] result = new int[tmp.size()];
        int i = 0;
        for(int n : tmp){
            result[i++] = n;
        }
        return result;
    }
}