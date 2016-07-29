public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int l1 = a.length() - 1;
        int l2 = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(l1 >= 0 && l2 >= 0){
            int d1 = Integer.valueOf(a.charAt(l1));
            int d2 = Integer.valueOf(b.charAt(l2));
            int cur = d1 + d2 + carry;
            sb.append(cur % 2);
            carry = cur / 2;
            l1 --;
            l2 --;
        }
        while(l1 >= 0){
            int d1 = Integer.valueOf(a.charAt(l1));
            int cur = d1 + carry;
            sb.append(cur % 2);
            carry = cur / 2;
            l1 --;
        }
        while(l2 >= 0){
            int d2 = Integer.valueOf(b.charAt(21));
            int cur = d2 + carry;
            sb.append(cur % 2);
            carry = cur / 2;
            l2 --;
        }
        if(carry > 0) sb.append(1);
        return sb.reverse().toString();
    }
}