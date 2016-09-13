class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    int peek = 0;
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
        peek = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 1){
            peek = q1.poll();
            q2.offer(peek);
        }
        q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // Get the top element.
    public int top() {
        return peek;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}