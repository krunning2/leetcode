Define x as the kth largest element of the two sorted arrays.
if A[ k ] < B[ k ], we should drop the elements from A[ 0 ] to A[ k ] because 

when merging A and B into C, before insert the B[k/2] into C, all first k/2 element of A must already have been inserted into C, but now, C just has K-1 element which is less than K. So we can drop the first k/2 elements in A.