package tests;

import actions.LoginAction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteLogin {

    static WebDriver driver;
    static LoginAction logAct;

    @BeforeAll
    static void setupInitial ()
    {
        System.setProperty("webdriver.edge.driver", "c:\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        logAct = new LoginAction(driver);
    }

    @BeforeEach
    void goToMainPage ()
    {
        if(!driver.getCurrentUrl().equals("https://www.saucedemo.com/"))
        {
            driver.navigate().to("https://www.saucedemo.com/");
        }
    }

    @ParameterizedTest
    @CsvSource( value = {"standard_user,secret_sauce"
            ,"problem_user,secret_sauce"
            ,"performance_glitch_user,secret_sauce"})
    void testAuthenticationSuccess (String username, String pass)
    {
        logAct.writeUsername(username);
        logAct.writePassword(pass);
        logAct.clickBtnLogin();
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @ParameterizedTest
    @CsvSource(value = {"admin,admin", "log,34234"})
    void testAuthenticationFailed (String username, String pass)
    {
        logAct.writeUsername(username);
        logAct.writePassword(pass);
        logAct.clickBtnLogin();
        String textFailed = driver.findElement(By.cssSelector("div.error-message-container")).getText();
        assertEquals("Epic sadface: Username and password do not match any user in this service", textFailed);
    }

    @Test
    void testUserLockedOut ()
    {
        logAct.writeUsername("locked_out_user");
        logAct.writePassword("secret_sauce");
        logAct.clickBtnLogin();
        String textLocked = driver.findElement(By.cssSelector("div.error-message-container")).getText();
        assertEquals("Epic sadface: Sorry, this user has been locked out.",textLocked);
    }

    @AfterAll
    static void finishSetup ()
    {
        driver.quit();
    }
}
