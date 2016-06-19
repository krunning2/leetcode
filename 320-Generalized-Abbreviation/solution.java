public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        if(word == null){
            return res;
        }
        helper(word, 0, 0, new StringBuilder(), res);
        return res;
    }
    private void helper(String word, int pos, int count, StringBuilder sb, List<String> res){
        int len = sb.length();
        if(pos == word.length()){
            if(count == 0){
                res.add(sb.toString());
            }else{
                res.add(sb.append(count).toString());
            }
        }else{
            helper(word, pos + 1, count + 1, sb, res);
            if(count != 0) {
                sb.append(count);
            }
            sb.append(word.charAt(pos));
            helper(word, pos + 1, 0, sb, res);
        }
        sb.setLength(len);
    }
}