public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int p1 = 0, p2 = 0;
        StringBuilder sb = new StringBuilder();
        while(p1 < a.length() && p2 < b.length()){
            int x1 = a.charAt(p1) - '0';
            int x2 = b.charAt(p2) - '0';
            sb.insert(0, (carry + x1 + x2) % 2);
            carry = (carry + x1 + x2) / 2;
        }
        while(p1 < a.length()){
            int x1 = a.charAt(p1) - '0';
            sb.insert(0, (carry + x1) % 2);
            carry = (carry + x1) / 2;
        }
        while(p2 < b.length()){
            int x2 = b.charAt(p2) - '0';
            sb.insert(0, (carry + x2) % 2);
            carry = (carry + x2) / 2;
        }
        if(carry > 0) sb.insert(0, 1);
        return sb.toString();
    }
}