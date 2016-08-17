public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int mod = n % 26;
            sb.append(Character.valueOf('A' + mod - 1));
            n /= 26;
        }
        return sb.toString();
    }
}