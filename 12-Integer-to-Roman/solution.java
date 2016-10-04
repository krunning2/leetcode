public class Solution {
    public String intToRoman(int num) {
        int scale = 1000;
        String[] romans = {"I", "V", "X", "L", "C", "D", "M"};
        StringBuilder sb = new StringBuilder();
        for(int i = 6; i >= 0; i = i-2){
            int digit = num / scale;
            if(digit > 0){
                if(digit > 0 && digit <= 3){
                    for(int j = 0; j < digit; j++){
                        sb.append(romans[i]);
                    }
                }else if(digit == 4){
                    sb.append(romans[i]);
                    sb.append(romans[i + 1]);
                }else if(digit == 5){
                    sb.append(romans[i + 1]);
                }else if(digit >= 6 && digit <= 8){
                    sb.append(romans[i + 1]);
                    for(int j = 6; j <= digit; j++){
                        sb.append(romans[i]);
                    }
                }else{
                    sb.append(romans[i]);
                    sb.append(romans[i + 2]);
                }
            }
            num %= scale;
            scale /= 10;
        }
        return sb.toString();
    }
}