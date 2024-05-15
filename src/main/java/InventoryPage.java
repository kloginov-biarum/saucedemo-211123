import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryPage {
    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-test=\"title\"]")
    private WebElement tittleText;

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;

    @FindBy(className = "inventory_item")
    private List<WebElement> items;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemNames;

    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }

    public String tittleTextIsProducts(){
       return tittleText.getText();
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


}
