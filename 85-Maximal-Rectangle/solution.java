public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null) return 0;
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            res = Math.max(res, getMax(matrix[i]));
        }
        return res;
    }
    private int getMax(int[] height){
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= height.length; i++){
            int cur = i == height.length ? -1 : height[i];
            while(!stack.isEmpty() && height[stack.peek()] >= cur){
                int h = height[stack.pop()];
                int len = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * len);
            }
        }
        return max;
    }
}