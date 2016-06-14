class TrieNode {
    // Initialize your data structure here.
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
            node = node.get(c);
        }
        node.is_end = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.map.containsKey()){
                node = node.get(c);
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
        for(char c : word.toCharArray()){
            if(node.map.containsKey()){
                node = node.get(c);
            }else{
                return false;
            }
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");