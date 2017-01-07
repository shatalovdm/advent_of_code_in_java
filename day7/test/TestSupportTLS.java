import org.junit.Assert;
import org.junit.Test;

/**
 * Day 7: Internet Protocol Version 7
 *
 * http://adventofcode.com/2016/day/7
 */
public class TestSupportTLS {
    @Test
    public void testSupportTLS() {
        Assert.assertEquals(2, new IPSupport().supportTLS("abba[mnop]qrst\n" +
                "abcd[bddb]xyyx\n" +
                "aaaa[qwer]tyui\n" +
                "ioxxoj[asdfgh]zxcvbn"));
    }
    @Test
    public void testSupportSSL() {
        Assert.assertEquals(3, new IPSupport().supportSSL("aba[bab]xyz\n" +
                "xyx[xyx]xyx\n" +
                "aaa[kek]eke\n" +
                "zazbz[bzb]cdb"));
    }
}
