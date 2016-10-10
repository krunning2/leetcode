public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix== null || matrix.length == 0) return res;
        int start = 0;
        while(start * 2 < matrix.length && start * 2 < matrix[0].length){
            get(matrix, start, res);
            start ++;
        }
        return res;
    }
    private void get(int[][] matrix, int start, List<Integer> res){
        int endRow = matrix.length - start - 1;
        int endCol = matrix[0].length - start - 1;
        for(int i = start; i <= endCol; i++){
            res.add(matrix[start][i]);
        }
        for(int i = start + 1; i <= endRow; i++){
            res.add(matrix[i][endCol]);
        }
        if(endRow > start){
            for(int i = endCol - 1; i >= start; i--){
                res.add(matrix[endRow][i]);
            }
        }
        if(endCol > start){
            for(int i = endRow - 1; i > start; i--){
                res.add(matrix[i][start]);
            }
        }
    }
}