public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    DFS(grid, i, j, visited);
                }
            }
        }
        return count;
    }
    private void DFS(char[][] grid, int x, int y, boolean[][] visited){
        if(x < 0 || y < 0 || y >= grid[0].length || x >= grid.length || visited[x][y] || grid[x][y] != '1'){
            return;
        }
        visited[x][y] = true;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(int i = 0; i < 4; i++){
            DFS(grid, x + dx[i], y + dy[i], visited);
        }
    }
}