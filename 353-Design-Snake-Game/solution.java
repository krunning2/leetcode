public class SnakeGame {
    int width, int height, int[][] food;
    LinkedList<Pair> snake;
    int len;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<Pair>();
        this.width = width;
        this.height = height;
        this.food = food;
        this.len = 0;
        snake.add(new Pair(0,0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pair head = snake.getFirst();
        Pair cur = new Pair(head.x, head.y);
        switch(direction){
            case "U" : cur.x--; break;
            case "D" : cur.x++; break;
            case "L" : cur.y--; break;
            case "R" : cur.y++; break;
        }
        if(cur.x < 0 || cur.x >= height || cur.y < 0 || cur.y >= width) return -1;
        for(int i = 1; i < snake.size() - 1; i++){
            if(cur.x == snake.get(i).x && cur.y == snake.get(i).y){
                return -1;
            }
        }
        snake.addFirst(cur);
        if(len < food.length){
            if(food[len][0] == cur.x && food[len][1] == cur.y){
                len++;
            } else {
              snake.removeLast();  
            }
        }
        return len;
    }
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */