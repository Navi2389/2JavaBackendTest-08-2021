import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
public class MathUtilTest {

    int a, b, c;

    public MathUtilTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }


    @Parameterized.Parameters(name = "{index}:sumOf({0}+{1})={2}")
    public static Iterable<Object[]> dataForTest() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {2, 6, 8},
                {18, 2, 20},
                {13, 15, 28},
                {1, 5, 6}
        });
    }
        @BeforeEach
        void setUp() {
//            a = getRandomInt(10, 100);
//            b = getRandomInt(10, 100);
        }

        @AfterEach
        void tearDown () {
        }

        @Test
        public void sumTest () {
            int actually = MathUtil.sum(a, b);
            int expected = a + b;
            assertEquals(c, actually);

        }

        private int getRandomInt ( int from, int to){
            int length = abs(to - from); //abs это берем по модулю
            return (int) (from + Math.random() * length);
        }

    }