public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        int start = 0, end = citations.length - 1, len = citations.length;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(citations[mid] > len - mid){
                mid = start;
            }else{
                mid = end;
            }
        }
        if(citations[end] >= end){
            return end;
        }else if(citations[start] >= start){
            return start;
        }
        return 0;
    }
}