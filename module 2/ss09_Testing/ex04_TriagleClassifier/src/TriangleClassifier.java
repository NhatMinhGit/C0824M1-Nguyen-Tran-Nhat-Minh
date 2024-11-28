public class TriangleClassifier {

    // Phân loại tam giác
    public String classifyTriangle(int side1, int side2, int side3) {
        // Kiểm tra nếu các cạnh không tạo thành tam giác
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            return "Không phải là tam giác";
        }

        // Kiểm tra nếu các cạnh không thỏa mãn bất kỳ định lý tam giác nào
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            return "Không phải là tam giác";
        }

        // Kiểm tra tam giác đều
        if (side1 == side2 && side2 == side3) {
            return "Tam giác đều";
        }

        // Kiểm tra tam giác cân
        if (side1 == side2 || side1 == side3 || side2 == side3) {
            return "Tam giác cân";
        }

        // Tam giác thường
        return "Tam giác thường";
    }
}
