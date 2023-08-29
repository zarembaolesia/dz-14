package cc.robotdreams.lessons.lesson27;

import cc.robotdreams.automation.base.BaseGUITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URI;

public class WebElementExamplesTest extends BaseGUITest
{



    @Test
    public void example1() throws Throwable {
        this.wd().get(
                new URI(this.wd().getCurrentUrl())
                        .resolve("/index.php?route=account/register").toString()
        );
        WebElement firstName        = this.wd().findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName         = this.wd().findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email            = this.wd().findElement(By.xpath("//input[@id='input-email']"));
        WebElement password         = this.wd().findElement(By.xpath("//input[@id='input-password']"));
        WebElement newsLetter       = this.wd().findElement(By.xpath("//input[@id='input-newsletter']"));
        WebElement continueButton   = this.wd().findElement(By.xpath("//form[@id='form-register']//button[@type='submit']"));

        firstName.clear();
        firstName.sendKeys("ABCD");
        firstName.clear();
        firstName.sendKeys("MyFirstName");
        lastName.sendKeys("MyLastName");
        email.sendKeys("testWrongEmailAddress");
        password.sendKeys("12345");
        newsLetter.click();

        continueButton.click();

        System.out.println(firstName.getAttribute("placeholder") + ": " + firstName.getAttribute("value"));
        System.out.println(lastName.getAttribute("placeholder") + ":  " + lastName.getAttribute("value"));
        System.out.println(email.getAttribute("placeholder") + ":      " + email.getAttribute("value"));
        System.out.println("Newsletter:      " + (newsLetter.isSelected() ? "ON" : "OFF"));

        String enabled      = continueButton.isEnabled() ? "Enabled" : "Disabled";
        String displayed    = continueButton.isDisplayed() ? "Displayed" : "Hidden";

        System.out.println("Continue button: " + enabled + " " + displayed );
    }

    @Test
    public void checkDefaultValuesOnRegistrationPage() throws Throwable {
        this.wd().get(
                new URI(this.wd().getCurrentUrl())
                        .resolve("/index.php?route=account/register").toString()
        );
        WebElement firstName        = this.wd().findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName         = this.wd().findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email            = this.wd().findElement(By.xpath("//input[@id='input-email']"));
        WebElement password         = this.wd().findElement(By.xpath("//input[@id='input-password']"));
        WebElement newsLetter       = this.wd().findElement(By.xpath("//input[@id='input-newsletter']"));
        WebElement policyAgree      = this.wd().findElement(By.xpath("//form[@id='form-register']//input[@name='agree']"));
        WebElement continueButton   = this.wd().findElement(By.xpath("//form[@id='form-register']//button[@type='submit']"));

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(firstName.getAttribute("placeholder"), "First Name", "First name placeholder is wrong");
        soft.assertEquals(firstName.getAttribute("value"), "", "First name default value is wrong");
        soft.assertEquals(lastName.getAttribute("placeholder"), "Last Name", "Last name placeholder is wrong");
        soft.assertEquals(lastName.getAttribute("value"), "", "Last name default value is wrong");
        soft.assertEquals(email.getAttribute("placeholder"), "E-Mail", "Email placeholder is wrong");
        soft.assertEquals(email.getAttribute("value"), "", "Email default value is wrong");
        soft.assertEquals(password.getAttribute("placeholder"), "Password", "Password placeholder is wrong");
        soft.assertEquals(password.getAttribute("value"), "", "Password default value is wrong");

        soft.assertFalse(newsLetter.isSelected(),   "Newsletter must not be selected by default");
        soft.assertFalse(policyAgree.isSelected(),  "Policy agree must not be selected by default");

        soft.assertTrue(continueButton.isDisplayed(),   "Continue button is not displayed");
        soft.assertTrue(continueButton.isEnabled(),     "Continue button is not enabled");

        soft.assertAll();
    }
}
