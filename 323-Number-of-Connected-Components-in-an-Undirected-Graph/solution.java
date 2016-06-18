public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        int res = n;
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            if(uf.find(n0) != uf.find(n1)){
                res --;
                uf.union(n0, n1);
            }
        }
        return res
    }
    class UnionFind{
        Map<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<Integer, Integer>();
            for(int i = 0; i < n; i++)
                father.put(i, i);
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