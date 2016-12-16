import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Shatalov on 15/12/16.
 */
public class DecoderTest {
    @Test
    public void testDecode() {
        Assert.assertEquals("1985", new Decoder().decode1("ULL\n" +
                "RRDDD\n" +
                "LURDL\n" +
                "UUUUD"));
        Assert.assertEquals("5DB3", new Decoder().decode2("ULL\n" +
                "RRDDD\n" +
                "LURDL\n" +
                "UUUUD"));
    }
}
