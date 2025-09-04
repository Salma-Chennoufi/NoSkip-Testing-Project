package testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

import java.time.Duration;
import java.util.UUID;

public class RegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void testRegistration(){

        logger.info("******* Starting RegistrationTest *******");
        try {
            String uniqueId = UUID.randomUUID().toString().substring(0,5);
            String email = "noskip_" + uniqueId + "@mailtrap.io";
            RegistrationPage regPage = new RegistrationPage(driver);
            regPage.clickBtnInscription();
            logger.info("Providing user's details...");
            regPage.setPrenom("Test");
            regPage.setNom("User");
            regPage.setEmail(email);
            regPage.setPassword("pass123!");
            regPage.clickSinscrire();
            logger.info("Validating expected message...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@role='alert']")
            ));
            String actualMessage = alert.getText();
            if(actualMessage.contains("Inscription réussie")){
                Assert.assertTrue(true);
            }else {
                Assert.fail();
            }
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }

        logger.info("******* Finished RegistrationTest *******");

    }

}
