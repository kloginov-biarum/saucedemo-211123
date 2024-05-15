import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    public void itemsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals(6, inventoryPage.getItemQuantity());
        //check that all items are displayed
        assertTrue(inventoryPage.allItemsAreDisplayed());
        //check that all item names are displayed
        assertTrue(inventoryPage.allItemsNamesAreDisplayed());
        //all item names are NOT empty
        assertTrue(inventoryPage.allItemNameAreNotEmpty());
        //all items name starts with "Sauce Labs"

    }



}
