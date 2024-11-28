import org.junit.Test;
import static org.junit.Assert.*;

public class TriangleClassifierTest {

    @Test
    public void testEquilateralTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("Tam giác đều", classifier.classifyTriangle(3, 3, 3));
    }

    @Test
    public void testIsoscelesTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("Tam giác cân", classifier.classifyTriangle(3, 3, 4));
        assertEquals("Tam giác cân", classifier.classifyTriangle(5, 5, 8));
    }

    @Test
    public void testScaleneTriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("Tam giác thường", classifier.classifyTriangle(3, 4, 5));
    }

    @Test
    public void testNotATriangle() {
        TriangleClassifier classifier = new TriangleClassifier();
        assertEquals("Không phải là tam giác", classifier.classifyTriangle(1, 1, 3));
        assertEquals("Không phải là tam giác", classifier.classifyTriangle(0, 1, 2));
        assertEquals("Không phải là tam giác", classifier.classifyTriangle(-1, 2, 3));
    }
}
