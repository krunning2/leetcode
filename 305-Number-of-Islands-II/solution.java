public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<Integer> ();
        if(positions == null || positions.length == 0){
            return res;
        }
        int count = 0;
        UnionFind uf = new UnionFind(m, n);
        int[][] matrix = new int[m][n];
        for(int i = 0; i < positions.length; i++){
            int row = positions[i][0];
            int col = positions[i][1];
            matrix[row][col] = 1;
            int[] dr = {0, 0, -1, 1};
            int[] dc = {1, -1, 0, 0};
            count++;
            for(int j = 0; j < 4; j++){
                int nextR = row + dr[j];
                int nextC = col + dc[j];
                if(nextR >= 0 && nextR < m || nextC >= 0 && nextC < n && visited[nextR][nextC] && matrix[nextR][nextC] == 1){
                    int f1 = uf.find(convertToId(row, col, n));
                    int f2 = uf.find(convertToId(nextR, nextC, n));
                    if(f1 != f2){
                        count--;
                        uf.union(convertToId(row, col, n), convertToId(nextR, nextC, n));
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    private int convertToId(int row, int col, int n){
        return row * n + col;
    }
    class UnionFind{
        Map<Integer, Integer> father;
        UnionFind(int m, int n){
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    father.put(convertToId(i, j, n),convertToId(i, j, n));
                }
            }
        }
        
        public int find(int key){
            int f = father.get(key);
            while(f != father.get(f)){
                f = father.get(f);
            }
            int c = father.get(key);
            int tmp = c;
            while(c != father.get(c)){
                tmp = father.get(c);
                father.put(c, f);
                c = tmp;
            }
            return f;
        }
        
        public void union(int key1, int key2){
            int f1 = find(key1);
            int f2 = find(key2);
            if(f1 != f2)
                father.put(f1, f2);
        }
    }
}