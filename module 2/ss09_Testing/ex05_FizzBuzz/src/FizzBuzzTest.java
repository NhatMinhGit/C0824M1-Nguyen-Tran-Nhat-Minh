import org.junit.Test;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void testFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3)); // Chia hết cho 3
        assertEquals("Fizz", fizzBuzz.fizzBuzz(6)); // Chia hết cho 3
        assertEquals("Fizz", fizzBuzz.fizzBuzz(13)); // Chứa số 3
    }

    @Test
    public void testBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5)); // Chia hết cho 5
        assertEquals("Buzz", fizzBuzz.fizzBuzz(10)); // Chia hết cho 5
        assertEquals("Buzz", fizzBuzz.fizzBuzz(25)); // Chứa số 5
    }

    @Test
    public void testFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15)); // Chia hết cho cả 3 và 5
    }

    @Test
    public void testNumberToWords() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        assertEquals("hai", fizzBuzz.fizzBuzz(2)); // Số đọc bằng chữ
        assertEquals("hai mươi sáu", fizzBuzz.fizzBuzz(26)); // Số đọc bằng chữ
    }

    @Test
    public void testInvalidInput() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        try {
            fizzBuzz.fizzBuzz(0); // Số không hợp lệ
            fail("Exception should be thrown for 0");
        } catch (IllegalArgumentException e) {
            assertEquals("Số phải lớn hơn 0 và nhỏ hơn 100", e.getMessage());
        }

        try {
            fizzBuzz.fizzBuzz(100); // Số không hợp lệ
            fail("Exception should be thrown for 100");
        } catch (IllegalArgumentException e) {
            assertEquals("Số phải lớn hơn 0 và nhỏ hơn 100", e.getMessage());
        }
    }
}
