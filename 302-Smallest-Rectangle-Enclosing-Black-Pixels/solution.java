public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0){
            return 0;
        }
        int row = image.length;
        int col = image[0].length;
        int left = getBoundary(image, 0, y, 0, row, true, true);
        int right = getBoundary(image, y + 1, col, 0, row, true, false);
        int top = getBoundary(image, 0, x, left, right, false, true);
        int down = getBoundary(image, x + 1, row, left, right, false, false);
        return (right - left) * (down - top);
    }
    private int getBoundary(char[][] image, int low, int high, int min, int max,
                    boolean horizontal, boolean searchFor1){
        while(low < high){
            int mid = low - (low - high) / 2;
            boolean flag = false;
            for(int i = min; i < max; i++){
                if((horizontal ? image[i][mid] : image[mid][i]) == '1'){
                    flag = true;
                    break;
                }
            }
            if(flag == searchFor1){
                high = mid;
            }else{
                low = mid + 1; 
            }
        }
        return low;
    }
}