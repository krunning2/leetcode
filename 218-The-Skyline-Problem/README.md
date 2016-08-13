1. Flatten three-dimension points into two two-dimension points which contains left point and right points with height. To differentiate left or right points, height of left point is negative while right is positive

2. Sort the points in ascending order by x coordinator. if the x is same, the lower height comes first, and the left point always come before the right point.

3. Iterate the array, and add left point into queue. When get right points, that means we reach the end of current height, so remove the heigh form the queue.

4. keep a pre height, if it is not same, we add into the result 