/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1;
        int e = n;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(isBadVersion(m)){
                e = m;
            }else{
                s = m;
            }
        }
        if(isBadVersion(s)) return s;
        if(isBadVersion(e)) return e;
        return 0;
    }
}