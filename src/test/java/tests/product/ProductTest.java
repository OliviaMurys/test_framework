package tests.product;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.BaseTest;

import static core.data.UserCredentialsData.USER_NAME;
import static core.data.UserCredentialsData.USER_PASSWORD;

public class ProductTest extends BaseTest {

    @BeforeTest()
    public void login() {
        loginPage
                .enterLoginData(USER_NAME, USER_PASSWORD)
                .verifyLoginWasSuccessful();
    }

    @Test(description = "Check user is  able to add specific product to cart", priority = 1)
    public void checkUserIsAbleToAddSpecificProductToCart() {
        inventoryPage
                .addProductToCart("Sauce Labs Backpack")
                .verifyProductNumberInCart("1");
    }

    @Test(description = "Check user is  able to remove specific product form cart", priority = 2)
    public void checkUserIsAbleToRemoveSpecificProductFromCart() {
        inventoryPage
                .removeProductFromCart("Sauce Labs Backpack")
                .verifyCartIsEmpty();
    }
}
