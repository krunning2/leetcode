public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || z <= x + y && z % getGCD(x, y) == 0;
    }
    
    private int getGCD(int x, int y){
        return y == 0 ? x : getGCD(y, x % y);
    }
}