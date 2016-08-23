public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(beginWord);
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        HashSet<String> set = new HashSet<>();
        set.add(beginWord);
        int level = 1;
        while(! queue.isEmpty()){
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(String s : getList(cur, j, wordList, set)){
                        if(endWord.equals(s)) return level;
                        queue.offer(s);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getList(String s, int pos, Set<String> wordList, HashSet<String> set){
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++){
            char tmp = chars[pos];
            if(c != tmp){
                chars[pos] = c;
                String ss = new String(chars);
                if(!set.contains(ss) && wordList.contains(ss)){
                    res.add(ss);
                    set.add(ss);
                }
                chars[pos] = tmp;
            }
        }
        return res;
    }
}