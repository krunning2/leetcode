public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap();
        for(String s : strs){
            char tmp = s.toCharArray();
            Arrays.sort(tmp)
            String key = String.valueOf(tmp);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
        }
        return map.values();
    }
}