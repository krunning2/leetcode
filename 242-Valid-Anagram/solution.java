public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for(int i = 0; i < s.length(); i++){
            map[s.chatAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            map[t.charAt(i) - 'a'] --;
            if(map[t.charAt(i) - 'a'] < 0) return false;
        }
        for(int i = 0; i < 26; i++){
            if(map[i] != 0) return false;
        }
        return true;
    }
}