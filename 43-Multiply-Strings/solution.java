public class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[p2];
                res[p1] += tmp / 10;
                res[p2] = tmp % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int n : res){
            if(n == 0 && sb.length() == 0){
                continue;
            }
            sb.append(n);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}