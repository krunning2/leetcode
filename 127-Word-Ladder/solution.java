public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        dict.add(start);
        dict.add(end);
        queue.offer(start);
        set.add(start);
        int level = 1;
        while(! queue.isEmpty()){
            level ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(int j = 0; j < cur.length(); j++){
                    for(String s : getStrings(cur, j, dict)){
                        if(end.equals(s)){
                            return level;
                        }else if(!set.contains(s)){
                            set.add(s);
                            queue.offer(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getStrings(String s, int pos, Set<String> dict){
        List<String> res = new ArrayList<String>();
        for(char c = 'a'; c <= 'z'; c++){
            if(s.charAt(pos) != c && dict.contains(replace(s, pos, c))){
                res.add(replace(s, pos, c));
            }
        }
        return res;
    }
    private String replace(String s, int pos, char c){
        char[] tmp = s.toCharArray();
        tmp[pos] = c;
        return new String(tmp);
    }
}