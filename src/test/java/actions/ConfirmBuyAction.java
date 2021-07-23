package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.ConfirmBuy;

public class ConfirmBuyAction extends ContainerConstAction{

    private final ConfirmBuy objConf;

    public ConfirmBuyAction (WebDriver driver)
    {
        super(driver);
        objConf = new ConfirmBuy(driver);
    }

    public ConfirmBuyAction clickBtnCancel ()
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objConf.getBtnCancel()));
        element.click();
        return this;
    }

    public ConfirmBuyAction clickBtnFinish ()
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objConf.getBtnFinish()));
        element.click();
        return this;
    }
}
