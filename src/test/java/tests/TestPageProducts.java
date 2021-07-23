package tests;

import actions.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class TestPageProducts {

    static WebDriver driver;
    static LoginAction logAct;
    static ProductsAction objProd;

    @BeforeAll
    static void setupInitial ()
    {
        System.setProperty("webdriver.edge.driver", "c:\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        logAct = new LoginAction(driver);
        objProd = new ProductsAction(driver);
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
    void TesteBtnMenuLogout ()
    {
        objProd.clickBtnMenu();
        objProd.clickBtnClose();
        objProd.clickBtnMenu();
        objProd.clickBtnLogout();
        String urlLogin = "https://www.saucedemo.com/";
        assertEquals(urlLogin, driver.getCurrentUrl());
    }

    @Test
    void usingSelectFilter ()
    {
        objProd.filterProducts("Name (Z to A)");
        String firstTitle = objProd.getTitleProduct(0);
        assertEquals("Test.allTheThings() T-Shirt (Red)", firstTitle);
        objProd.filterProducts("Price (low to high)");
        assertEquals("$7.99", objProd.getPriceProduct(0));
        objProd.filterProducts("Price (high to low)");
        assertEquals("$49.99", objProd.getPriceProduct(0));
        objProd.filterProducts("Name (A to Z)");
    }

    @Test
    void testLinkProducts ()
    {
        for (int i = 0; i<= objProd.numbProducts()-1;i++) {
            objProd.getLinkProduct(i).click();
            driver.findElement(By.id("back-to-products")).click();
        }
    }

    @Test
    void testBtnProducts ()
    {
        clickAllBtns();
        String numb = objProd.getAttributeBtnShopping("innerText");
        assertEquals("6", numb);
        clickAllBtns();
        numb = objProd.getAttributeBtnShopping("innerText");
        assertEquals("", numb);
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
