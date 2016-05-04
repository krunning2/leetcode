public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] exist = new boolean[26];
        Deque<Character> deque = new LinkedList<Character>();
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            counter[c - 'a'] ++;
        }
        for(char c : chars){
            if(exist[c - 'a']){
                continue;
            }
            counter[c] --;
            while(!deque.isEmpty() && deque.peek() > c && counter[deque.peek() - 'a'] > 0){
                int tmp = deque.pop() - 'a';
                counter[tmp]--;
                exist[tmp] = false;
            }
            deque.push(c);
            exist[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}