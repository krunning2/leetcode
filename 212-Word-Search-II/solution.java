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
        visited[i][j] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int k = 0; k < 4; k++){
            DFS(board, i + dx[k], j + dy[k], s, visited, t, res);
        }
        visited[i][j] = false;
    }
    
    class TrieNode {  
        public TrieNode[] children = new TrieNode[26];  
        public String item = "";  
          
        // Initialize your data structure here.  
        public TrieNode() {  
        }  
    }  
  
    class Trie {  
        private TrieNode root;  
      
        public Trie() {  
            root = new TrieNode();  
        }  
      
        // Inserts a word into the trie.  
        public void insert(String word) {  
            TrieNode node = root;  
            for (char c : word.toCharArray()) {  
                if (node.children[c - 'a'] == null) {  
                    node.children[c - 'a'] = new TrieNode();  
                }  
                node = node.children[c - 'a'];  
            }  
            node.item = word;  
        }  
      
        // Returns if the word is in the trie.  
        public boolean search(String word) {  
            TrieNode node = root;  
            for (char c : word.toCharArray()) {  
                if (node.children[c - 'a'] == null) return false;  
                node = node.children[c - 'a'];  
            }  
            return node.item.equals(word);  
        }  
      
        // Returns if there is any word in the trie  
        // that starts with the given prefix.  
        public boolean startsWith(String prefix) {  
            TrieNode node = root;  
            for (char c : prefix.toCharArray()) {  
                if (node.children[c - 'a'] == null) return false;  
                node = node.children[c - 'a'];  
            }  
            return true;  
        }  
    }
}