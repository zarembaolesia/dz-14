package cc.robotdreams.lessons.lesson28;

import cc.robotdreams.automation.app.IndexPage;
import cc.robotdreams.automation.app.RegistrationPage;
import cc.robotdreams.automation.base.BaseGUITest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PageObjectExampleTest extends BaseGUITest
{
    @Test
    public void checkDefaultValuesOnRegistrationPage() throws Throwable {
        IndexPage        indexPage = new IndexPage();
        RegistrationPage registrationPage = indexPage.goToRegistrationPage();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(registrationPage.firstName.getAttribute("placeholder"), "First Name", "First name placeholder is wrong");
        soft.assertEquals(registrationPage.firstName.getAttribute("value"), "", "First name default value is wrong");
        soft.assertEquals(registrationPage.lastName.getAttribute("placeholder"), "Last Name", "Last name placeholder is wrong");
        soft.assertEquals(registrationPage.lastName.getAttribute("value"), "", "Last name default value is wrong");
        soft.assertEquals(registrationPage.email.getAttribute("placeholder"), "E-Mail", "Email placeholder is wrong");
        soft.assertEquals(registrationPage.email.getAttribute("value"), "", "Email default value is wrong");
        soft.assertEquals(registrationPage.password.getAttribute("placeholder"), "Password", "Password placeholder is wrong");
        soft.assertEquals(registrationPage.password.getAttribute("value"), "", "Password default value is wrong");
        soft.assertFalse(registrationPage.newsLetter.isSelected(),   "Newsletter must not be selected by default");
        soft.assertFalse(registrationPage.policyAgree.isSelected(),  "Policy agree must not be selected by default");

        soft.assertTrue(registrationPage.continueButton.isDisplayed(),   "Continue button is not displayed");
        soft.assertTrue(registrationPage.continueButton.isEnabled(),     "Continue button is not enabled");

        soft.assertAll();
    }
}
