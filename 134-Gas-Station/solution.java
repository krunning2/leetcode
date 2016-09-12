public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int res = 0;
        int sum = 0;
        for(int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(total < 0){
                res = i + 1;
                total = 0;
            }
        }
        if(sum < 0) return -1;
        return res;
    }
}