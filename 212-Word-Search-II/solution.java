public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if(board == null || board.length == 0 || words == null || words.length == 0){
            return new ArrayList<String>();
        }
        Trie t = new Trie();
        for(String s : words){
            t.insert(s);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                DFS(board, i, j, "", new boolean[m][n], t, res);
            }
        }
        return new ArrayList<String>(res);
    }
    
    private void DFS(char[][] board, int i, int j, String s, boolean[][]visited, Trie t, Set<String> res){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
            return;
        }
        s += board[i][j];
        if(!t.startsWith(s)){
            return;
        }
        if(t.search(s)){
            res.add(s);
        }
       
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int k = 0; k < 4; k++){
            visited[i][j] = true;
            DFS(board, i + dx[k], j + dy[k], s, visited, t, res);
            visited[i][j] = false;
        }
        
    }
    
    class Trie{
        Node root;
        Trie(){
            root = new Node();
        }
        
        public void insert(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(!cur.map.containsKey(c)){
                    cur.map.put(c, new Node());
                }
                cur = cur.map.get(c);
            }
            cur.end = true;
        }
        
        public boolean search(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
            return cur.end;
        }
        
        public boolean startsWith(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(!cur.map.containsKey(c)){
                    return false;
                }
                cur = cur.map.get(c);
            }
            return true;
        }
        
        class Node {
            Map<Character, Node> map;
            boolean end;
            Node(){
                map = new HashMap<>();
                end = false;
            }
        }
    }
}