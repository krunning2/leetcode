public class Solution {
    if(matrix == null || k <= 0){
            return 0;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            public int compare(Cell c1, Cell c2){
                return c1.val - c2.val;
            }
        });
        for(int i = 0; i < Math.min(k, matrix[0].length); i++){
            queue.offer(new Cell(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k - 1; i++){
            Cell c = queue.poll();
            if(c.row + 1 < matrix.length){
                queue.offer(new Cell(c.row + 1, c.col, matrix[c.row + 1][c.col]));
            }
        }
        return queue.peek().val;
    }
    class Cell{
        int row;
        int col;
        int val;
        Cell(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}