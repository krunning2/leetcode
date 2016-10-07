public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 >= 0 && p2 >= 0){
            carry += a.charAt(p1) - '0' + b.charAt(p2) - '0';
            sb.append(carry % 2);
            carry /= 2;
            p1--;
            p2--;
        }
        while(p1 >= 0){
            carry += a.charAt(p1) - '0';
            sb.append(carry % 2);
            carry /= 2;
            p1--;
        }
        while(p2 >= 0){
            carry += b.charAt(p2) - '0';
            sb.append(carry % 2);
            carry /= 2;
            p2--;
        }
        if(carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}