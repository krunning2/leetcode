public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int[] preColCost = {costs[0][0], costs[0][1], costs[0][2]};
        
        for(int i = 1; i < costs.length; i++){
            int red = Math.min(preColCost[1], preColCost[2]) + costs[i][0];
            int blue = Math.min(preColCost[0], preColCost[2]) + costs[i][1];
            int green = Math.min(preColCost[1], preColCost[0]) + costs[i][2];
            preColCost[0] = red;
            preColCost[1] = blue;
            preColCost[2] = green;
        }
        return Math.min(preColCost[0], Math.min(preColCost[1], preColCost[2]));
    }
}