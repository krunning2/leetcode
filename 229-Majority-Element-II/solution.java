public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int candidate1 = -1;
        int candidate2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int n : nums){
            if(n == candidate1){
                count1++;
            }else if(n == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = n;
                count1 = 1;
            }else if(count2 == 0){
                candidate2 = n;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count2 = 0;
        count1 = 0;
        for(int n : nums){
            if(n == candidate1){
                count1++;
            }else if(n == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length / 3) result.add(candidate1);
        if(count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}