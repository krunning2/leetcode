/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;
    TreeNode res;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode> ();
        cur = root;
    }

    /** @return the next smallest number */
    public int next() {
        return res.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            res = stack.pop();
            cur = res.right;
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */