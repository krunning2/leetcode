public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j <= word.length(); j ++){
                String s1 = word.substring(0, j);
                String s2 = word.substring(j);
                if(isValid(s1)){
                    String s2rvs = new StringBuilder(s2).reverse().toString();
                    if(map.containsKey(s2rvs) && map.get(s2rvs) != i){
                        res.add(Arrays.asList(map.get(s2rvs), i));
                    }
                }
                if(isValid(s2) && s2.length()!=0){
                    String s1rvs = new StringBuilder(s1).reverse().toString();
                    if(map.containsKey(s1rvs) && map.get(s1rvs) != i){
                        res.add(Arrays.asList(i, map.get(s1rvs)));
                    }
                }
            }
        }
        return res;
    }
    private boolean isValid(String word){
        int start = 0;
        int end = word.length() - 1;
        while(start < end){
            if(word.charAt(start) != word.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}