import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Shatalov on 16/12/16.
 */
public class TranbgleDetectorTest {
    @Test
    public void testTriangleDetector() {
        Assert.assertEquals(0, new TriangleDetector().detectTriangles1("5 10 25"));
        Assert.assertEquals(1, new TriangleDetector().detectTriangles1("20 10 25"));

    }
}
