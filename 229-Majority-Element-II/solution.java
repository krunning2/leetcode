public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int res1 = -1;
        int res2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int n : nums){
            if(n == res1){
                count1++;
            }else if(n == res2){
                count2++;
            }else if(count1 == 0){
                res1 = n;
                count1 = 1;
            }else if(count2 == 0){
                res2 = n;
                count2 = 1;
            }else{
                count2--;
                count1--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums){
            if(n == res1){
                count1++;
            }else if(n == res2){
                count2++;
            }
        }
        if(count1 > nums.length / 3) res.add(res1);
        if(count2 > nums.length / 3) res.add(res2);
        return res;
    }
}