public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        int minLen = Integer.MAX_VALUE;
        int total = 0;
        StringBuilder sb = new StringBuilder();
        // init
        for(String s : words){
            for(char c : s.toCharArray()){
                if(!map.containsKey(c)){
                    map.put(c, new HashSet<>());
                    indegree[c - 'a'] = 0;
                    total++;
                }
            }
        }
        // build edge, only compare the current string and next string
        for(int j = 0; j < words.length - 1; j++){
            String cur = words[j];
            String next = words[j + 1];
            int len = Math.min(cur.length() , next.length());
            for(int i = 0; i < len; i++){
                if(cur.charAt(i) != next.charAt(i)){
                    Set<Character> set = map.get(cur.charAt(i));
                    if(!set.contains(next.charAt(i))){
                        indegree[next.charAt(i) - 'a']++;
                        set.add(next.charAt(i));
                    }
                    // because we are not able to compare rest after this
                    break;
                }
            }
        }
        // BFS
        
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer((char)(i + 'a'));
                sb.append((char)(i + 'a'));
                total --;
            }
        }
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                for(char c : map.get(queue.poll())){
                    indegree[c - 'a']--;
                    if(indegree[c - 'a'] == 0){
                        total--;
                        sb.append(c);
                        queue.offer(c);
                    }
                }
            }
        }
        return total == 0 ? sb.toString() : "";
    }
}