package cc.robotdreams.automation.base;

import cc.robotdreams.automation.Session;
import org.openqa.selenium.WebDriver;

public class BasePageObject
{
    protected WebDriver wd() {
        return Session.get().webdriver();
    }
}
