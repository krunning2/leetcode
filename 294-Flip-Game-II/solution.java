public class Solution {
    public boolean canWin(String s) {
        return canWin(s, new HashMap<String, Boolean>());
    }
    private boolean canWin(String s, Map<String, Boolean> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        for(int i = 0; i < s.length() - 1; i ++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String opp = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(opp, map)){
                    map.put(s, Boolean.TRUE);
                    return true;
                }
            }
        }
        map.put(s, Boolean.FALSE);
        return false;
    }
}