package cc.robotdreams.lesson21;

import org.testng.annotations.Test;

public class TestExample2 extends BaseTest
{
    @Test(testName = "Test example 2 test name", groups = "smoke")
    public void test() {
        System.out.println("Test example 2");
    }
}
