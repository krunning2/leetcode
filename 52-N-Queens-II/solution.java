public class Solution {
    public int totalNQueens(int n) {
        int[] res = {0};        
        search(0, new int[n], n, res);
        return res[0];
    }
    
    private void search(int row, int[] queen, int n, int[] res){
        if(row == n) {
            res[0] ++;
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(row, i, queen)){
                queen[row] = i;
                search(row + 1, queen, n, res);
            }
        }
    }
    private boolean isValid(int row, int col, int[] queen){
        for(int preR = 0; preR < row; preR++){
            int preC = queen[preR];
            if(preC == col || Math.abs(preR - row) == Math.abs(preC - col)){
                return false;
            }
        }
        return true;
    }
}