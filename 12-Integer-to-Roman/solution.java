public class Solution {
    public String intToRoman(int num) {
        int scale = 1000;
        char[] map = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        StringBuilder sb = new StringBuilder();
        for(int i = 6; i >=0; i -= 2){
            int d = num / scale;
            if(d > 0){
                if(d <= 3){
                    for(int j = 0; j < d; j++) sb.append(map[i]);
                }else if(d == 4){
                    sb.append(map[i]);
                    sb.append(map[i + 1]);
                }else if(d == 5){
                    sb.append(map[i + 1]);
                }else if(d > 5 && d <= 8){
                    sb.append(map[i + 1]);
                    for(int j = 0; j < d - 5; j++)
                        sb.append(map[i]);
                }else if(d == 9){
                    sb.append(map[i]);
                    sb.append(map[i + 2]);
                }
            }
            num = num % scale;
            scale /= 10;
        }
        return sb.toString();
    }
}