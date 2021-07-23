package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pageObject.ProductsStan;

import java.util.List;

@SuppressWarnings("ALL")
public class ProductsAction extends ContainerConstAction {

    private final ProductsStan prodPage;

    public ProductsAction(WebDriver driver)
    {
        super(driver);
        prodPage = new ProductsStan(driver);
    }

    public ProductsAction filterProducts(String optionFilter)
    {
        WebElement combo = wait.until(ExpectedConditions.elementToBeClickable(prodPage.getComboFilter()));
        Select selectFilter = new Select(combo);
        selectFilter.selectByVisibleText(optionFilter);
        return this;
    }

    public WebElement getLinkProduct (int index)
    {
        return returnList(0).get(index);
    }

    public String getTitleProduct (int index)
    {
        return returnList(0).get(index).getText();
    }

    public int numbProducts ()
    {
        return returnList(0).size();
    }

    public String getPriceProduct (int index)
    {
        return returnList(1).get(index).getText();
    }

    public ProductsAction clickBtnAdd (int index)
    {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(returnList(2).get(index)));
        btn.click();
        return this;
    }

    /*
        To this case, i'm not use generics, because
        the method in PageProductStandard objective,
        is transfer all List<WebElements>;
     */
    private List<WebElement> returnList (int index)
    {
        Object[] lists = prodPage.getAllLists();
        List<WebElement> listElement = (List<WebElement>) lists[index];
        return listElement;
    }

}
