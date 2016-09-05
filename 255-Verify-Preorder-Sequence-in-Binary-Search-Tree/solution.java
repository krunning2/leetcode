public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int p = -1;
        int min = Integer.MIN_VALUE;
        for(int x : preorder){
            if(x < min){
                return false;
            }
            while(p >= 0 && x > preorder[p]){
                min = preorder[p--];
            }
            preorder[++p] = x;
        }
        return true;
    }
}