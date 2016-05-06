public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[] res = {0};
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                DFShelper(matrix, j, i, mem, visited, Integer.MIN_VALUE, 1, res);
                //mem = new int[matrix.length][matrix[0].length];
            }
        }
        return res[0];
        
    }
    private void DFShelper(int[][] matrix, int x, int y, int[][] mem, boolean[][] visited,int cur, int count, int[] res){
        if(isValid(matrix, x, y, cur, visited)){
            if(mem[y][x] > count){
                return;
            }
            if(count > res[0]){
                res[0] = count;
            }
            mem[y][x] = Math.max(mem[y][x], count);
            int[]dx = {1, -1, 0, 0};
            int[]dy = {0, 0 , 1, -1};
            for(int i = 0; i < 4; i++){
                visited[y][x] = true;
                DFShelper(matrix, x + dx[i], y + dy[i], mem, visited, matrix[y][x], count + 1, res);
                visited[y][x] = false;
            }
        }
        
    }
    private boolean isValid(int[][]matrix, int x, int y, int cur, boolean[][] visited){
        if(x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length && matrix[y][x] > cur && !visited[y][x]){
            return true;
        }
        return false;
    }
}