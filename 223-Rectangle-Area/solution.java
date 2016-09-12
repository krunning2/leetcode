public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int aera1 = (C - A) * (D - B);
        int aera2 = (G - E) * (H - F);
        if(D < F || B > H || C < E || G < A){
            return aera1 + aera2;
        }
        int height = Math.min(C, G) - Math.max(A, E);
        int weight = Math.min(D, H) - Math.max(B, F);
        return aera1 + aera2 - height * weight;
    }
}