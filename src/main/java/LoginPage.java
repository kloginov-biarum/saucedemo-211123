import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(tagName = "h3")
    private WebElement errorMessageText;

    public void enterValueToUsername(String usernameValue){
        usernameInputField.sendKeys(usernameValue);
    }

    public void enterValueToPasswordInputField(String passwordValue){
        passwordInputField.sendKeys(passwordValue);
    }

    public void clickOnTheLoginButton(){
        loginButton.click();
    }

    public String getErrorMessageText(){
        return errorMessageText.getText();
    }
    public boolean usernameInputFiledIsDisplayed(){
        return usernameInputField.isDisplayed();
    }
}
