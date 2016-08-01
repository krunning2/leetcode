public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int p = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            while(p < s.length()){
                if(set.contains(s.charAt(p))){
                    break;
                }else{
                    set.add(s.charAt(j));
                    p++;
                }
            }
            max = Math.max(max, p - i);
            set.remove(s.charAt(i));
        }
        return max;
    }
}