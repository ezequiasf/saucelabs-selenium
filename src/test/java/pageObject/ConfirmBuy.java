package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmBuy extends ContainerConst{

    @FindBy(name = "cancel")
    private WebElement btnCancel;

    @FindBy(name = "finish")
    private WebElement btnFinish;

    public ConfirmBuy (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getBtnCancel() {
        return btnCancel;
    }

    public WebElement getBtnFinish() {
        return btnFinish;
    }
}
