public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    height[j] = height[j] + 1;
                }else{
                    height[j] = 0;
                }
            }
            res = Math.max(res, getMaxRec(height));
        }
        return res;
    }
    
    private int getMaxRec(int[] height){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = i == height.length ? -1 : height[i];
            while(!stack.isEmpty() && cur <= height[stack.peek()]){
                int h = height[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, len * h);
            }
            stack.push(i);
        }
        return max;
    }
}