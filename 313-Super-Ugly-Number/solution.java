public class Solution {
    //2 4 7 8 13 14 16  19 2*7 
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> list = new ArrayList<Integer>();
        int[] index = new int[primes.length];
        list.add(1);
        while(list.size() < n){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < index.length; i++){
                min = Math.min(min, list.get(index[i]) * primes[i]);
            }
            list.add(min);
            for(int i = 0; i < index.length; i++){
                if(min == list.get(index[i]) * primes[i]){
                    index[i]++;
                }
            }
        }
        return list.get(n - 1);
    }
}