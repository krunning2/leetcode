public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(size == 0 || triangle == null) return 0;
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < size; i++){
            List<Integer> cur = triangle.get(i);
            for(int j = cur.size() - 1; j >= 0; j--){
                if(j == 0 || j == cur.size() - 1){
                    dp[j] = dp[j - 1] + cur.get(j);
                }else{
                    dp[j] = Math.min(dp[j], dp[j - 1]) + cur.get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++){
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}