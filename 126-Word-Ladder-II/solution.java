public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        wordList.add(beginWord);
        wordList.add(endWord);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        BFS(beginWord, endWord, wordList, graph, dist);
        DFS(beginWord, endWord, graph, dist, new ArrayList<>(), res);
        return res;
    }
    
    
    private void DFS(String begin, String end, Map<String, List<String>> graph, Map<String, Integer> dist, List<String> path, List<List<String>> res){
        path.add(begin);
        if(begin.equals(end)){
            res.add(new ArrayList<>(path));
        }
        for(String n : graph.get(begin)){
            if(dist.get(n) == dist.get(begin) + 1){
                DFS(n, end, graph, dist, path, res);
            }
        }
        path.remove(path.size() - 1);
    }
    
    private void BFS(String begin, String end, Set<String> list, Map<String, List<String>> graph, Map<String, Integer> dist){
        int level = 0;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(begin);
        dist.put(begin, 0);
        // for(String s : list){
        //     graph.put(s, new ArrayList<String>());
        // }
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                graph.putIfAbsent(cur, new ArrayList<>());
                for(String s : getWords(cur, list)){
                    graph.get(cur).add(s);
                    if(!dist.containsKey(s)){
                        queue.offer(s);
                        dist.put(s, level);
                    }
                }
            }
        }
    }
    
    private List<String> getWords(String word, Set<String> list){
        List<String> words = new ArrayList<>();
        char[] word_c = word.toCharArray();
        for(int i = 0; i < word_c.length; i++){
            char cur = word_c[i];
            for(char c = 'a'; c <= 'z'; c++){
                if(c != cur){
                    word_c[i] = c;
                    String newWord = new String(word_c);
                    if(list.contains(newWord)){
                        words.add(newWord);
                    }
                    word_c[i] = cur;
                }         
            }
        }
        return words;
    }
    
    
}