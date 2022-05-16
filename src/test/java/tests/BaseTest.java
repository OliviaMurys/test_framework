package tests;

import business.pages.home.InventoryPage;
import business.pages.login.LoginPage;
import core.driver.DriverProviderFactory;
import org.testng.annotations.BeforeSuite;

import static core.driver.DriverProviderFactory.setBrowserAs;

public class BaseTest {
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    protected DriverProviderFactory driverProviderFactory;

    public BaseTest() {
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage();
        driverProviderFactory = new DriverProviderFactory();
    }

    @BeforeSuite
    public void setUp() {
        String currentBrowser = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        setBrowserAs(currentBrowser);
    }
}
