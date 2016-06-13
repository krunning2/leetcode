public class Solution {
    public String reverseVowels(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
        while(start <= end){
            if(checkVowel (chars[start]) && checkVowel(chars[end]) ){
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end --;
            }else if(!checkVowel(chars[start])){
                start++;
            }else if(!checkVowel(chars[end])){
                end --;
            }
        }
        return new String(chars);
    }
    private boolean checkVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' ||
        c == 'o' || c == 'u' || c == 'A' || c == 'E' ||
        c == 'I' || c == 'O' || c == 'U';
    }
}