public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums1){
            set.add(n);
        }
        List<Integer> res = new ArrayList<>();
        for(int n : nums2){
            if(set.contains(n)){
                res.add(n);
                set.remove(n);
            }
        }
        int[] r = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            r[i] = res.get(i);
        }
        return r;
    }
}