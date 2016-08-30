public class MinStack {
    Stack<Integer> min;
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        min = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }
    
    public void pop() {
        int x = stack.pop();
        if(x == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */