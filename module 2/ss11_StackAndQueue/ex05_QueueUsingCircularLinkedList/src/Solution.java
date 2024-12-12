public class Solution {
    public static void main(String[] args) {
        Queue queue = new Queue();

        // Thực hiện thêm phần tử
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);

        // Hiển thị hàng đợi
        queue.displayQueue();

        // Thực hiện lấy phần tử
        System.out.println("Phần tử bị loại bỏ: " + queue.deQueue());
        System.out.println("Phần tử bị loại bỏ: " + queue.deQueue());

        // Hiển thị lại hàng đợi
        queue.displayQueue();

        // Thêm phần tử mới
        queue.enQueue(50);
        queue.enQueue(60);

        // Hiển thị hàng đợi cuối cùng
        queue.displayQueue();
    }
}