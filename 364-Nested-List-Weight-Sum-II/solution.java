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
    public int depthSumInverse(List<NestedInteger> list) {
        if(list == null || list.size() == 0) return 0;
        int depth = getDepth(1, list);
        return getSum(depth, list);
    }
    private int getDepth(int curDepth, List<NestedInteger> list){
        int res = curDepth;
        for(NestedInteger ni : list){
            if(!ni.isInteger()){
                res = Math.max(res, getDepth(curDepth + 1, ni.getList()));
            }
        }
        return res;
    }
    private int getSum(int depth, List<NestedInteger> list){
        int res = 0;
        for(NestedInteger ni : list){
            if(!ni.isInteger()){
                res += getSum(depth - 1, ni.getList());
            }else{
                res += ni.getInteger() * depth;
            }
        }
        return res;
    }
}