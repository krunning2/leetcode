public class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] exist = new boolean[26];
        Stack<Character> stack = new Stack<Character>();
        int[] counter = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars){
            counter[c - 'a'] ++;
        }
        for(char c : chars){
            counter[c - 'a'] --;
            if(exist[c - 'a']){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > c && counter[stack.peek() - 'a'] > 0){
                int tmp = stack.pop() - 'a';
                exist[tmp] = false;
            }
            stack.push(c);
            exist[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}