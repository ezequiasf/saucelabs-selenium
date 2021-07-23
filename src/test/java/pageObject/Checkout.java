package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout extends ContainerConst{

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "postalCode")
    private WebElement postalCode;

    @FindBy(name = "cancel")
    private WebElement btnCancel;

    @FindBy(name = "continue")
    private WebElement btnContinue;

    public Checkout (WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public WebElement getBtnCancel() {
        return btnCancel;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }
}
