class Queue {
    Node front; // Phần tử đầu tiên (Front)
    Node rear;  // Phần tử cuối cùng (Rear)

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    // Thêm phần tử vào hàng đợi
    public void enQueue(int data) {
        Node newNode = new Node(data); // B1: Tạo node mới
        if (front == null) { // B2: Kiểm tra nếu hàng đợi trống
            front = newNode;
            rear = newNode;
            newNode.link = front; // Liên kết rear tới front
        } else {
            rear.link = newNode; // Gán rear trỏ đến node mới
            rear = newNode;      // Rear trở thành node mới
            rear.link = front;   // Rear luôn trỏ tới front
        }
    }

    // Lấy phần tử ra khỏi hàng đợi
    public int deQueue() {
        if (front == null) { // B1: Kiểm tra hàng đợi trống
            System.out.println("Hàng đợi rỗng!");
            return -1;
        }

        int value; // Lưu giá trị của phần tử được lấy ra

        if (front == rear) { // B3: Kiểm tra nếu chỉ có 1 phần tử
            value = front.data;
            front = null;
            rear = null;
        } else {
            value = front.data;      // Lấy giá trị của front
            front = front.link;      // Front trỏ đến node tiếp theo
            rear.link = front;       // Rear trỏ lại node mới của front
        }

        return value; // Trả về giá trị đã lấy ra
    }

    // Hiển thị hàng đợi
    public void displayQueue() {
        if (front == null) { // Kiểm tra hàng đợi trống
            System.out.println("Hàng đợi rỗng!");
            return;
        }

        Node temp = front;
        System.out.print("Các phần tử trong hàng đợi: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.link;
        } while (temp != front); // Duyệt vòng tròn
        System.out.println();
    }
}