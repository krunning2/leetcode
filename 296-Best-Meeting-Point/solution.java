public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < row.size(); i++){
            sum += Math.abs(row.get(i) - row.get(row.size() / 2));
        }
        Collections.sort(col);
        for(int i = 0; i < col.size(); i++){
            sum += Math.abs(col.get(i) - col.get(col.size() / 2));
        }
        return sum;
    }
}