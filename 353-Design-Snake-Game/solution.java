public class SnakeGame {
    LinkedList<Pair> snake;
    int width;
    int height;
    int[][] food;
    int len;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        snake = new LinkedList<>();
        this.width = width;
        this.height = height;
        this.food = food;
        len = 0;
        snake.addFirst(new Pair(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Pair head = snake.getFirst();
        // need to clone the pointer
        Pair newHead = new Pair(head.x, head.y);
        switch(direction){
            case "U" : newHead.x --; break;
            case "D" : newHead.x ++; break;
            case "L" : newHead.y --; break;
            case "R" : newHead.y ++; break;
        }
        if(newHead.x < 0 || newHead.x >= height || newHead.y < 0 || newHead.y >= width) return -1;
        
        // need to remove the last first, because we don't want to compare the tail to the next new head
        Pair tail = snake.removeLast();
        Iterator<Pair> iterator = snake.iterator();
        //ignore the first
        if(iterator.hasNext())
            iterator.next();
        while(iterator.hasNext()){
            Pair cur = iterator.next();
            if(cur.x == newHead.x && cur.y == newHead.y){
                return -1;
            }
        }
        snake.addFirst(newHead);
        if(len < food.length){
            if(food[len][0] == newHead.x && food[len][1] == newHead.y){
                len++;
                snake.addLast(tail);
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