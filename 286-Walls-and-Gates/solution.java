public class Solution {
    private static final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Cell(i, j));
                }
            }
        }
        int dist = 0;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        while(!queue.isEmpty()){
            int size = queue.size();
            dist ++;
            for(int i = 0 ; i < size; i++){
                Cell c = queue.poll();
                for(int k = 0 ; k < 4; k++){
                    int x = dx[k] + c.x;
                    int y = dy[k] + c.y;
                    if(validate(x, y, rooms)){
                        queue.offer(new Cell(x, y));
                        rooms[x][y] = dist;
                    }
                }
            }
        }
    }
    
    private boolean validate(int x, int y, int[][]rooms){
        if(x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] != INF){
            return false;
        }
        return true;
    }
    
    class Cell{
        int x;
        int y;
        Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}