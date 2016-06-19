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
public class NestedIterator implements Iterator<Integer> {
    Iterator<NestedInteger> iterator;
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        iterator = nestedList.iterator();
        stack = new Stack<NestedInteger>();
    }

    @Override
    public Integer next() {
        while(iterator.hasNext() || !stack.isEmpty()){
            if(!iterator.hasNext()){
               iterator = stack.pop(); 
            }
            NestedInteger cur = iterator.next();
            if(!cur.isInteger){
                stack.push(iterator);
                iterator = cur.getList().iterator();
            }else{
                return cur.getInteger();
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || !stack.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */