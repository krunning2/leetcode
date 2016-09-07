public class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int[] p : points){
            max = Math.max(max, p[0]);
            min = Math.min(min, p[0]);
            set.add(Arrays.hashCode(p));
        }
        int sum = max + min;
        for(int[] p : points){
            int[] target = {sum - p[0], p[1]};
            if(!set.contains(Arrays.hashCode(target))){
                return false;
            }
        }
        return true;
    }
}