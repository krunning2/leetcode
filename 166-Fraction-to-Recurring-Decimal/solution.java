public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if(denominator == 0) return "";
        if(numerator == 0) return "0";
        boolean sign = true;
        if(numerator > 0 && denominator < 0 || numerator < 0 && denominator > 0){
            sign = false;
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        int pre = numerator;
        int remaining = 0;
        boolean dot = false;
        boolean repeat = false;
        while(true){
            if(numerator / denominator > 0){
                if(dot && numerator == pre * 10){
                    repeat = true;
                }
                remaining = numerator - (numerator / denominator) * denominator;
                if(numerator / denominator != 0 && repeat){
                    sb.append("(").append(numerator / denominator).append(")");
                    break;
                }
                sb.append(numerator / denominator);
                if(remaining == 0) break;
                if(!dot){
                    sb.append(".");
                    dot = true;
                }
                pre = numerator;
                numerator = remaining * 10;
            }
        }
        return sb.toString();
    }
}