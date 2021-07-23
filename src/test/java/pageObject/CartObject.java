package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartObject extends ContainerConst {

    @FindBy(id = "continue-shopping")
    private WebElement btnBack;

    @FindBy(id="checkout")
    private WebElement btnCheckout;

    public CartObject(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getBtnBack() {
        return btnBack;
    }

    public WebElement getBtnCheckout() {
        return btnCheckout;
    }
}
