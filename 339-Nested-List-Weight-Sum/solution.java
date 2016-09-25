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
        if(nestedList == null || nestedList.size() == 0){
            return 0;
        }
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        int result = 0;
        int level = 0;
        queue.offer(nestedList);
        while(!queue.isEmpty()){
            level ++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                List<NestedInteger> cur = queue.poll();
                for(NestedInteger ni : cur){
                    if(ni.isInteger()){
                        result += level * ni.getInteger();
                    }else{
                        queue.offer(ni.getList());
                    }
                }
            }
        }
        return result;
    }
}