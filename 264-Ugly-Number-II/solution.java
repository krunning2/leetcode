public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 0) return -1;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        int m2 = 0, m3 = 0, m5 = 0;
        while(list.size() < n){
            m2 = list.get(i2) * 2;
            m3 = list.get(i3) * 3;
            m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            if(min == m2) i2 ++;
            if(min == m3) i3 ++;
            if(min == m5) i5 ++;
            list.add(min);
        }
        return list.get(n - 1);
    }
}