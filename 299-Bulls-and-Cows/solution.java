public class Solution {
    public String getHint(String secret, String guess) {
        HashTable<Character> table = new HashTable<>();
        int cow = 0;
        int bull = 0;
        for(char c : secret){
            table.add(c);
        }
        for(int i = 0; i < guess.length(); i++){
            if(guess.charAt(i) == secret.charAt(i)){
                bull++;
            }else if(table.contains(guess.charAt(i))){
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }
}