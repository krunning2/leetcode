public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int i = nums.length - 1; i >= 0; i--){
            int index = find(nums[i], list);
            res.add(index);
            list.add(index, nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
    private int find(int target, List<Integer> list){
        if(list.size() == 0) return 0;
        int start = 0;
        int end = list.size() - 1;
        if(list.get(end) < target) return end + 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(list.get(mid) >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(list.get(start) >= target){
            return start;
        }else{
            return end;
        }
    }
}