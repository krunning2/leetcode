public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
         //flatten three-dimension points into two two-dimension points which contains left point and right points with height
        //height of left point is nagtive while right is positive
        for(int i = 0; i < buildings.length; i++){
            heights.add(new int[] {buildings[i][0], -buildings[i][2]});
            heights.add(new int[] {buildings[i][1], buildings[i][2]});
        }
        //sort the points in ascending order by x coordinator
        // if the x is same, the lower height comes first
        Collections.sort(heights, (a, b)->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b) ->(b - a));
        int pre = 0;
        queue.offer(0);
        for(int i = 0 ; i < heights.size(); i++){
            int[] cur = heights.get(i);
            if(cur[1] < 0){
                queue.offer(-cur[1]);
            }else{
                queue.remove(cur[1]);
            }
            int h = queue.peek();
            if(pre != h){
                res.add(new int[] {cur[0], h});
                pre = h;
            }
        }
        return res;
    }
    
}