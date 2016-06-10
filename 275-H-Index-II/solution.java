public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        Arrays.sort(citations);
        int start = 0, end = citations.length - 1, len = citations.length;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(citations[mid] < len - mid){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(citations[end] <= len - end){
            return citations[end];
        }else if(citations[start] <= len - start){
            return citations[start];
        }
        return 0;
    }
}