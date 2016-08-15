public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, Integer> dis = new HashMap<>();
        HashMap<String, List<String>> graph = new HashMap<String, List<String>> ();
        wordList.add(beginWord);
        wordList.add(endWord);
        BFS(endWord, beginWord, wordList, dis, graph);
        List<List<String>> res = new ArrayList<List<String>>();
        DFS(beginWord, endWord, wordList, dis, graph, res, new ArrayList<>());
        return res;
    }
    
    
    private void DFS(String cur, String end, Set<String> dict, Map<String, Integer> dis, HashMap<String, List<String>> graph,List<List<String>> res, List<String> path){
        path.add(cur);
        if(cur.equals(end)){
            res.add(new ArrayList<>(path));
        }
        for(String n : graph.get(cur)){
            if(dis.get(cur) == dis.get(n) + 1){
                DFS(n, end, dict, dis, graph, res, path);
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void BFS(String beginWord, String endWord, Set<String> dict, Map<String, Integer> dis, HashMap<String, List<String>> graph){

        for(String s : dict){
            graph.put(s, new ArrayList<String>());
        }
        Queue<String> queue = new LinkedList<>();
        dis.put(beginWord, 0);
        queue.offer(beginWord);
        int len = 0;
        while(! queue.isEmpty()){
            len++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(String neighbor : getNeighbors(cur, wordList)){
                    graph.get(word).add(neighbor);
                    if(!dis.containsKey(neighbor)){
                        dis.put(neighbor, len);
                        queue.offer(neighbor);
                    }
                }
            }
        }
    }
    
    
    
    private List<String> getNeighbors(String word, Set<String> wordList){
        char[] w = word.toCharArray();
        List<String> words = new ArrayList<String>();
        for(int i = 0; i < w.length; i++){
            char cur = w[i];
            for(char next = 'a' ;next <= 'z'; next++){
                if(cur != next){
                    w[i] = next;
                    String s = new String(w);
                    if(!wordList.contains(s)){
                        words.add(s);
                    }
                    w[i] = cur;
                }
            }
        }
        return words;
    }
}