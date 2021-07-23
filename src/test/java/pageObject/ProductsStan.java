package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsStan extends ContainerConst {

    @FindBy(xpath = "//*[@id='header_container']/div[2]/div[2]/span/select")
    private WebElement comboFilter;

    @FindBys({
            @FindBy(css = "div.inventory_item_name")
    })
    private List<WebElement> listTitle;

    @FindBys({
            @FindBy(css = "div.inventory_item_price")
    })
    private List<WebElement> listPrice;

    @FindBys({
            @FindBy(css = "button.btn_inventory")
    })
    private List<WebElement> listButtonAddCart;

    public ProductsStan(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getComboFilter() {
        return comboFilter;
    }

    public Object[] getAllLists ()
    {
        return new Object[]{
                listTitle,listPrice,listButtonAddCart
        };
    }
}
