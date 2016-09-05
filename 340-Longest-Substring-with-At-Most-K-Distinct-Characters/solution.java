public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k <= 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int j = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && (map.size() == k && map.containsKey(s.charAt(j)) || map.size() < k)){
                if(map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), 1 + map.get(s.charAt(j)));
                }else{
                    map.put(s.charAt(j), 1);
                }
                j++;
            }
            max = Math.max(max, j - i);
            if(map.get(s.charAt(i)) == 1){
                map.remove(s.charAt(i));
            }else{
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
        }
        return max;
    }
}