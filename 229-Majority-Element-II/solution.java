public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int n : nums){
            // we need to first check the "candidate1 == n" then "check count2 == 0", since it can be "88777", so can1 == 8, but count == 0, so can2 = 8 
            if(candidate1 == n){
                count1++;
            }else if(candidate2 == n){
                count2++;
            }else if(count1 == 0){
                candidate1 = n;
                count1 ++;
            }else if(count2 == 0){
                candidate2 = n;
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int n : nums){
            if(candidate1 == n){
                count1++;
            }else if(candidate2 == n){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > nums.length / 3)
            res.add(candidate1);
        if(count2 > nums.length / 3)
            res.add(candidate2);
        return res;
    }
}