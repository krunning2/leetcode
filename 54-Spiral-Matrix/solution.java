public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int start = 0;
        List<Integer> res = new ArrayList<Integer>();
        while(2 * start < matrix.length && 2 * start < matrix[0].length){
            helper(matrix, start, res);
            start++;
        }
        return res;
    }
    private void helper(int[][] matrix, int start, List<Integer> res){
        int endRow = matrix.length - start - 1;
        int endCol = matrix[0].length - start - 1;
        for(int i = start; i <= endCol; i++){
            res.add(matrix[start][i]);
        }
        for(int i = start + 1; i <= endRow; i++){
            res.add(matrix[i][endCol]);
        }
        if(endRow > start)
            for(int i = endCol - 1; i >= start; i --){
                res.add(matrix[endRow][i]);
            }
        if(endCol > start)
            for(int i = endRow - 1; i > start; i--){
                res.add(matrix[i][start]);
            }
            
    }
}