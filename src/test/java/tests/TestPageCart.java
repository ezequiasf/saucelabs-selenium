package tests;

import actions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPageCart {

    static WebDriver driver;
    static LoginAction logAct;
    static CartAction objCart;
    static ProductsAction objProd;
    static CheckoutAction objCheck;
    static ConfirmBuyAction objConfirm;

    @BeforeAll
    static void setupInitial () {
        System.setProperty("webdriver.edge.driver", "c:\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        logAct = new LoginAction(driver);
        objProd = new ProductsAction(driver);
        objCart = new CartAction(driver);
        objCheck = new CheckoutAction(driver);
        objConfirm = new ConfirmBuyAction(driver);
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

    @Test
    void pageCart ()
    {
        objCart.clickBtnShopping();
        assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());
        objCart.clickBtnBack();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        objCart.clickBtnShopping();
        objCart.clickBtnCheckout();
        assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());
    }

    @Test
    void verifyItemsInPageCart ()
    {
        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        clickAllBtns();
        objCart.clickBtnShopping();
        int numbItems = driver.findElements(By.cssSelector("div[class='cart_item']")).size();
        assertEquals(6, numbItems);

        objCart.clickBtnCheckout();
        objCheck.clickBtnCancel();
        objCart.clickBtnCheckout();
        objCheck.writeFirstName("Carlitos");
        objCheck.writeLastName("Tevez");
        objCheck.writePostalCode("12362126");
        objCheck.clickBtnContinue();

        objConfirm.clickBtnFinish();
        String title = driver.findElement(By.cssSelector("span[class='title']")).getText();
        assertEquals("CHECKOUT: COMPLETE!", title);
    }

    @AfterAll
    static void finishSetup ()
    {
        driver.quit();
    }

    private void clickAllBtns ()
    {
        for(int i = 0; i<= objProd.numbProducts()-1; i++) {
            objProd.clickBtnAdd(i);
        }
    }
}
