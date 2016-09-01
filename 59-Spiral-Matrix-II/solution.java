public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] m = new int[n][n];
        int num = 1;
        int start = 0;
        while(start * 2 < n){
            num = fill(start, m, num);
            start++;
        }
        return m;
    }
    private int fill(int start, int[][] m, int num){
        int end = m.length - 1 - start;
        for(int i = start; i <= end; i++){
            m[start][i] = num++;
        }
        for(int i = start + 1; i <= end; i++){
            m[i][end] = num++;
        }
        if(end > start){
            for(int i = end - 1; i >= start; i--){
                m[end][i] = num++;
            }
            for(int i = end - 1; i > start; i--){
                m[i][start] = num++;
            }
        }
        return num;
    }
}