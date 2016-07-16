/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!knows(i, res)){
                res = i;
            }
        }
        for(int i = 0; i < n; i++){
            if(res != i){
                if(knows(res, i) || !knows(i, res)){
                    return -1;
                }
            }
        }
        return res;
    }
}