public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> T = new ArrayList<Integer>(Collections.nCopies(nums.length, Integer.MAX_VALUE));
        for(int i = nums.length - 1; i >= 0; i--){
            int l = 0, r = nums.length - 1;
            while(l + 1 < r){
                int mid = l - (l - r) / 2;
                if(nums[i] <= T.get(mid)){
                    r = mid;
                }else{
                    l = mid;
                }
            }
            if(nums[i] >= T.get(l)){
                res.add(l);
                T.add(l, nums[i]);
            }else{
                res.add(r);
                T.add(r, nums[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}