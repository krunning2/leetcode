public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        if(numRows <= 1 || s == null || s.length() <= 1) return s;
        //don't use fill, because it will fill same object
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }
        int incre = 1;
        int index = 0;
        for(int i = 0; i < s.length(); i++){
            sbs[index].append(s.charAt(i));
            if(index == 0){
                incre = 1;
            }
            if(index == numRows - 1){
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