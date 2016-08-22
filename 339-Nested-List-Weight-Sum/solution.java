/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }
        Queue<NestedInteger> queue = new LinkedList<>();
        int res = 0;
        int depth = 1;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                res += depth * ni.getInteger();
            }else{
                queue.offer(ni);
            }
        }
        while(!queue.isEmpty()){
            depth ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NestedInteger cur = queue.poll();
                for(NestedInteger ni : cur.getList()){
                    if(ni.isInteger()){
                        res += depth * ni.getInteger();
                    }else{
                        queue.offer(ni);
                    }
                }
            }
        }
        return res;
    }
}