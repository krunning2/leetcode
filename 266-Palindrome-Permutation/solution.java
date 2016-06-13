public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), 1 + map.get(s.charAt(i)));
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        boolean flag = false;
        for(int i : map.values()){
            if(i % 2 != 0 && !flag){
                flag = true;
            }else if(i % 2 != 0 && flag){
                return false;
            }
        }
        return true;
    }
}