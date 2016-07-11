public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(s);
        Set<String> set = new HashSet<String>();
        set.add(s);
        boolean found = false;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(isValid(cur)){
                found = true;
                res.add(cur);
            }
            if(found) continue;
            for(int i = 0; i < cur.length(); i++){
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String removed = cur.substring(0, i) + cur.substring(i + 1);
                if(!set.contains(removed)){
                    set.add(removed);
                    queue.offer(removed);
                }
            }
        }
        
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