public class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1 && !set.contains(n)){
            while(n > 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            n = sum;
            set.add(n);
        }
        return n == 1;
    }
}