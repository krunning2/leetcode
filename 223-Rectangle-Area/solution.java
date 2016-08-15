public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int recOne = (C - A) * (D - B);
        int recTwo = (G - E) * (H - F);
        if(A > G || E > C || B > H || F > D){
            return recOne + recTwo;
        }
        int length = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        return recOne + recTwo - length * height;
    }
}