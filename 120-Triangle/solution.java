public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++){
            for(int j = triangle.get(i).size() - 1; j >= 0 ; j--){
                if(j == 0){
                    dp[j] = triangle.get(i).get(j) + dp[j];
                }else if(j == triangle.get(i).size() - 1){
                    dp[j] = triangle.get(i).get(j) + dp[j - 1];
                }else{
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j - 1], dp[j]);
                }
            }
        }
        int min = dp[0];
        for(int i = 1; i < dp.length; i++){
            min = Math.min(min, dp[i]);
        }
        return min;
    }
}