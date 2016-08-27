public class NumArray {
    HashMap<Integer, Integer> map;
    public NumArray(int[] nums) {
        map = new HashMap<>();
        int sum = 0;
        map.put(-1, 0);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            map.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        return map.get(j) - map.get(i - 1);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);