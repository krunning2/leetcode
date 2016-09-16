public class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] s_c = s.toCharArray();
        for(char c : s_c){
            map[c - 'a'] ++;
        }
        for(int i = 0; i < s_c.length; i++){
            if(map[s_c[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}