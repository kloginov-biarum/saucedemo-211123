import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage{
    WebDriver driver;

    public CartPage(WebDriver driver) {
       super(driver);
    }
    @FindBy(className = "cart_item")
    private List<WebElement> addedItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    public int getAddedItemsQuantity(){
        return addedItems.size();
    }

    public String getNameOfFirstItem(){
        return itemNames.get(0).getText();
    }
}
