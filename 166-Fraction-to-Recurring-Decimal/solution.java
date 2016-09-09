public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        if(denominator == 0) return "NaN";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        if(numerator < 0) sign *= -1;
        if(denominator < 0) sign *= -1;
        if(sign < 0){
            sb.append("-");
        }
        Long n = new Long(numerator);
        Long d = new Long(denominator);
        d = Math.abs(d);
        n = Math.abs(n);
        sb.append(n / d);
        if(n % d == 0){
            return sb.toString();
        }
        sb.append(".");
        long remaining = n % d;
        while(remaining > 0){
            if(map.containsKey(remaining)){
                sb.insert(map.get(remaining), "(");
                sb.append(")");
                return sb.toString();
            }
            map.put(remaining, sb.length());
            remaining *= 10;
            sb.append(remaining / d);
            remaining %= d;
        }
        return sb.toString();
    }
}