package by.issoft.mandrik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {
    private final String BASE_URL = "https://mail.ru";

    @FindBy(id = "mailbox:login")
    private WebElement inputLogin;

    @FindBy(id = "mailbox:password")
    private WebElement inputPassword;

    @FindBy(id = "mailbox:submit")
    private WebElement buttonSubmit;

    @FindBy(id = "PH_user-email")
    private WebElement linkLoggedInUser;

    @FindBy(id = "PH_logoutLink")
    private WebElement buttonLogOut;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
    }

    public void logout() {
        buttonLogOut.click();
    }

    public String getLoggedInUserName() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(linkLoggedInUser));
        return linkLoggedInUser.getText();
    }
}
