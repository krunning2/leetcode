public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length <= 1){
            return 0;
        }
        int[] values = new int[words.length];
        for(int i = 0; i< words.length; i++){
            String s = words[i];
            for(char c : s.toCharArray()){
                values[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((values[j] & values[i]) == 0 && words[i].length() * words[j].length() > max){
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}