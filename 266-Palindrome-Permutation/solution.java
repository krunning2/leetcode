public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            if(map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }
        boolean odd = false;
        for(int v : map.values()){
            if(v % 2 == 1 && odd) return false;
            if(v % 2 == 1) odd = true;
        }
        return true;
    }
}