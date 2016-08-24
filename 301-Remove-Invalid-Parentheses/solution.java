public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) return res;
        Set<String> set = new HashSet<>();
        set.add(s);
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        boolean found = false;
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                if(isValid(cur)){
                    res.add(cur);
                    found = true;
                }else{
                    for(int j = 0; j < cur.length(); j++){
                        if(cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;
                        String tmp = cur.substring(0, j) + cur.substring(j + 1);
                        if(!set.contains(tmp)){
                            set.add(tmp);
                            queue.offer(tmp);
                        }
                    }
                }
            }
            if(found) break;
        }
        return res;
    }
    private boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') count++;
            if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}