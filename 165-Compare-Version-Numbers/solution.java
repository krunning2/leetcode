public class Solution {
    public int compareVersion(String version1, String version2) {
        int p1 = 0;
        int p2 = 0;
        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");
        while(p1 < v1.length && p2 < v2.length()){
            int i1 = Integer.valueOf(v1[p1]);
            int i2 = Integer.valueOf(v2[p2]);
            if(i1 > i2) return 1;
            if(i1 < i2) return -1;
            p1 ++;
            p2 ++;
        }
        return p1 == v1.length ? -1 : 1;
    }
}