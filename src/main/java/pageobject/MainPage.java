package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    // Главная страница
    private static final String MAIN_URL = "https://demoqa.com/";

    // Блок Elements
    private static final By ELEMENTS_BUTTON = By.xpath(".//div[@class='category-cards']/div[1]");

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на сайт https://demoqa.com/")
    public void openPage() {
        driver.get(MAIN_URL);
    }

    @Step("Нажать на блок «Elements»")
    public void clickElementsButton() {
        WebElement element = driver.findElement(ELEMENTS_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }


}
