public class Solution {
    int sum = 0;
    public int totalNQueens(int n) {
        search(0, n, new int[n]);
        return sum;
    }
    
    private void search(int row, int n, int[] queen){
        if(row == n){
            sum ++;
            reutrn;
        }
        for(int i = 0; i < n; i++){
            if(isValid(row, i, queen)){
                queen[row] = i;
                search(row + 1, n, queen);
            }
        }
    }
    
    private boolean isValid(int row, int col, int[] queen){
        for(int i = 0; i < row; i++){
            int preC = queen[i];
            if(preC == col || Math.abs(preC - col) == Math.abs(i - row)) return false;
        }
        return true;
    }
}