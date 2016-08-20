public class Solution {
    public int candy(int[] ratings) {
        if(ratings == null) return 0;
        int[] can = new int[ratings.length];
        Arrays.fill(can, 1);
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                can[i] = can[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                can[i] = Math.max(can[i], can[i + 1] + 1);
            }
        }
        int count = 0;
        for(int x : can){
            count += x;
        }
        return count;
    }
}