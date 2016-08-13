public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b)-> (a.val - b.val));
        for(int i = 0; i < Math.min(k, matrix[0].length); i++){
            queue.offer(new Cell(0, i, matrix[0][i]));
        }
        for(int i = 0; i < k - 1; k++){
            Cell cur = queue.poll();
            if(cur.row < matrix.length - 1){
                queue.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
            }
        }
        return queue.peek();
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