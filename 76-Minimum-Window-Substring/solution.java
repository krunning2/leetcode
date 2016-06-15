public class Solution {
    public String minWindow(String source, String target) {
        String res = "";
        if(source == "" || source == null || target == "" || target == null){
            return res;
        }
        char[] targetMap = new char[256];
        char[] sourceMap = new char[256];
        int j = 0;
        int min = -1;
        int count = 0;
        init(target, targetMap);
        for(int i = 0 ; i < source.length(); i++){
            while(j < source.length() && count < target.length()){
                char cur = source.charAt(j);
                if(sourceMap[cur] < targetMap[cur]){
                    count++;
                }
                sourceMap[cur]++;
                j++;
            }
            if(count == target.length() && (min > j - i || min == -1)){
                min = j - i;
                res = source.substring(i, j);
            }
            char cur = source.charAt(i);
            if(sourceMap[cur] == targetMap[cur]){
                count--;
            }
            sourceMap[cur] --;
        }
        return res;
    }
    
    private void init(String target, char[] targetMap){
        for(int i = 0; i < target.length(); i++){
            targetMap[target.charAt(i)]++;
        }
    }
}