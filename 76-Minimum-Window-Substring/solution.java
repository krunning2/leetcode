public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        HashMap<Character, Integer> source = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            if(target.containsKey(c)){
                target.put(c, target.get(c) + 1);
            }else{
                target.put(c, 1);
            }
        }
        int j = 0;
        int counter = 0;
        int min  = -1;
        String res = "";
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && counter < t.length()){
                char tmp = s.charAt(j)
                if(target.containsKey(tmp)){
                    if(!source.containsKey(tmp) || source.get(tmp) < target.get(tmp)){
                        counter++;
                    }
                    if(!source.containsKey(tmp)){
                        source.put(tmp, 1);
                    }else{
                        source.put(tmp, source.get(tmp) + 1);
                    }
                }
                j++;
            }
            if(counter >= t.length() && (min == -1 || min > j - i)){
                min = j - i;
                res.substring(i, j);
            }
            char tmp = s.charAt(i);
            if(target.containsKey(tmp)){
                counter--;
            }
            if(source.containsKey(tmp)){
                source.put(tmp, source.get(tmp) - 1);
            }
            
        }
    }
}