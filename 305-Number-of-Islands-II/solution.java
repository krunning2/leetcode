public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] islands = new int[m][n];
        UF uf = new UF(m, n);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < positions.length; i++){
            int row = positions[i][0];
            int col = positions[i][1];
            islands[row][col] = 1;
            count ++;
            for(int k = 0; k < 4; k++){
                int x = dx[k] + row;
                int y = dy[k] + col;
                if(x >= 0 && y >=0 && x < m && y < n && islands[x][y] == 1){
                    int f1 = uf.find(row * n + col);
                    int f2 = uf.find(x * n + y);
                    if(f1 != f2){
                        uf.union(f1, f2);
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    class UF{
        Map<Integer, Integer> fa = new HashMap<>();
        UF(int m, int n){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    fa.put(i * n + j, i * n + j);
                }
            }
        }
        void union(int x, int y){
            int f1 = find(x);
            int f2 = find(y);
            fa.put(f1, f2);
        }
        
        int find(int x){
            while(x != fa.get(x)){
                fa.put(x, fa.get(fa.get(x)));
                x = fa.get(x);
            }
            return x;
        }
    }
}