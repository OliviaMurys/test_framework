package tests.login;

import org.testng.annotations.Test;
import tests.BaseTest;

import static core.data.UserCredentialsData.*;

public class LoginTest extends BaseTest {
    @Test(description = "Check user is not able to login without username", priority = 1)
    public void checkUserIsNotAbleToLoginWithoutUsernameNegativeCase() {
        loginPage
                .openLoginUrl()
                .clickOnLoginButton()
                .verifyUserNameError();
    }

    @Test(description = "Check user is not able to login without password", priority = 2)
    public void checkUserIsNotAbleToLoginWithoutPasswordNegativeCase() {
        loginPage
                .setUserName(USER_NAME)
                .clickOnLoginButton()
                .verifyPasswordError();
    }

    @Test(description = "Check login is successful", priority = 3)
    public void checkLoginIsSuccessfulPositiveCase() {
        loginPage
                .enterLoginData(USER_NAME, USER_PASSWORD)
                .verifyLoginWasSuccessful();
    }
}
