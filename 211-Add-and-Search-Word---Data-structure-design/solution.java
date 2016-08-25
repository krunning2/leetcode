public class WordDictionary {
    Trie t = new Trie();
    // Adds a word into the data structure.
    public void addWord(String word) {
        t.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return t.search(word);
    }
    class Trie{
        TrieNode root = new TrieNode(false, ' ');
        public void addWord(String word) {
            TrieNode cur = root;
            for(char ch : word.toCharArray()){
                if(!cur.map.containsKey(ch)){
                    cur.map.put(ch, new TrieNode(false, ch));
                }
                cur = cur.map.get(ch);
            }
            cur.is_end = true;
        }
        public boolean search(String word){
            return search(word, 0, root);
        }
        private boolean search(String word, int pos, TrieNode node) {
            if(pos == word.length() && node.is_end) return true;
            if(pos == word.length() && !node.is_end) return false;
            char ch = word.charAt(pos);
            if(ch == '.'){
                for(Map.Entry<Character, TrieNode> entry : node.map.entrySet()){
                    if(search(word, pos + 1, entry.getValue())) return true;
                }
            }else if(node.map.containsKey(ch)){
                return search(word, pos + 1, node.map.get(ch));
            }
            return false;
        }
    }
    class TrieNode{
        char c;
        Map<Character, TrieNode> map;
        boolean is_end;
        TrieNode(boolean is_end, char c){
            map = new HashMap<>();
            this.is_end = is_end;
            this.c = c;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");