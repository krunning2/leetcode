public class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0, iteration = 0, len = A.length;
        for(int i = 0; i < len; i++){
            sum += A[i];
            iteration += i * A[i];
        }
        int max = iteration;
        for(int j = 1; j < len; j++){
            iteration = iteration - sum + len * A[j - 1];
            max = Math.max(max, iteration);
        }
        return max;
    }
}