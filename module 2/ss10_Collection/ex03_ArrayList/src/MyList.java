import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Constructor mặc định
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Constructor với dung lượng tùy chỉnh
    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }

    // Thêm phần tử vào cuối danh sách
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    // Thêm phần tử vào vị trí chỉ định
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Xóa phần tử tại chỉ mục
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return oldValue;
    }

    // Lấy phần tử tại vị trí chỉ định
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        return (E) elements[i];
    }

    // Xóa toàn bộ danh sách
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Kiểm tra danh sách có chứa phần tử hay không
    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    // Tìm chỉ mục của phần tử
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    // Đảm bảo dung lượng mảng
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // Sao chép danh sách
    public E clone() {
        MyList<E> clone = new MyList<>(size);
        clone.size = this.size;
        clone.elements = Arrays.copyOf(this.elements, size);
        return (E) clone;
    }

    // Trả về số lượng phần tử hiện tại
    public int size() {
        return size;
    }
}
