public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        DFS(0, n, res, new int[n]);
        return res;
    }
    
    private void DFS(int curRow, int n, List<List<String>> res, int[] queenCol){
        if(curRow == n){
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
                    if(queenCol[i] == j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                tmp.add(sb.toString());
            }
            res.add(tmp);
            return;
        }
        for(int j = 0; j < n; j++){
            if(isValid(queenCol, curRow, j)){
                queenCol[curRow] = j;
                DFS(curRow + 1, n, res, queenCol);
            }
        }
    }
    
    private boolean isValid(int[] queenCol, int row, int col){
        for(int preRow = 0; preRow < row; preRow++){
            int preCol = queenCol[preRow];
            if(col == preCol || Math.abs(preRow - row) == Math.abs(preCol - col)){
                return false;
            }
        }
        return true;
    }
}