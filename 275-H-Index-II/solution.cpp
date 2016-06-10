public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0){
            return 0;
        }
        // Arrays.sort(citations);
        int start = 0, end = citations.length - 1, len = citations.length;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(citations[mid] < len - mid){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return len - end;
    }
}