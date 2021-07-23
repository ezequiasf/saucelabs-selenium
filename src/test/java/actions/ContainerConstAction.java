package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.ContainerConst;

public class ContainerConstAction {

    private final ContainerConst headFootObj;
    protected final WebDriverWait wait;

    public ContainerConstAction(WebDriver driver)
    {
        headFootObj = new ContainerConst(driver);
        wait = new WebDriverWait(driver, 10);
    }

    public ContainerConstAction clickBtnMenu ()
    {
        setWait(headFootObj.getBtnMenu()).click();
        return this;
    }

    public ContainerConstAction clickBtnShopping ()
    {
        setWait(headFootObj.getBtnShoppingCart()).click();
        return this;
    }

    public String getAttributeBtnShopping (String attribute)
    {
        return headFootObj.getBtnShoppingCart().getAttribute(attribute);
    }

    public ContainerConstAction clickSocialMedia (String whichSocial)
    {
        String socialMedia = whichSocial.toLowerCase();
        switch (socialMedia)
        {
            case "twitter":
                setWait(headFootObj.getLinkTwitter()).click();
                break;
            case "facebook":
                setWait(headFootObj.getLinkFacebook()).click();
                break;
            case "linkedin":
                setWait(headFootObj.getLinkLinkedin()).click();
        }
        return this;
    }

    public ContainerConstAction clickBtnClose ()
    {
        setWait(headFootObj.getBtnCloseMenu()).click();
        return this;
    }

    public ContainerConstAction clickBtnLogout ()
    {
        setWait(headFootObj.getBtnLogout()).click();
        return this;
    }

    private WebElement setWait (WebElement whatElement)
    {
        return  wait.until(ExpectedConditions.elementToBeClickable(whatElement));
    }
}
