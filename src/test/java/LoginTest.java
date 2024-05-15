import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.log.Log;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void validDataWithPO()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals("Products",inventoryPage.tittleTextIsProducts());

    }

    @Test
    public void validData() throws InterruptedException {
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("standard_user");
        //Enter the password field
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        //Click on Login button
        WebElement clickLoginButton = driver.findElement(By.id("login-button"));
        clickLoginButton.click();
        //Check that log in was successful
        WebElement titleText = driver.findElement(By.cssSelector("[data-test=\"title\"]"));
        assertEquals("Products", titleText.getText());
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryList.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("/inventory"));
    }
    @Test
    public void invalidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("user-name");
        loginPage.enterValueToPasswordInputField("rewfsfsefsaf");
        loginPage.clickOnTheLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains("Username and password do not match any user in this service"));
    }


    //invalid username
    @Test
    public void invalidUsername(){
        WebElement usernameInputField = driver.findElement(By.id("user-name"));
        usernameInputField.sendKeys("fsdgfdgfd");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement clickLoginButton = driver.findElement(By.id("login-button"));
        clickLoginButton.click();
        WebElement errorMessageText = driver.findElement(By.tagName("h3"));
        assertTrue(errorMessageText.getText().contains("Username and password do not match any user in this service"));
    }

    //1. Empty Username

    //2.Empty password

    //3.Empty creds (both username and password)



    @Test
    public void lockedUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("locked_out_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        assertTrue(loginPage.getErrorMessageText().contains(" Sorry, this user has been locked out."));
    }

    //log out
    @Test
    public void successLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        SideBar sideBar = new SideBar(driver);
        sideBar.clickOnBurgerMenuButton();
        sideBar.followTheLogoutLink();
        assertTrue(loginPage.usernameInputFiledIsDisplayed());
    }

}
