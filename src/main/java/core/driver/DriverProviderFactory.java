package core.driver;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

public class DriverProviderFactory {
    public static void setBrowserAs(String currentBrowser) {
        switch (currentBrowser) {
            case "firefox":
                Configuration.browser = Browsers.FIREFOX;
                break;
            case "opera":
                Configuration.browser = Browsers.OPERA;
                break;
            case "edge":
                Configuration.browser = Browsers.EDGE;
                break;
            case "safari":
                Configuration.browser = Browsers.SAFARI;
                break;
            case "chrome":
                Configuration.browser = Browsers.CHROME;
                break;
        }
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.pageLoadTimeout=120000;
    }
}
