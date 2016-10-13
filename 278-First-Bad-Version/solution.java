/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s = 1, e = n;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(isBadVersion(m)){
                e = m;
            }else{
                s = m;
            }
        }
        return isBadVersion(s) ? s : e;
    }
}