import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Thêm sản phẩm
        manager.addProduct(new Product(1, "Xoài", 100_000));
        manager.addProduct(new Product(2, "Dưa hấu", 110_000));
        manager.addProduct(new Product(3, "Dâu", 121_000));
        manager.addProduct(new Product(4, "Chuối", 130_000));

        // Hiển thị danh sách sản phẩm
        System.out.println("Danh sách sản phẩm ban đầu:");
        manager.displayProducts();

        // Sửa thông tin sản phẩm
        manager.updateProductById(2, "Dưa hấu không hạt", 120_000);

        // Xóa sản phẩm
        manager.deleteProductById(3);

        // Hiển thị danh sách sau khi sửa và xóa
        System.out.println("\nDanh sách sản phẩm sau khi sửa và xóa:");
        manager.displayProducts();

        // Tìm kiếm sản phẩm
        System.out.println("\nTìm kiếm sản phẩm có tên chứa 'Chuối':");
        List<Product> foundProducts = manager.searchProductByName("Chuối");
        for (Product product : foundProducts) {
            System.out.println("Mã: " + product.getId() + ", Tên: " + product.getTen() + ", Giá: " + product.getGia());
        }

        // Sắp xếp tăng dần theo giá
        manager.sortProductsByPriceAscending();
        System.out.println("\nDanh sách sản phẩm sắp xếp tăng dần theo giá:");
        manager.displayProducts();

        // Sắp xếp giảm dần theo giá
        manager.sortProductsByPriceDescending();
        System.out.println("\nDanh sách sản phẩm sắp xếp giảm dần theo giá:");
        manager.displayProducts();
    }
}
