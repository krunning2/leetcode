public class NumArray {
    int[] BIT;
    int[] nums;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        BIT = new int[n + 1];
        for(int i = 0; i < n; i++){
            updateBIT(i, nums[i]);
        }
        this.nums = nums;
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateBIT(i, diff);
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    private int getSum(int i){
        i++;
        int sum = 0;
        while(i > 0){
            sum += BIT[i];
            i = i - lowbit(i);
        }
        return sum;
    }
    
    private void updateBIT(int i, int val){
        i++;
        while(i <= n){
            BIT[i] += val;
            i = lowbit(i) + i;
        }
    }
    private int lowbit(int i){
        return i & -i;
    }
    
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);