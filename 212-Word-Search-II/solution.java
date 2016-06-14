public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || words == null || words.length == 0){
            return res;
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
        return res;
    }
    
    private void DFS(char[][] board, int i, int j, String s, boolean[][]visited, Trie t, List<String> res){
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
        visited[i][j] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int k = 0; k < 4; k++){
            DFS(board, i + dx[k], j + dy[k], s, visited, t, res);
        }
        visited[i][j] = false;
    }
    
    class TrieNode {
        Map<Character, TrieNode> map;
        boolean is_end;
        public TrieNode() {
            map = new HashMap<Character, TrieNode>();
            is_end = false;
        }
    }

    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
    
        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()){
                node.map.putIfAbsent(c, new TrieNode());
                node = node.map.get(c);
            }
            node.is_end = true;
        }
    
        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.map.containsKey(c)){
                    node = node.map.get(c);
                }else{
                    return false;
                }
            }
            return node.is_end;
        }
    
        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for(char c : prefix.toCharArray()){
                if(node.map.containsKey(c)){
                    node = node.map.get(c);
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}