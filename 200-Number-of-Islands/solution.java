public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    DFS(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    private void DFS(char[][] grid, boolean[][] visited, int row, int col){
        if(row < 0 || col < 0 || row > grid.length || col > grid[0].length || visited[row][col] ||grid[row][col] == '0'){
            return;
        }
        visited[row][col] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++){
            DFS(grid, visited, row + dx[i], col + dy[i]);
        }
    }
}