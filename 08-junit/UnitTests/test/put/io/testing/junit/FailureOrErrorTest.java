package put.io.testing.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FailureOrErrorTest {

    @Test
    public void test1() {
        assertTrue(1 == 0);
    }

    @Test
    public void test2() {
        int result = 5 / 0;
    }

    @Test
    public void test3() {
        try {
            assertTrue(1 == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
