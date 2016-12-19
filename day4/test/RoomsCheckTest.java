import org.junit.Assert;
import org.junit.Test;

/**
 * Day 4: Security Through Obscurity
 *
 * Challenge: http://adventofcode.com/2016/day/4
 */
public class RoomsCheckTest {
    @Test
    public void testCheckRooms() {
        Assert.assertEquals(1514, new RoomsCheck().checkRooms("aaaaa-bbb-z-y-x-123[abxyz]\n" +
                "a-b-c-d-e-f-g-h-987[abcde]\n" + "not-a-real-room-404[oarel]\n" + "totally-real-room-200[decoy]\n"));
    }
    @Test
    public void testDecrypt() {
        Assert.assertEquals(343, new RoomsCheck().decrypt("qzmt-zixmtkozy-ivhz-343[weew]", "very encrypted name"));
    }
}