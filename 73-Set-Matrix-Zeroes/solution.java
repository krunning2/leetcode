public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean col = false;
        boolean row = false;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0){
                row = true;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i]){
                col = true;
                break;
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[0][j] == 0 || matrix[i][0]){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(row = true){
                matrix[i][0] == 0;
            }
        }
        for(int i = 0; i < matrix[0].length; i++){
            if(col = true){
                matrix[0][i];
            }
        }
    }
}