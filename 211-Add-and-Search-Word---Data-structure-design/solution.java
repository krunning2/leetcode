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
        Node root;
        Trie(){
            root = new Node();
        }
        
        public void addWord(String word){
            Node cur = root;
            for(char c : word.toCharArray()){
                if(!cur.map.containsKey(c)){
                    cur.map.put(c, new Node());
                }
                cur = cur.map.get(c);
            }
            cur.isString = true;
        }
        
        public boolean search(String word){
            return searchHelper(word, 0, root);
        }
        
        private boolean searchHelper(String word, int pos, Node node){
            if(pos == word.length() && node.isString){
                return true;
            }
            if(pos >= word.length() && !node.isString){
                return false;
            }
            char c = s.charAt(pos);
            if(c == '.'){
                for(Node child : c.map.values){
                    if(searchHelper(word, pos + 1, child)) return true;
                }
                return false;
            }else if(c.map.containsKey(c)){
                return searchHelper(word, pos + 1, node.map.get(c));
            }else{
                return false;
            }
        }
        
        
        
        class Node{
            HashMap<Character, Node> map;
            boolean isString;
            Node(){
                map = new HashMap<Character, Node>();
                isString = false;
            }
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");