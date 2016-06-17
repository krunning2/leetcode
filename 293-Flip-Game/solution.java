public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() <= 1){
            return res;
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == '+' && chars[i + 1] == '+'){
                res.add(getNext(chars, i));
                chars[i] = chars[i+1] = '+';
            }
        }
        return res;
    }
    private String getNext(char[] chars, int i){
        chars[i] = '-';
        chars[i + 1] = '-';
        return new String(chars);
    }
}