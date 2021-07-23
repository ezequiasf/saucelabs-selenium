package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContainerConst {

    @FindBy(xpath = "//*[@id='react-burger-menu-btn']")
    private WebElement btnMenu;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement btnShoppingCart;

    @FindBy(id = "react-burger-cross-btn")
    private WebElement btnCloseMenu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement btnLogout;

    @FindBy(css = "li.social_twitter")
    private WebElement linkTwitter;

    @FindBy(css = "li.social_facebook")
    private WebElement linkFacebook;

    @FindBy(css = "li.social_linkedin")
    private WebElement linkLinkedin;

    public ContainerConst(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getBtnMenu() {
        return btnMenu;
    }

    public WebElement getBtnShoppingCart() {
        return btnShoppingCart;
    }

    public WebElement getLinkTwitter() {
        return linkTwitter;
    }

    public WebElement getLinkFacebook() {
        return linkFacebook;
    }

    public WebElement getLinkLinkedin() {
        return linkLinkedin;
    }

    public WebElement getBtnCloseMenu() {
        return btnCloseMenu;
    }

    public WebElement getBtnLogout() {
        return btnLogout;
    }
}
