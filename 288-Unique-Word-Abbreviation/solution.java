public class ValidWordAbbr {
    Map<String, String> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abb = getAbb(s);
            if(map.containsKey(abb) && !map.get(abb).equals(s)){
                map.put(abb, "");
            }else{
                map.put(abb, s);
            }
        }
    }

    public boolean isUnique(String word) {
        String abb = getAbb(word);
        return map.containsKey(abb) && map.get(abb).equals(word) || !map.containsKey(abb);
    }
    private String getAbb(String s){
        if(s.length() > 2){
            return new StringBuilder().append(s.charAt(0)).append(s.length() - 2).append(s.charAt(s.length() - 1)).toString();
        }else{
            return s;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");