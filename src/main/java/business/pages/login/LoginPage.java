package business.pages.login;

import business.BasePage;
import business.pages.home.InventoryPage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static core.data.ErrorMessagesData.*;

public class LoginPage extends BasePage {
    private static final String LOGIN_URL = "https://www.saucedemo.com";

    private SelenideElement getUserNameInput() {
        return $("#user-name");
    }

    private SelenideElement getPasswordInput() {
        return $("#password");
    }

    private SelenideElement getLoginButton() {
        return $("#login-button");
    }


    private SelenideElement getCredentialsErrorField() {
        return $(".error-message-container");
    }

    public LoginPage openLoginUrl() {
        executeStep("Open login page");
        open(LOGIN_URL);
        return this;
    }

    public LoginPage clickOnLoginButton() {
        executeStep("Click on Login button");
        getLoginButton().click();
        return this;
    }

    public LoginPage setUserName(String username) {
        executeStep("Set username");
        getUserNameInput().setValue(username);
        return this;
    }

    public InventoryPage enterLoginData(String username, String password) {
        openLoginUrl();
        if(!new InventoryPage().getPageTitleField().isDisplayed()) {
            executeStep("Enter login data");
            getUserNameInput().setValue(username);
            getPasswordInput().setValue(password);
            clickOnLoginButton();
        }
        return new InventoryPage();
    }

    public void verifyUserNameError() {
        executeStep("Verify username error message");
        getCredentialsErrorField().shouldHave(text(USERNAME_IS_REQUIRED_ERROR));
    }

    public void verifyPasswordError() {
        executeStep("Verify password error message");
        getCredentialsErrorField().shouldHave(text(PASSWORD_IS_REQUIRED_ERROR));
    }
}