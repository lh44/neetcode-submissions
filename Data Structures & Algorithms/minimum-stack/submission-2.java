class MinStack {

    private Node head;
    private Node min;
    private final Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node(val);
            if (minStack.isEmpty() || val < minStack.peek()) {
                minStack.push(val);
            }
            return;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (head == null) return;
        Node val = head;
        head = head.next;
        if (val.val == minStack.peek()) {
            minStack.pop();
        }
    }
    
    public int top() {
        if (head == null) return 0;
        return head.val;
    }
    
    public int getMin() {
        return minStack.peek();
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
