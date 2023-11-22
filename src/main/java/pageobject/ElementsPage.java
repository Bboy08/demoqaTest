package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage {
    // поле «Text Box»
    private static final By TEXT_BOX_BUTTON = By.xpath(".//span[text()='Text Box']");

    // поле «Full Name»
    private static final By FULL_NAME_FIELD = By.xpath(".//input[@placeholder='Full Name']");

    // поле «Email»
    private static final By EMAIL_FIELD = By.xpath(".//input[@placeholder='name@example.com']");

    // поле «Current Address»
    private static final By CURRENT_ADDRESS_FIELD = By.xpath(".//textarea[@placeholder='Current Address']");

    // поле «Permanent Address»
    private static final By PERMANENT_ADDRESS_FIELD = By.xpath(".//textarea[@ID='permanentAddress']");

    // Кнопка «Submit»
    private static final By SUBMIT_BUTTON = By.xpath(".//button[@id='submit']");

    // Кнопка «Submit»
    private static final By RESULT_FIELD = By.xpath(".//div[@class='border col-md-12 col-sm-12']");
    private WebDriver driver;

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выбрать в списке «Elements» поле «Text Box»")
    public void clickTextBoxButton() {
        driver.findElement(TEXT_BOX_BUTTON).click();
    }

    @Step("Заполнить поле «Full Name»")
    public void inputFullName(String NAME) {
        WebElement name = driver.findElement(FULL_NAME_FIELD);
        name.clear();
        name.sendKeys(NAME);
    }

    @Step("Заполнить поле «Email»")
    public void inputEmail(String EMAIL) {
        WebElement email = driver.findElement(EMAIL_FIELD);
        email.clear();
        email.sendKeys(EMAIL);
    }

    @Step("Заполнить поле «Current Address»")
    public void inputCurrentAddress(String C_ADDRESS) {
        WebElement currentAddress = driver.findElement(CURRENT_ADDRESS_FIELD);
        currentAddress.clear();
        currentAddress.sendKeys(C_ADDRESS);
    }

    @Step("Заполнить поле «Permanent Address»")
    public void inputPermanentAddress(String P_ADDRESS) {
        WebElement permanentAddress = driver.findElement(PERMANENT_ADDRESS_FIELD);
        permanentAddress.clear();
        permanentAddress.sendKeys(P_ADDRESS);
    }

    @Step("Заполнить все 4 поля любыми значениями")
    public void inputFields(String NAME, String EMAIL, String C_ADDRESS, String P_ADDRESS) {
        inputFullName(NAME);
        inputEmail(EMAIL);
        inputCurrentAddress(C_ADDRESS);
        inputPermanentAddress(P_ADDRESS);
    }

    @Step("Нажать на кнопку «Submit»")
    public void clickSubmitButton() {
        WebElement submit = driver.findElement(SUBMIT_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
        submit.click();
    }
    @Step("Ожидание отображения введенных данных")
    public String getDisplayedResultText(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement displayedResult = wait.until(ExpectedConditions.visibilityOfElementLocated(RESULT_FIELD));

        return displayedResult.getText();
    }


}
