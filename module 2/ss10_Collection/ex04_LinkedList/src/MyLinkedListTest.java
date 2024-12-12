public class MyLinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> myLinkedList = new LinkedList<>();

        // Thêm phần tử vào danh sách
        myLinkedList.addFirst("A");
        myLinkedList.addLast("B");
        myLinkedList.addLast("C");
        myLinkedList.add(1, "D");

        // In danh sách
        System.out.println("Danh sách ban đầu:");
        myLinkedList.printList();

        // Xóa phần tử
        myLinkedList.remove(1);
        System.out.println("Danh sách sau khi xóa phần tử tại vị trí 1:");
        myLinkedList.printList();

        // Kiểm tra phần tử
        System.out.println("Danh sách có chứa 'B' không? " + myLinkedList.contains("B"));

        // Lấy phần tử
        System.out.println("Phần tử đầu tiên: " + myLinkedList.getFirst());
        System.out.println("Phần tử cuối cùng: " + myLinkedList.getLast());

        // Tìm vị trí phần tử
        System.out.println("Vị trí của 'C': " + myLinkedList.indexOf("C"));

        // In số lượng phần tử
        System.out.println("Số lượng phần tử: " + myLinkedList.size());
    }
}
