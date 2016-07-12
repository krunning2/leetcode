public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int lastR = costs[0][0];
        int lastY = costs[0][1];
        int lastG = costs[0][2];
        for(int i = 1; i < costs.length; i++){
            int curR = Math.min(lastY, lastG) + costs[i][0];
            int curY = Math.min(lastR, lastG) + costs[i][1];
            int curG = Math.min(lastR, lastY) + costs[i][2];
            lastR = curR;
            lastY = curY;
            lastG = curG;
        }
        return Math.min(Math.min(lastG, lastY), lastR);
    }
}
// Defind LsatR as the Minimum cost that paint current house as Red and including the cost of painting previous house