package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObject.Checkout;

public class CheckoutAction extends ContainerConstAction {

    private final Checkout check;

    public CheckoutAction (WebDriver driver)
    {
        super(driver);
        check = new Checkout(driver);
    }

    public CheckoutAction writeFirstName (String firstName)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(check.getFirstName()));
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    public CheckoutAction writeLastName (String lastName)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(check.getLastName()));
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    public CheckoutAction writePostalCode (String zipCode)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(check.getPostalCode()));
        element.clear();
        element.sendKeys(zipCode);
        return this;
    }

    public CheckoutAction clickBtnCancel ()
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(check.getBtnCancel()));
        element.click();
        return this;
    }

    public CheckoutAction clickBtnContinue ()
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(check.getBtnContinue()));
        element.click();
        return this;
    }

}
