public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        int level = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        Set<String> set = new HashSet();
        set.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(String tmp : getString(cur, wordList, j)){
                        if(tmp.equals(endWord)) return level;
                        if(!set.contains(tmp)){
                            queue.offer(tmp);
                            set.add(tmp);
                        }
                    }
                }
            }
        }
        return 0;
    }
    private List<String> getString(String s, Set<String> set, int pos){
        List<String> res = new ArrayList();
        for(char c = 'a'; c <= 'z'; c++){
            String ss = swap(s, pos, c);
            if(c != s.charAt(pos) && set.contains(ss)){
                res.add(ss);
            }
        }
        return res;
    }
    private String swap(String s, int p1, char c){
        char[] tmp = s.toCharArray();
        tmp[p1] = c;
        return new String(tmp);
    }
}