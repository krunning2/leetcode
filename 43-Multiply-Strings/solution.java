public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0){
            return "";
        }
        int sign = 1;
        if(num1.startsWith("-")){
            sign *= -1;
            num1 = num1.substring(1);
        }
        if(num2.startsWith("-")){
            sign *= -1;
            num2.substring(1);
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for(int i = len1 - 1 ; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                int p1 = i + j;
                int p2 = i + j + 1;
                res[p2] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[p1] += res[p2] / 10;
                res[p2] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len1 + len2; i++){
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        if(sign == -1) {
            sb.insert(0, "-");
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}