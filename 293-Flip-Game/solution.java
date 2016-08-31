public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return res;
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == '+' && chars[i + 1] == '+'){
                chars[i] = '-';
                chars[i + 1] = '-';
                res.add(new String(chars));
                chars[i] = '+';
                chars[i + 1] = '+';
            }
        }
        return res;
    }
}