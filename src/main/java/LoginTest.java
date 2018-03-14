import by.issoft.mandrik.steps.LoginSteps;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private LoginSteps steps;
    private final String USERNAME = "seleniumtests10@mail.ru";
    private final String PASSWORD = "060788avavav";

    @BeforeClass(description = "Init browser")
    public void setUp() {
        steps = new LoginSteps();
        steps.initBrowser();
    }

    @Test(description = "Login to mail.ru")
    public void loginToMailRu() {
        steps.login(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description = "Login to mail.ru")
    public void logoutFromMailRu() {
        steps.logout();
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
