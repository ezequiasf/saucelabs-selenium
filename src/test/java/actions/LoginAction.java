package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.Login;

public class LoginAction {

    private final Login login;
    private final WebDriverWait wait;

    public LoginAction (WebDriver driver)
    {
        login = new Login(driver);
        wait = new WebDriverWait(driver,10);
    }

    public LoginAction writeUsername (String username)
    {
        WebElement elementLogin = setWait(login.getInputLogin());
        elementLogin.clear();
        elementLogin.sendKeys(username);
        return this;
    }

    public LoginAction writePassword (String password)
    {
        WebElement elementPass = setWait(login.getInputPassword());
        elementPass.clear();
        elementPass.sendKeys(password);
        return this;
    }

    public LoginAction clickBtnLogin ()
    {
        setWait(login.getBtnLogin()).click();
        return this;
    }

    private WebElement setWait (WebElement whatElement)
    {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(whatElement));
        return element;
    }
}
