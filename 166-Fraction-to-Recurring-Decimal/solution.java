public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) return "NaN";
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        if(n * d < 0){
            sb.append("-");
        }
        sb.append(n / d);
        if(n % d == 0){
            return sb.toString();
        }else{
            sb.append(".");    
        }
        HashMap<Long, String> map = new HashMap<Long, String>();
        Long r = n % d;
        while(r > 0){
            if(map.containsKey(r)){
                sb.insert(map.get(r), "(");
                sb.append(")");
                break;
            }
            map.put(r, sb.length());
            r *= 10;
            sb.append(r / d);
            r %= d; 
        }
        return sb.toString();
    }
}