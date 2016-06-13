public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0){
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings){
            String key = getBitMap(s);
            map.putIfAbsent(s, new ArrayList<String>());
            map.get(key).add(s);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    private String getBitMap(String s){
        StringBuilder sb = new StringBuilder();
        int dist = s.charAt(0) - 'a';
        for(int i = 0; i < s.length(); i++){
            sb.append((s.charAt(i) - 'a' - dist + 26) % 26 + 'a');
        }
        return sb.toString();
    }
}