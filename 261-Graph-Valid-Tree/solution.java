public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length){
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length; i++){
            int fa1 = uf.find(edges[i][0]);
            int fa2 = uf.find(edges[i][1]);
            if(fa1 == fa2){
                return false;
            }else{
                uf.union(fa1, fa2);
            }
        }
        return true;
    }
    
    class UnionFind{
        HashMap<Integer, Integer> father;
        UnionFind(int n){
            father = new HashMap<>();
            for(int i = 0; i < n; i++)
                father.put(i, i);
        }
        
        int find(int x){
            int fa = father.get(x);
            while(fa != father.get(fa)){
                fa = father.get(fa);
            }
            int node = x;
            while(node != father.get(node)){
                father.put(node, fa);
                node = father.get(node);
            }
            return fa;
        }
        void union(int x, int y){
            int fa1 = find(x);
            int fa2 = find(y);
            father.put(fa1, fa2);
        }
    }
    
}