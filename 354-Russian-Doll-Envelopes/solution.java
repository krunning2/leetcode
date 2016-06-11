public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length <= 0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparacter<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        int [] dp = new int[envelopes.length];
        int max = 1;
        for(int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(envelopes[i] > envelopes[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}