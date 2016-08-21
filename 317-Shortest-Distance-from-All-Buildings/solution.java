public class Solution {
    public int shortestDistance(int[][] grid) {
        int num = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dis = new int[m][n];
        int[][] reach = new int[m][n];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    num++;
                    int level = 0;
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i * n + j);
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    while(! q.isEmpty()){
                        int size = q.size();
                        for(int k = 0; k < size; k++){
                            int cur = q.poll();
                            int row = cur / n;
                            int col = cur % n;
                            for(int l = 0; l < 4; l++){
                                int x = row + dx[l];
                                int y = col + dy[l];
                                if(isValid(x, y, visited)){
                                    q.offer(x * n + y);
                                    dis[x][y] += level + 1;
                                    visited[x][y] = true;
                                    reach[x][y]++;
                                }
                            }
                        }
                    }
                    level++;
                }
            }
        }
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && reach[i][j] == num){
                    minDist = Math.min(minDist, dis[i][j]);
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private boolean isValid(int x, int y, boolean[][] visited, int[][] grid){
        if(x < 0 || y < 0 || y >= visited[0].length || x >= visited.length || visited[x][y] || grid[x][y] != 0) return false;
        return true;
    }
}