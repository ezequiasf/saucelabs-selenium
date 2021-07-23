package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.CartObject;

public class CartAction extends ContainerConstAction{

    private final CartObject objCart;

    public CartAction(WebDriver driver)
    {
        super(driver);
       objCart = new CartObject(driver);
    }

    public CartAction clickBtnBack ()
    {
        WebElement btnBack = wait.until(ExpectedConditions.elementToBeClickable(objCart.getBtnBack()));
        btnBack.click();
        return this;
    }

    public CartAction clickBtnCheckout ()
    {
        WebElement btnCheck = wait.until(ExpectedConditions.elementToBeClickable(objCart.getBtnCheckout()));
        btnCheck.click();
        return this;
    }
}
