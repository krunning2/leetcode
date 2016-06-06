public class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> degree = new HashMap<Character, Integer>();
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        for(String s : words){
            for(char c : s.toCharArray()){
                degree.put(c, 0);
            }
        }
        for(int i = 0; i < words.length - 1; i ++){
            String cur = words[i];
            String next = words[i + 1];
            int len = Math.min(cur.length(), next.length());
            for(int j = 0; j < len; j++){
                if(cur.charAt(j) != next.charAt(j)){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(cur.charAt(j))){
                        set = map.get(cur.charAt(j));
                    }else{
                        map.put(cur.charAt(j), set);
                    }
                    if(!set.contains(next.charAt(j))){
                        degree.put(cur.charAt(j), degree.get(cur.charAt(j))+1);
                        set.add(next.charAt(j));
                    }
                }
                // because we are not able to compare rest after this
                break;
            }
        }
        Queue<Character> queue = new LinkedList<Character>();
        for(char c : degree.keySet()){
            if(degree.get(c) == 0){
                queue.offer(c);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            res.append(c);
            if(map.containsKey(c)){
                for(char cur : map.get(c)){
                    degree.put(cur, degree.get(cur) - 1);
                    if(degree.get(cur) == 0){
                        queue.offer(cur);
                    }
                }
            }
        }
        if(degree.size != res.length()){
            return "";
        }
        return res.toString();
    }
}