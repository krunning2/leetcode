class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack2.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(stack1.isEmpty()){
            swap();
        }
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        if(stack1.isEmpty()){
            swap();
        }
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    private void swap(){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
}