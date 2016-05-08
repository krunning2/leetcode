public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return s;
        int len = s.length(), tail = len;
        StringBuilder builder = new StringBuilder();
        while (1 < tail) {
            if (isPalindrome(s.substring(0, tail))) {
                builder = builder.append(s.substring(tail, len)).reverse();
                break;
            }
            tail--;
        }
        if (builder.length() == 0) {
            builder = builder.append(s.substring(tail, len)).reverse();
        }
        return builder.append(s).toString();
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}