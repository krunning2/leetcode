public class Solution {
    private static final int WALL = -1;
    private static final int INF = Integer.MAX_VALUE;
    private static final int GATE = 0;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0){
            return;
        }
        Queue<Point> queue = new LinkedList<Point>();
        for(int i = 0; i < rooms.length; i ++){
            for(int j = 0; j < rooms.length; j ++){
                if(rooms[i][j] == GATE){
                    queue.offer(new Point(i, j));
                }
            }
        }
        int level = 0;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        while(!queue.isEmpty()){
            level ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                for(int i = 0; i < 4; i++){
                    if(check(rooms, cur, dx, dy, level)){
                        rooms[dx + cur.x][dy + cur.y] = level;
                        queue.offer(new Point(dx + cur.x, dy + cur.y));
                    }
                }
            }
        }
    }
    
    private boolean check(int[][] rooms, Point p, int dx, int dy, int level){
        if(p.x + dx >= rooms.length || p.x + dx < 0 || p.y + dy >= rooms[0].length || p.y + dy < 0 
        || rooms[p.x + dx][p.y + dy] == WALL || rooms[p.x + dx][p.y + dy] <= level){
            return false;
        }
        return true;
    }
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}