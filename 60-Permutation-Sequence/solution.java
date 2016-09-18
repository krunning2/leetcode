public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fac = 1;
        for(int i = 1; i <= n; i++){
            nums.add(i);
            fac *= i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n; i>=1; i--){
            fac /= i;
            int index = k / fac;
            sb.append(nums.get(index));
            nums.remove(index);
            k = k % fac;
        }
        return sb.toString();
    }
}