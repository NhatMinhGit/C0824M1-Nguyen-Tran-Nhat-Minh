import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> productList;

    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    // Thêm sản phẩm
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Sửa thông tin sản phẩm theo ID
    public boolean updateProductById(int id, String newName, double newPrice) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setTen(newName);
                product.setGia(newPrice);
                return true; // Sửa thành công
            }
        }
        return false; // Không tìm thấy sản phẩm
    }

    // Xóa sản phẩm theo ID
    public boolean deleteProductById(int id) {
        return productList.removeIf(product -> product.getId() == id);
    }

    // Hiển thị danh sách sản phẩm
    public void displayProducts() {
        for (Product product : productList) {
            System.out.println("Mã: " + product.getId() + ", Tên: " + product.getTen() + ", Giá: " + product.getGia());
        }
    }

    // Tìm kiếm sản phẩm theo tên
    public List<Product> searchProductByName(String name) {
        List<Product> results = new ArrayList<>();
        for (Product product : productList) {
            if (product.getTen().toLowerCase().contains(name.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }

    // Sắp xếp sản phẩm tăng dần theo giá
    public void sortProductsByPriceAscending() {
        productList.sort(Comparator.comparingDouble(Product::getGia));
    }

    // Sắp xếp sản phẩm giảm dần theo giá
    public void sortProductsByPriceDescending() {
        productList.sort(Comparator.comparingDouble(Product::getGia).reversed());
    }
}
