public class Solution {
    public void reverseWords(char[] s) {
        if(s == null) return;
        reverse(s, 0, s.length - 1);
        int p1 = 0, p2 = 0;
        while(p2 < s.length){
            if(s[p2] == ' '){
                reverse(c, p1, p2 - 1);
                p2++;
                p1 = p2;
            }else{
                p2++;
            }
        }
    }
    private void reverse(char[] c, int s, int e){
        while(s <= e){
            char tmp = c[s];
            c[s] = c[e];
            c[e] = tmp;
        }
    }
}