public class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean visited[] = new boolean[n];
        int res = n;
        if(edges == null || edges.length == 0){
            return 0;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < n; i++){
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            if(uf.find(n0) != uf.find(n1)){
                res --;
                uf.union(n0, n1);
            }
        }
        return res;
    }
    class UnionFind{
        Map<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<Integer, Integer>();
            father.put(n, n);
        }
        public int find(int key){
            int f = father.get(key);
            while(f != father.get(f)){
                f = father.get(f);
            }
            int p = father.get(key);
            int tmp = -1;
            while(p != father.get(p)){
                tmp = father.get(p);
                father.put(p, f);
                p = tmp;
            }
            return f;
        }
        public void union(int key1, int key2){
            int f1 = find(key1);
            int f2 = find(key2);
            if(f1 != f2){
                father.put(f1, f2);
            }
        }
    }
}