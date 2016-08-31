public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0){
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strings){
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        return res;
    }
    private String getKey(String s){
        char first = s.charAt(0);
        int diff = first - 'a';
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - diff < 'a'){
                sb.append((char)(s.charAt(i) - diff + 26));
            }else{
                sb.append((char)(s.charAt(i) - diff));
            }
        }
        return sb.toString();
    }
}