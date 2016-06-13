public class ValidWordAbbr {
    Map<String, Boolean> dict = new HashMap<String, Boolean>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abb = getAbb(s);
            if(dict.containsKey(abb)){
                dict.put(getAbb(s), false);
            }else{
                dict.put(getAbb(s), true);
            }
        }
    }

    public boolean isUnique(String word) {
        return dict.get(getAbb(word));
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