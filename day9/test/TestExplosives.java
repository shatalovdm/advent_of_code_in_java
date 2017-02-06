import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Day 9: Explosives in Cyberspace
 *
 * http://adventofcode.com/2016/day/9
 */
public class TestExplosives {
    @Test
    public void testDecompressV1() {
        Assert.assertEquals(7, new Explosives().decompressV1(new String[]{"A(1x5)BC"}));
        Assert.assertEquals(9, new Explosives().decompressV1(new String[]{"(3x3)XYZ"}));
        Assert.assertEquals(6, new Explosives().decompressV1(new String[]{"ADVENT"}));
        Assert.assertEquals(11, new Explosives().decompressV1(new String[]{"A(2x2)BCD(2x2)EFG"}));
        Assert.assertEquals(6, new Explosives().decompressV1(new String[]{"(6x1)(1x3)A"}));
        Assert.assertEquals(18, new Explosives().decompressV1(new String[]{"X(8x2)(3x3)ABCY"}));
    }
    @Test
    public void testDecompressV2() {
        Assert.assertEquals(new BigInteger("7"), new Explosives().decompressV2(new String[]{"A(1x5)BC"}));
        Assert.assertEquals(new BigInteger("20"), new Explosives().decompressV2(new String[]{"X(8x2)(3x3)ABCY"}));
        Assert.assertEquals(new BigInteger("6"), new Explosives().decompressV2(new String[]{"ADVENT"}));
        Assert.assertEquals(new BigInteger("445"), new Explosives().decompressV2(new String[]{"(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN"}));
    }
}
