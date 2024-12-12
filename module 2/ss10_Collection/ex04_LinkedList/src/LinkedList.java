public class LinkedList<E> {
    private Node head;
    private int numNodes = 0;

    // Constructor khởi tạo danh sách trống
    public LinkedList() {}

    // Constructor với phần tử đầu tiên
    public LinkedList(E element) {
        head = new Node(element);
        numNodes++;
    }

    // Thêm một phần tử tại vị trí chỉ định
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node temp = head;
        Node holder;

        // Nếu thêm tại vị trí đầu
        if (index == 0) {
            addFirst(element);
        } else {
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    // Thêm phần tử vào đầu danh sách
    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    // Thêm phần tử vào cuối danh sách
    public void addLast(E element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(element);
            numNodes++;
        }
    }

    // Xóa phần tử tại vị trí chỉ định
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node temp = head;

        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.data;
        } else {
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            Node toRemove = temp.next;
            temp.next = toRemove.next;
            numNodes--;
            return (E) toRemove.data;
        }
    }

    // Xóa phần tử theo giá trị
    public boolean remove(Object o) {
        if (head == null) return false;

        if (head.data.equals(o)) {
            head = head.next;
            numNodes--;
            return true;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(o)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Truy cập phần tử tại vị trí index
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    // Trả về phần tử đầu tiên
    public E getFirst() {
        if (head == null) {
            return null;
        }
        return (E) head.data;
    }

    // Trả về phần tử cuối cùng
    public E getLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    // Trả về số lượng phần tử
    public int size() {
        return numNodes;
    }

    // Kiểm tra phần tử có trong danh sách không
    public boolean contains(E o) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Tìm vị trí của phần tử
    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    // In danh sách
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
