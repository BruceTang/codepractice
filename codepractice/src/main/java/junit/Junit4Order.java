package junit;

import org.junit.*;

public class Junit4Order {

    public static int i = 0;

    @BeforeClass
    public static void beforeClass() {
        i = i + 1;
        System.out.println("BeforeClass-第" + i + "顺序->");
    }

    @Before
    public void before() {
        i = i + 1;
        System.out.println("Before-第" + i + "顺序->");
    }

    @Test
    public void test() {
        i = i + 1;
        System.out.println("Test-第" + i + "顺序->");
    }

    @After
    public void after() {
        i = i + 1;
        System.out.println("After-第" + i + "顺序->");
    }

    @AfterClass
    public static void afterClass() {
        i = i + 1;
        System.out.println("AfterClass-第" + i + "顺序->");
    }
}
