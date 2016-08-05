public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 1;
        }
        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;
        int[][] dp = new int[m + 1][n + 1];
        dungeon[m][n] = Math.max(1, 1 - dungeon[m][n]);
        for(int i = m - 1; i >= 0; i--){
            dungeon[i][n] = Math.max(1, dungeon[i + 1][n] - dungeon[i][n]); 
        }
        for(int i = n - 1; i >= 0; i--){
            dungeon[m][i] = Math.max(1, dungeon[m][i + 1] - dungeon[m][i]);
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dungeon[0][0];
    }
}