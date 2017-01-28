
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Day 8: Two-Factor Authentication.
 *
 * http://adventofcode.com/2016/day/8
 */
public class TestAuthentication {
    @Test
    public void testRect() {
        try {
            new Authentication().rect(6,60);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("50"));
        }
    }
    @Test
    public void testRotateRow() {
        try {
            new Authentication().rotateRow(8,5);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("8"));
        }
    }
    @Test
    public void testRotateColumn() {
        try {
            new Authentication().rotateColumn(51, 5);
            fail("Expected an IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
            assertThat(anIndexOutOfBoundsException.getMessage(), is("51"));
        }
    }
    @Test
    public void testDisplayScreen() {
        Authentication screen = new Authentication();
        screen.rect(4,4);
        Assert.assertEquals(16,screen.displayScreen());
        screen.rect(4,12);
        Assert.assertEquals(48,screen.displayScreen());
    }
}
