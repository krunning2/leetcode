public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);
        int p1 = 0, p2 = 0;
        while(p1 < max && p2 < max){
            int i1 = p1 < v1.length ? Integer.valueOf(v1[p1]) : 0;
            int i2 = p2 < v2.length ? Integer.valueOf(v2[p2]) : 0;
            if(i1 < i2){
                return -1;
            }else if(i1 > i2){
                return 1;
            }else{
                p1++;
                p2++;
            }
        }
        return 0;
    }
}