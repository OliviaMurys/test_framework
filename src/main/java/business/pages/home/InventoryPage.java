package business.pages.home;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static business.BasePage.executeStep;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class InventoryPage {
    public SelenideElement getPageTitleField() {
        return $(".title");
    }

    private SelenideElement getAddSpecificProductBlock(String productName) {
        return $x(format("//*[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item_description']", productName));
    }

    private SelenideElement getAddSpecificProductButton(String productName) {
        return getAddSpecificProductBlock(productName).find(By.xpath(".//*[contains(@name,'add-to-cart')]"));
    }

    private SelenideElement getRemoveSpecificProductButton(String productName) {
        return getAddSpecificProductBlock(productName).find(By.xpath(".//*[contains(@name,'remove')]"));
    }

    private SelenideElement getNumberOfProductInCart() {
        return $(".shopping_cart_badge");
    }

    public InventoryPage addProductToCart(String productName) {
        executeStep("Add product to cart");
        getAddSpecificProductButton(productName).click();
        return this;
    }

    public InventoryPage removeProductFromCart(String productName) {
        executeStep("Remove product from cart");
        getRemoveSpecificProductButton(productName).click();
        return this;
    }

    public InventoryPage verifyProductNumberInCart(String num) {
        executeStep("Verify product number in cart");
        getNumberOfProductInCart().shouldHave(text(num));
        return this;
    }

    public InventoryPage verifyCartIsEmpty() {
        executeStep("Verify cart is empty");
        getNumberOfProductInCart().shouldNotBe(visible);
        return this;
    }

    public InventoryPage verifyLoginWasSuccessful() {
        executeStep("verify login was successful");
        getPageTitleField().shouldHave(text("Products"));
        return this;
    }
}
