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
        int res = 0;
        if(nestedList == null){
            return res;
        }
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.offer(nestedList);
        int level = 0;
        while(! queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                List<NestedInteger> cur = queue.poll();
                for(NestedInteger n : cur){
                    if(n.isInteger()){
                        res += n.getInteger() * level;
                    }else{
                        queue.offer(n.getList());
                    }
                }
            }
        }
        return res;
    }
}