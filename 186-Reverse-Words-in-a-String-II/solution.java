public class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int p1 = 0, p2 = 0;
        while(p2 <= s.length){
            if(p2 == s.length || s[p2] == ' '){
                reverse(s, p1, p2 - 1);
                p2++;
                p1 = p2;
            }else{
                p2++;
            }
        }
    }
    private void reverse(char[] s, int l, int r){
        while(l < r){
            char c = s[l];
            s[l] = s[r];
            s[r] = c;
            l++;
            r--;
        }
    }
}