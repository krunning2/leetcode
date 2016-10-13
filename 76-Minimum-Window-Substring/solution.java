public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() == 0 || t.length() == 0){
            return "";
        }
        Map<Character, Integer> target = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            if(target.containsKey(t.charAt(i))){
                target.put(t.charAt(i), target.get(t.charAt(i)) + 1);
            }else{
                target.put(t.charAt(i), 1);
            }
        }
        
        int j = 0;
        int count = t.length();
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && count > 0){
                char cur = s.charAt(j);
                if(target.containsKey(cur) && target.get(cur) > 0){
                    count--;
                    target.put(cur, target.get(cur) - 1);
                }else if(target.containsKey(cur)){
                    target.put(cur, target.get(cur) - 1);
                }
                j++;
            }
            if(min > j - i && count == 0){
                min = j - i;
                res = s.substring(i, j);
            }
            if(target.containsKey(s.charAt(i))){
                if(target.get(s.charAt(i)) >= 0){
                    count++;
                }
                target.put(s.charAt(i), target.get(s.charAt(i)) + 1);
            }
        }
        return res;
    }
}