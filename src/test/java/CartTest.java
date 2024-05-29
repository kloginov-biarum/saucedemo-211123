import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest{
    @Test
    public void add1ItemTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //Add to cart backpack (1st item)
        inventoryPage.clickOnBackpackAddToCartButton();
        //Check that cart icon has badge with text "1"
        assertEquals("1", inventoryPage.getItemsQuantityCartBadge());
    }

    //Add 3 items to the cart
    @Test
    public void add3ItemsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //Add 3 items to the cart
        inventoryPage.clickOnBackpackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTShirtAddToCart();
        //Check that cart icon has badge with text "3"
        assertEquals("3", inventoryPage.getItemsQuantityCartBadge());
    }

    @Test
    public void cart1ItemTest(){
        //auth
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //add 1 item to the cart
        inventoryPage.clickOnBackpackAddToCartButton();
        //go to Cart page
        inventoryPage.clickOnTheCartIcon();
        //check that 1 item in the list
        CartPage cartPage = new CartPage(driver);
        assertEquals(1,cartPage.getAddedItemsQuantity());
        //check that item name from Cart page equals to item name, which was added
        assertEquals(inventoryPage.getNameOfTheFirstItem(),cartPage.getNameOfFirstItem());
    }

    //Check that 5 items are added to the cart
    @Test
    public void cart5ItemsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUsername("standard_user");
        loginPage.enterValueToPasswordInputField("secret_sauce");
        loginPage.clickOnTheLoginButton();
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCartButton();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTShirtAddToCart();
        inventoryPage.clickOnJacketAddToCartButton();
        inventoryPage.clickOnOnisieAddToCartButton();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertEquals(5, cartPage.getAddedItemsQuantity());
    }


}
