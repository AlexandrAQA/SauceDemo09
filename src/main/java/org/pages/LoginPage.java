package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "h3[data-test=error]")
    private WebElement errorMessage;

    public void open() {
        driver.get(SAUCE_DEMO_URL);
    }

    public void login(String user, String password) {
        usernameInput.sendKeys(user);
        passwordInput.sendKeys(password);
        loginButton.submit();
    }

    public void loginAsValidUser() {
        login("standard_user", "secret_sauce");
    }

    public String getError() {
        return errorMessage.getText();
    }
}