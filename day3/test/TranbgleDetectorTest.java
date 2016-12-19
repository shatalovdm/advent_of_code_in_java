import org.junit.Assert;
import org.junit.Test;

/**
 * Day 3: Squares With Three Sides
 *
 * Challenge: http://adventofcode.com/2016/day/3
 */
public class TranbgleDetectorTest {
    @Test
    public void testTriangleDetector() {
        Assert.assertEquals(0, new TriangleDetector().detectTriangles1("5 10 25"));
        Assert.assertEquals(1, new TriangleDetector().detectTriangles1("20 10 25"));

    }
}
