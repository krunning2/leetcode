public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(Character.valueOf((n - 1) % 26 + 'A'));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}