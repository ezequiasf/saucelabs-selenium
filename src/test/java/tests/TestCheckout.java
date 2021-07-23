package tests;

import actions.CheckoutAction;
import actions.LoginAction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCheckout {

    static WebDriver driver;
    static LoginAction logAct;
    static CheckoutAction objCheck;

    @BeforeAll
    static void setupInitial () {
        System.setProperty("webdriver.edge.driver", "c:\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        logAct = new LoginAction(driver);
        objCheck = new CheckoutAction(driver);
    }

    @BeforeEach
    void login ()
    {
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            logAct.writeUsername("standard_user");
            logAct.writePassword("secret_sauce");
            logAct.clickBtnLogin();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {",sales,4853","Carlos,,4853","Carlos,sales,"})
    void verifyRequirements (String first, String last, String zipCode)
    {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        if (first==null){
            objCheck.writeLastName(last);
            objCheck.writePostalCode(zipCode);
            objCheck.clickBtnContinue();
            assertEquals("Error: First Name is required",textError());
        }else if (last==null){
            objCheck.writeFirstName(first);
            objCheck.writePostalCode(zipCode);
            objCheck.clickBtnContinue();
            assertEquals("Error: Last Name is required",textError());
        }else{
            objCheck.writeFirstName(first);
            objCheck.writeLastName(last);
            objCheck.clickBtnContinue();
            assertEquals("Error: Postal Code is required",textError());
        }
    }

    @AfterAll
    static void finishSetup ()
    {
        driver.quit();
    }

    private String textError ()
    {
        return driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
    }

}
