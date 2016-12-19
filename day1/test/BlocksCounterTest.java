import org.junit.Assert;
import org.junit.Test;

/**
 Day 1: No Time for a Taxicab

 Challenge: http://adventofcode.com/2016/day/1
 */
public class BlocksCounterTest {
    @Test
    public void testCountBlocks() {
        Assert.assertEquals(5, new BlocksCounter().countBlocks("R2, L3"));
        Assert.assertEquals(2, new BlocksCounter().countBlocks("R2, R2, R2"));
        Assert.assertEquals(12, new BlocksCounter().countBlocks("R5, L5, R5, R3"));
        Assert.assertEquals(0, new BlocksCounter().countBlocks("L2, L2, L2, L2"));
        Assert.assertEquals(16, new BlocksCounter().countBlocks("R4, R3, R5, L3, L5, R2, L2, R5, L2, R5, R5, R5"));
    }

}
