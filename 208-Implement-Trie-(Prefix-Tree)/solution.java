class TrieNode {
    Map<Character, TrieNode> map;
    boolean is_end;
    char c;
    public TrieNode() {
        map = new HashMap<>();
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
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.map.containsKey(c)){
                cur.map.put(c, new TrieNode());
            }
            cur = cur.map.get(c);
        }
        cur.is_end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.map.containsKey(c)){
                return false;
            }else{
                cur = cur.map.get(c);
            }
        }
        return cur.is_end;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(!cur.map.containsKey(c)){
                return false;
            }else{
                cur = cur.map.get(c);
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");