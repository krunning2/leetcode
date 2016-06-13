public class ValidWordAbbr {
    Map<String, String> dict = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abb = getAbb(s);
            if(dict.containsKey(abb) && !dict.get(abb).equals(s)){
                dict.put(getAbb(s), "");
            }else{
                dict.put(getAbb(s), s);
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbb(word);
        if(dict.containsKey(abbr) && dict.get(abbr).equals(word) || !dict.containsKey(abbr)){
            return true;
        }
        return false;
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