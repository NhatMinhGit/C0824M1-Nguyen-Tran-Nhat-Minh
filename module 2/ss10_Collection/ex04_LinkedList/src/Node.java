class Node {
    Node next;
    Object data;

    // Constructor
    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }
}
