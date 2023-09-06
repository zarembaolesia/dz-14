package cc.robotdreams.lessons.lesson28;

import cc.robotdreams.automation.Session;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class DemoQATest
{
    @Test
    public void DynamicClickMessagePresent() {
        Session.get().webdriver().get("https://demoqa.com/elements");
        try {
            WebElement buttons = Session.get().webdriver().findElement(By.xpath("//li[@id='item-4'][.//span[text()='Buttons']]"));
            buttons.click();

            WebElement clickMeButton = Session.get().webdriver().findElement(By.xpath("//button[text()='Click Me']"));
            clickMeButton.click();

            SoftAssert soft = new SoftAssert();
            soft.assertEquals(Session.get().webdriver().getCurrentUrl(), "https://demoqa.com/buttons");
            WebElement textCheck = Session.get().webdriver().findElement(By.xpath("//button[text()='Click Me']/../following-sibling::p/text()"));
            soft.assertEquals(textCheck, "You have done a dynamic click");
            System.out.println(textCheck);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Session.get().webdriver().quit();
        }
    }
    @Test
    public void AddingRecordsWorks() {
        Session.get().webdriver().get("https://demoqa.com/webtables");
        try {
            WebElement addButton = Session.get().webdriver().findElement(By.xpath("//li[@id='item-4'][.//span[text()='Add']]"));
            addButton.click();

            WebElement firstName = Session.get().webdriver().findElement(By.xpath("//*[@id=\"firstName\"]"));
            firstName.sendKeys("Jess");

            WebElement lastName = Session.get().webdriver().findElement(By.xpath("//*[@id=\"lastName\"]"));
            lastName.sendKeys("Blanshe");

            WebElement email = Session.get().webdriver().findElement(By.xpath("//*[@id=\"userEmail\"]"));
            email.sendKeys("asdfwfq@gmail.com");

            WebElement age = Session.get().webdriver().findElement(By.xpath("//*[@id=\"age\"]"));
            age.sendKeys("40");

            WebElement salary = Session.get().webdriver().findElement(By.xpath("//*[@id=\"salary\"]"));
            salary.sendKeys("3000");

            WebElement department = Session.get().webdriver().findElement(By.xpath("//*[@id=\"department\"]"));
            department.sendKeys("Finance");

            WebElement submitButton = Session.get().webdriver().findElement(By.xpath("//*[@id=\"submit\"]"));
            submitButton.click();

            SoftAssert soft = new SoftAssert();
            WebElement firstNameRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[1]/text()"));
            WebElement lastNameRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[2]/text()"));
            WebElement emailRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[3]/text()"));
            WebElement ageRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[4]/text()"));
            WebElement salaryRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[5]/text()"));
            WebElement departmentRecord = Session.get().webdriver().findElement(By.xpath("//div[div[contains(text(), 'Jess')]]/*[6]/text()"));

            soft.assertEquals(firstNameRecord, "Jess");
            soft.assertEquals(lastNameRecord, "Blanshe");
            soft.assertEquals(emailRecord, "asdfwfq@gmail.com");
            soft.assertEquals(ageRecord, "40");
            soft.assertEquals(salaryRecord, "3000");
            soft.assertEquals(departmentRecord, "Finance");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Session.get().webdriver().quit();
        }
    }
}