public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        search(0, new int[n], n, res);
        return res;
    }
    
    private void search(int row, int[] queen, int n, List<List<String>> res){
        if(row == n) {
            res.add(build(queen));
            return;
        }
        for(int i = 0; i < n; i++){
            if(isValid(row, i, queen)){
                queen[row] = i;
                search(row + 1, queen, n, res);
                queen[row] = 0;
            }
        }
    }
    
    private List<String> build(int[] queen){
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < queen.length; i++){
            for(int j = 0; j < queen.length; j++){
                if(queen[i] == j){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            res.add(sb.toString());
            sb.setLength(0);
        }
        return res;
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