package business;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasePage {
    @Step("{0}")
    public static void executeStep(String message) {
        log.info(message);
    }
}