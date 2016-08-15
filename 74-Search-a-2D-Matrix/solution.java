public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0][0] < target) return false;
        int start = 0;
        int end = matrix.length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(matrix[mid][0] == target){
                return mid;
            } else if(matrix[mid][0] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        int row = matrix[end][0] <= target ? end : start;
        start = 0;
        end = matrix[0].length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(matrix[row][mid] == target){
                return mid;
            } else if(matrix[row][mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        return matrix[row][start] == target || matrix[row][end] == target;
    }
}