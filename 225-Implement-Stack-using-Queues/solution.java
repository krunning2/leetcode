class MyStack {
    // Push element x onto stack.
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.pop();
    }

    // Get the top element.
    public int top() {
        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
    
}