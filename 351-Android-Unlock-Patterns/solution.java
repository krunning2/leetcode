public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[7][9] = skip[9][7] = 8;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[3][7] = skip[7][3] = skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[4][6] = skip[6][4] = 5;
        boolean[] visited = new boolean[10];
        int res = 0;
        int[] starts = {1, 2, 5};
        for(int start : starts){
            visited[start] = true;
            if(start != 5){
                res += track(0, skip, visited, start, m, n, 1) * 4;
            }else{
                res += track(0, skip, visited, start, m, n, 1);
            }
            visited[start] = false;
        }
        return res;
    }
    private int track(int count, int[][] skip, boolean[] visited, int cur, int m, int n, int len){
        if(len > n){
            return count;
        }
        if(len >= m){
            count++;
        }
        for(int i = 1; i <= 9; i++){
            if(!visited[i] && (skip[cur][i] == 0 || visited[skip[cur][i]])){
                visited[i] = true;
                count = track(count, skip, visited, i, m, n, len + 1);
                visited[i] = false;
            }
        }
        return count;
    }
}