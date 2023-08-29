package cc.robotdreams.lessons.lesson26;

import cc.robotdreams.automation.Session;
import cc.robotdreams.automation.base.BaseGUITest;
import cc.robotdreams.automation.utils.Sleep;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstGUITest extends BaseGUITest
{
    @Test(groups="lesson26")
    public void testExample() {
        // Do something
        System.out.println("Okay test1");
        Session.get().webdriver().findElement(By.xpath("//button[@data-bs-toggle=\"dropdown\"]")).click();
        Sleep.sleep(5000);
    }

    @Test(groups="lesson26")
    public void testExample2() {
        // Do something
        System.out.println("Okay test2");
    }
}
