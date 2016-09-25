public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0){
            return 0;
        }
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        for(int i = 1; i < costs.length; i++){
            int curRed = Math.min(blue, green) + costs[i][0];
            int curBlue = Math.min(red, green) + costs[i][1];
            int curGreen = Math.min(blue, red) + costs[i][2];
            red = curRed;
            blue = curBlue;
            green = curGreen;
        }
        return Math.min(Math.min(red, green), blue);
    }
}