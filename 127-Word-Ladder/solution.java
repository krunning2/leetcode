public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.equals(endWord)){
            return 0;
        }
        wordList.add(beginWord);
        wordList.add(endWord);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(String nei : getNei(cur, wordList, visited)){
                    if(nei.equals(endWord)) return level;
                    queue.offer(nei);
                }
            }
        }
        return 0;
    }
    private List<String> getNei(String s, Set<String> list, Set<String> set){
        char[] s_c = s.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s_c.length; i++){
            for(char c = 'a'; c <= 'z'; c ++){
                if(s_c[i] != c ){
                    char tmp = s_c[i];
                    s_c[i] = c;
                    String ss = new String(s_c);
                    if(list.contains(ss) && !set.contains(ss)){
                        res.add(ss);
                        set.add(ss);
                    }
                    s_c[i] = tmp;
                }
            }
        }
        return res;
    }
}