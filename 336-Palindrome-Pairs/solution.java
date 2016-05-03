public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length() == 0){
            return res;
        }
        TrieNode root = new TrieNode();
        for(int i = 0; i < words.length; i++){
            add(words[i], root, i);
        }
        for(int i = 0; i < words.length; i++){
            search(words[i], i, root, res);
        }
        return res;
    }
    
    private void search(String word, int index, TrieNode node, List<List<Integer>>res){
        for(int i = 0; i < word.length(); i++){
            //check sll s
            if(node.index >= 0 && node.index != i && check(word, i, word.length() - 1)){
                res.add(Arrays.asList(index, node.index));
            }
            node = node.map.get(word.charAt(i));
            if(node == null) return;
        }
        //check lls s
        //also check ab ba
        for(int i = 0; i < node.list.size(); i++){
            res.add(Arrays.asList(index, i));
        }
    }
    
    private void add(String word, TrieNode node, int index){
        for(int i = word.length() - 1; i >= 0; i--){
            if(!node.map.containsKey(word.charAt(i))){
                node.map.put(word.charAt(i), new TrieNode());
            }
            if(check(word, 0, i)){
                node.list.add(index);
            }
            node = node.map.get(word.charAt(i));
        }
        // single is valid
        node.list.add(index);
        node.index = index;
    }
    private boolean check(String word, int s, int e){
        while(s <= e){
            if(word.charAt(s) != word.charAt(e)){
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
    class TrieNode{
        Map<Character, TrieNode> map;
        int index;
        List<Integer> list;
        TrieNode(){
            map = HashMap<Character, TrieNode>();
            index = -1;
            list = new ArrayList<Integer>();
        }
    }
}