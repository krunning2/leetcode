public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if((n + m) % 2 == 0){
            return (find(nums1, nums2, 0, 0, (n + m) / 2 + 1) + find(nums1, nums2, 0, 0, (n + m) / 2) )/ 2.0;
        }else{
            return find(nums1, nums2, 0, 0 , (n + m) / 2 + 1);
        }
    }
    private int find(int[] A, int[] B, int startA, int startB, int k){
        if(startA >= A.length){
            return B[startB + k - 1];
        }
        if(startB >= B.length){
            return A[startA + k - 1];
        }
        if(k == 1){
            return Math.min(A[startA], B[startB]);
        }
        int keyA = k/2 + startA - 1 >= A.length ? Integer.MAX_VALUE : A[k/2 + startA - 1];
        int keyB = k/2 + startB - 1 >= B.length ? Integer.MAX_VALUE : B[k/2 + startB - 1];
        if(keyA < keyB){
            return find(A, B, startA + k/2, startB, k- k / 2);
        }else{
            return find(A, B, startA, startB + k/2, k - k / 2);
        }
    }
}