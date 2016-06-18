public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n <= 1){
            return true;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            int n0 = edges[i][0];
            int n1 = edges[i][1];
            if(uf.find(n0) == un.find(n1)){
                return false;
            }
            uf.union(n0, n1);
        }
    }
    class UnionFind{
        Map<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<Integer, Integer>();
            for(int j = 0; j < n; j++){
                father.put(j, j)
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