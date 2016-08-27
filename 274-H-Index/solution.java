public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null) return 0;
        int len = citations.length;
        int[] bucket = new int[len + 1];
        for(int i = 0; i < len; i++){
            if(citations[i] >= len){
                bucket[len] ++;
            }else{
                bucket[citations[i]]++;
            }
        }
        int res = 0;
        for(int i = len; i >= 0; i--){
            res += bucket[i];
            if(res >= i){
                return i;
            }
        }
        return 0;
    }
}