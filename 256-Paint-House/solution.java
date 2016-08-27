public class Solution {
    public int minCost(int[][] costs) {
        int lastGreen = 0;
        int lastRed = 0;
        int lastBlue = 0;
        for(int i = 0; i < costs.length; i++){
            int curGreen = lastGreen;
            int curRed = lastRed;
            int curBlue = lastBlue;
            lastGreen = Math.min(curRed, curBlue) + costs[i][2];
            lastBlue = Math.min(curRed, curGreen) + costs[i][1];
            lastRed = Math.min(curGreen, curBlue) + costs[i][0]; 
        }
        return Math.min(Math.min(lastGreen, lastBlue), lastRed);
    }
}