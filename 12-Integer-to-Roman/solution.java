public class Solution {
    public String intToRoman(int num) {
        String[] set = {"I", "V", "X", "L", "C", "D", "M"};
        int pos = 0;
        int scale = 1000;
        StringBuilder sb = new StringBuilder();
        for(int i = 6; i >= 0; i = i-2){
            int cur = num / scale;
            if(cur > 0){
                if(cur >= 1 && cur <= 3){
                    for(int j = 0; j < cur; j++) sb.append(set[i]);
                }else if(cur == 4){
                    sb.append(set[i]);
                    sb.append(set[i + 1]);
                }else if(cur == 5){
                    sb.append(set[i + 1]);
                }else if(cur > 5 && cur <=8){
                    sb.append(set[i + 1]);
                    for(int j = 6; j <= cur; j++){
                        sb.append(set[i]);
                    }
                }else if(cur == 9){
                    sb.append(set[i]);
                    sb.append(set[i + 2]);
                }
            }
            num %= scale;
            scale /= 10;
        }
        return sb.toString();
    }
}