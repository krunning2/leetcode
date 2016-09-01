public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0){
            return 1;
        }
        int pos2 = 0, pos3 = 0, pos5 = 0;
        List<Integer> num = new ArrayList<>();
        num.add(1);
        int f2 = 2, f3 = 3, f5 = 5;
        int min = Math.min(f2, Math.min(f3, f5));
        for(int i = 1; i < n; i++){
            num.add(min);
            if(min == f2) pos2++;
            if(min == f3) pos3++;
            if(min == f5) pos5++;
            f2 = num.get(pos2) * 2;
            f3 = num.get(pos3) * 3;
            f5 = num.get(pos5) * 5;
            min = Math.min(f2, Math.min(f3, f5));
        }
        return num.get(n - 1);
    }
}