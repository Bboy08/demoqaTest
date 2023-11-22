import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Description;
import pageobject.ElementsPage;
import pageobject.MainPage;
import static org.junit.Assert.assertEquals;

public class MainTest extends BaseTest {
    String Name = "Anton";
    String Email = "anton-bochaev@yandex.ru";
    String CurrentlyAddress = "Current Address";
    String PermanentAddress = "Permanent Address";

    @Test
    @DisplayName("Validate Correct Display of Input Data")
    @Description("This test verifies that the displayed data corresponds to the input data.")
    public void validateCorrectlyDisplayedInputData() {
        MainPage mainPage = new MainPage(driver);
        ElementsPage elementsPage = new ElementsPage(driver);
        mainPage.openPage();
        mainPage.clickElementsButton();
        elementsPage.clickTextBoxButton();
        elementsPage.inputFields(Name, Email, CurrentlyAddress, PermanentAddress);
        elementsPage.clickSubmitButton();
        String actualText = elementsPage.getDisplayedResultText(driver);
        String expectedText = "Name:" + Name + "\nEmail:" + Email + "\nCurrent Address :" + CurrentlyAddress + "\nPermananet Address :" + PermanentAddress;
        assertEquals(expectedText, actualText);
    }
}
