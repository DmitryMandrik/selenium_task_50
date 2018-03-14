package by.issoft.mandrik.steps;

import by.issoft.mandrik.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

import by.issoft.mandrik.pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;

    public void initBrowser() {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        DriverSingleton.closeDriver();
    }

    public void login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName();
        return actualUsername.equals(username);
    }

    public void logout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logout();
    }
}
