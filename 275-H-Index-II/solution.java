public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        // if(citations.length == 1){
        //     if(citations[0] == 0) return 0;
        //     if(citations[0] > 0) return 1;
        // }
        int len = citations.length;
        int start = 0, end = len - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(citations[mid] <= len - mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(citations[start] >= len - start) return len - start;
        if(citations[end] >= len - end) return len - end;
        
        return 0;
    }
}