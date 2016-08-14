public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows <= 0) return "";
        StringBuilder[] sbs = new StringBuilder[numRows];
        Arrays.fill(sbs, new StringBuilder());
        int incre = 1;
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            sbs[index].append(s.charAt(i));
            if(index == 0){
                incre = 1;
            }else if(index == numRows - 1){
                incre = -1;
            }
            index += incre;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < sbs.length; i++){
            sb.append(sbs[i]);
        }
        return sb.toString();
    }
}