class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack2.isEmpty()){
            dump();
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        if(stack2.isEmpty()){
            dump();
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        
    }
    private void dump(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
}