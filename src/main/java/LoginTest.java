import by.issoft.mandrik.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {
    private LoginSteps steps;
    private final static String USERNAME = "seleniumtests10@mail.ru";
    private final static String PASSWORD = "060788avavav";

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new LoginSteps();
        steps.initBrowser();
    }

    @Test(description = "Login to mail.ru")
    public void loginToMailRu() {
        steps.login(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME), "user is not logged in");
    }

    @Test(description = "Logout from mail.ru")
    public void logoutFromMailRu() {
        steps.logout();
        Assert.assertTrue(steps.isLoggedOut(), "user is not logged out");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
