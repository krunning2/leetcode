public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        if(rowIndex < 0) return res;
        res.add(1);
        if(rowIndex == 0) return res;
        Integer[] tmp = new Integer[rowIndex + 1];
        tmp[0] = 1;
        for(int i = 1; i <= rowIndex; i++){
            for(int j = i; j >= 0; j--){
                if(j == i || j == 0){
                    tmp[j] = 1;
                }else{
                    tmp[j] = tmp[j] + tmp[j - 1];
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(tmp));
    }
}