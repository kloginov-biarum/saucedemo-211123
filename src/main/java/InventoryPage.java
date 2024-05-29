import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryPage extends BasePage{
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement tittleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCardBackPack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCartBoltTShirt;

    @FindBy(id ="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCardJacket;

    @FindBy(id ="add-to-cart-sauce-labs-onesie")
    private  WebElement addToCardOniesie;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy (className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = "[data-test=\"product-sort-container\"]")
    private WebElement sortDropdown;

    @FindBy(css = "[value=\"lohi\"]")
    private WebElement priceLowHigh;

    @FindBy(css = "[value=\"hilo\"]")
    private WebElement priceHighLow;

    @FindBy(css = "[value=\"az\"]")
    private WebElement alphOrderSort;

    @FindBy(css = "[value=\"za\"]")
    private WebElement reverseAlphOrder;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;


    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }

    public String tittleTextIsProducts(){
        return getTextOfElement(tittleText);
    }

    public int getItemQuantity(){
        return items.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item: items) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemsNamesAreDisplayed(){
        boolean displayed = true;
        for (WebElement itemName: itemNames) {
            if (!itemName.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allItemNameAreNotEmpty(){
        boolean notEmpty = true;
        for (WebElement itemName: itemNames) {
            if (itemName.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allItenmNamesStartsWithSauceLabs(){
        boolean startsWithSauceLabs = true;
        for (WebElement itemName:itemNames) {
            if(!itemName.getText().startsWith("Sauce Labs")){
                startsWithSauceLabs = false;
            }
        }
        return startsWithSauceLabs;
    }

    public void clickOnBackpackAddToCartButton(){
        addToCardBackPack.click();
    }

    public void clickOnBikeLightAddToCart(){
        addToCartBikeLight.click();
    }

    public void clickOnTShirtAddToCart(){
        addToCartBoltTShirt.click();
    }
    public void clickOnJacketAddToCartButton(){
        addToCardJacket.click();
    }
    public void clickOnOnisieAddToCartButton(){
        addToCardOniesie.click();
    }
    public String getItemsQuantityCartBadge(){
        return cartBadge.getText();
    }


    public void clickOnTheCartIcon(){
        cartIcon.click();
    }


    public String getNameOfTheFirstItem(){
        return itemNames.get(0).getText();
    }

    public void choosePriceLowToHighSortOption(){
        sortDropdown.click();
        priceLowHigh.click();
    }

    public void choosePriceHighToLowSortOption(){
        sortDropdown.click();
        priceHighLow.click();
    }

    public void chooseNameAlphSortOrderOption(){
        sortDropdown.click();
        alphOrderSort.click();
    }
    public void chooseNameReverseAlphSortOrderOption(){
        sortDropdown.click();
        reverseAlphOrder.click();
    }


    public boolean checkPriceSortFromLowToHigh(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price: inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices);
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkPriceSortFromHighToLow(){
        List<Double> actualPrices = new ArrayList<>();
        for (WebElement price: inventoryPrices) {
            actualPrices.add(parseDouble(price.getText().substring(1)));
        }
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        sort(expectedPrices, reverseOrder());
        return actualPrices.equals(expectedPrices);
    }

    public boolean checkNamesSortAlphOrder(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name: inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames);
        return actualNames.equals(expectedNames);
    }

    public boolean checkNamesSortRevrseAlphOrder(){
        List<String> actualNames = new ArrayList<>();
        for (WebElement name: inventoryNames) {
            actualNames.add(name.getText());
        }
        List<String> expectedNames = new ArrayList<>(actualNames);
        sort(expectedNames, reverseOrder());
        return actualNames.equals(expectedNames);
    }

}
