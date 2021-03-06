public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 1) return n;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            if(uf.find(n1) != uf.find(n0)){
                uf.union(n0, n1);
                n--;
            }
        }
        return n;
    }
    class UnionFind{
        HashMap<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<>();
            for(int i = 0; i < n; i++) father.put(i, i);
        }
        void union(int x, int y){
            int f1 = find(x);
            int f2 = find(y);
            father.put(f1, f2);
        }
        int find(int x){
            //int fa = father.get(x);
            while(x != father.get(x)){
                father.put(x, father.get(father.get(x)));
                x = father.get(x);
            }
            return x;
            // while(x != father.get(x)){
            //     int tmp = father.get(x);
            //     father.put(x, fa);
            //     x = tmp;
            // }
            // return fa;
        }
    }
}