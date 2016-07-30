public class Solution {
    public int strStr(String h, String n) {
        if(n == null || n.length() == 0){
            return 0;
        }
        if(h == null){
            return -1;
        }
        for(int i = 0; i <= h.length() - n.length(); i++){
            for(int j = 0; j < n.length(); j++){
                if(h.charAt(i + j) != n.charAt(j)){
                    break;
                }
                if(j == n.length() - 1){
                    return i;
                }
            }
        }
        return -1;
    }
}