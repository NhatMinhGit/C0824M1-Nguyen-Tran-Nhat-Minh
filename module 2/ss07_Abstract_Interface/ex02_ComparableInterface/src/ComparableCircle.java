public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
//    1. Không thể sử dụng ComparableCircle trong các API yêu cầu Comparable
//    Các API trong Java như Collections.sort() hoặc Arrays.sort() yêu cầu các đối tượng được sắp xếp phải triển khai
//    giao diện Comparable. Nếu lớp ComparableCircle không triển khai Comparable, bạn sẽ gặp lỗi khi sử dụng các
//
//    2. Phương thức compareTo không được bảo đảm thực thi đúng giao diện
//    Khi không triển khai Comparable, phương thức compareTo chỉ là một phương thức tùy ý trong lớp của bạn, không bắt buộc phải tuân theo chữ ký (signature)
//
//    3. Mất tính nhất quán trong lập trình
//    Việc triển khai Comparable là một cách khai báo rõ ràng rằng lớp này hỗ trợ so sánh. Điều này giúp mã dễ đọc và dễ hiểu hơn trong các dự án lớn.
//    Nếu bỏ implements Comparable<ComparableCircle>, sẽ khó biết liệu lớp có hỗ trợ so sánh hay không trừ khi bạn đọc toàn bộ mã nguồn.
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }


    //Định nghĩa làm hàm compareTo trong thư viện để có kết quả theo mong muốn
    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 0;
    }
}