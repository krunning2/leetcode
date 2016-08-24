public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        int sign = 1;
        
        if(num1.charAt(0) == '-'){
            sign *= -1;
            num1 = num1.substring(1);
        }
        if(num2.charAt(0) == '-'){
            sign *= -1;
            num2 = num2.substring(1);
        }
        int [] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int p1 = i + j;
                int p2 = i + j + 1;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r : res){
            if(r == 0 && sb.length() == 0) continue;
            sb.append(r);
        }
        if(sign == -1) sb.insert(0, "-");
        return sb.length() == 0 ? "0" : sb.toString();
    }
}