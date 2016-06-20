public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int start = 0;
        int count = 0;
        while(start * 2< n){
            count = helper(n, matrix, count, start);
            start ++;
        }
        return res;
    }
    private int helper(int n, int[][] matrix, int count, int start){
        int end = n - start - 1;
        for(int i = start; i <= end; i++){
            matrix[start][i] = count ++;
        }
        for(int i = start + 1; i <= end; i++){
            matrix[i][end] = count ++;
        }
        if(end > start){
            for(int i = end - 1; i >= start; i--){
                matrix[end][i] = count ++;
            }
            for(int i = end - 1; i > start; i--){
                matrix[i][start] = count ++;
            }
        }
        return count;
    }
}