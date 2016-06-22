public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        diff = 1;
        for(String node : nodes){
            diff--;
            if(diff < 0) return false;
            if(!diff.equals("#")){
                diff += 2;
            }
        }
        return diff == 1;
    }
}