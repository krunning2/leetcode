public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketMin = new int[nums.length - 1];
        int[] bucketMax = new int[nums.length - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        for(int n : nums){
            if (n == min || n == max) continue;
            int index = (n - min) / gap;
            bucketMin[index] = Math.min(bucketMin[index], n);
            bucketMax[index] = Math.max(bucketMax[index], n);
        }
        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for(int i = 0; i < bucketMin.length; i++){
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) continue;
            // min value minus the previous value is the current gap
            maxGap = Math.max(maxGap, bucketMin[i] - previous);
            // update previous bucket value
            previous = bucketMax[i];
        }
        maxGap = Math.max(maxGap, max - previous); // updata the final max value gap
        return maxGap;
    }
}