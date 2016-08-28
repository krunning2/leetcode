public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        helper(word, 0, 0, res, new StringBuilder());
        return res;
    }
    private void helper(String word, int pos, int count, List<String> res, StringBuilder sb){
        if(pos == word.length()){
            if(count == 0){
                res.add(sb.toString());
            }else{
                res.add(sb.append(count).toString());
            }
            return;
        }
        int len = sb.length();
        // continue to count
        helper(word, pos + 1, count + 1, res, sb);
        // because res.append(count);
        sb.setLength(len);
        // stop counting, but appending the number and chars
        if(count != 0){
            sb.append(count);
        }
        sb.append(word.charAt(pos));
        helper(word, pos + 1, 0, res, sb);
        sb.setLength(len);
    }
}