public class MyListTest {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        // Thêm phần tử
        myList.add("A");
        myList.add("B");
        myList.add("C");
        System.out.println("Danh sách sau khi thêm: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Thêm phần tử vào vị trí cụ thể
        myList.add(1, "D");
        System.out.println("Danh sách sau khi thêm D vào vị trí 1: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Xóa phần tử
        myList.remove(2);
        System.out.println("Danh sách sau khi xóa phần tử ở vị trí 2: ");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // Kiểm tra phần tử
        System.out.println("Danh sách có chứa B không? " + myList.contains("B"));
        System.out.println("Vị trí của A: " + myList.indexOf("A"));

        // Xóa toàn bộ danh sách
        myList.clear();
        System.out.println("Danh sách sau khi xóa toàn bộ: " + myList.size());
    }
}
