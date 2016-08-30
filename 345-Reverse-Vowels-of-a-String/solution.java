public class Solution {
    public String reverseVowels(String s) {
        if(s == null) return s;
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while(start < end){
            if(isVowel(chars[end]) && isVowel(chars[start])){
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }else if(!isVowel(chars[end])){
                end--;
            }else if(!isVowel(chars[start])){
                start++;
            }
        }
        return new String(chars);
    }
    private boolean isVowel(char c){
        if(c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U'){
            return true;
        }
        return false;
    }
}