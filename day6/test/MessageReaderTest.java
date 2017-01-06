import org.junit.Assert;
import org.junit.Test;

/**
 * Day 6: Signals and Noise
 *
 * http://adventofcode.com/2016/day/6
 */
public class MessageReaderTest {
    @Test
    public void testReadMessage() {
        Assert.assertEquals(new String[]{"easter", "advent"}, new MessageReader().readMessage("eedadn\n" +
                "drvtee\n" +
                "eandsr\n" +
                "raavrd\n" +
                "atevrs\n" +
                "tsrnev\n" +
                "sdttsa\n" +
                "rasrtv\n" +
                "nssdts\n" +
                "ntnada\n" +
                "svetve\n" +
                "tesnvt\n" +
                "vntsnd\n" +
                "vrdear\n" +
                "dvrsen\n" +
                "enarar"));
    }
}
