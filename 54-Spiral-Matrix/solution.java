public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int count = 0;
        while(2 * count < matrix.length && 2*count < matrix[0].length){
            helper(matrix, res, count);
            count++;
        }
        return res;
    }
    
    private void helper(int[][] matrix, List<Integer>res, int start){
        // Because start increase by 1, end will also decrease by 1;
        int endRow = matrix.length - start - 1;
        int endCol = matrix[0].length - start - 1;
        //upper row
        for(int i = start; i <= endCol; i++){
            res.add(matrix[start][i]);
        }
        //left col
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