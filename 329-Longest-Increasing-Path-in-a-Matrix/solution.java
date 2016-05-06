public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length ==0) return 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int max = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int tmp = DFShelper(matrix, j, i, mem, visited);
                max = Math.max(max, tmp);
            }
        }
        return max;
        
    }
    private int DFShelper(int[][] matrix, int x, int y, int[][] mem, boolean[][] visited){
        if(mem[y][x] > 0) return mem[y][x];
        int max = 1;
        if(isValid(matrix, x, y, cur, visited)){
            int[]dx = {1, -1, 0, 0};
            int[]dy = {0, 0 , 1, -1};
            for(int i = 0; i < 4; i++){
                visited[y][x] = true;
                int cur = DFShelper(matrix, x + dx[i], y + dy[i], mem, visited, matrix[y][x]) + 1;
                max = Math.max(cur, max);
                visited[y][x] = false;
            }
        }
        mem[y][x] = max;
        return max;
    }
    private boolean isValid(int[][]matrix, int x, int y, int cur, boolean[][] visited){
        if(x >= 0 && x < matrix[0].length && y >= 0 && y < matrix.length && matrix[y][x] > cur && !visited[y][x]){
            return true;
        }
        return false;
    }
}