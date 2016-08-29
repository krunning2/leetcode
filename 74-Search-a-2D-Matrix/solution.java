public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            int row = mid / n;
            int col = mid % n;
            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        return matrix[start / n][start % n] == target || matrix[end / n][end % n] == target;
    }
}