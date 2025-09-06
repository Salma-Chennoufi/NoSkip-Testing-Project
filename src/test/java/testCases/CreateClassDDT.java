package testCases;

import app.getxray.xray.testng.annotations.XrayTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ClassesPage;
import testBase.BaseClass;
import utilities.DataProviders;

import java.time.Duration;

public class CreateClassDDT extends BaseClass {

    @XrayTest(key = "NTP-23")
    @Test(dataProvider = "CreateClassData",  dataProviderClass = DataProviders.class, groups = {"Master, DataDriven"})
    public void testCreateClass(String className, String module, String year, String expectedResult){
        logger.info("******* Starting CreateClassDDT ******");
        logger.info("******* Login******");
        try {
            LoginForTest();
            ClassesPage cp = new ClassesPage(driver);
            cp.clickBtnClasses();
            driver.navigate().refresh();
            cp.clickBtnAddClass();
            cp.setTxtClassName(className);
            cp.setTxtModule(module);
            cp.setTxtAnneeScolaire(year);
            cp.clickBtnAjouter();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            logger.info("Alert text: " + alertText);
            alert.accept();
            logger.info("******* Alert accepted");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Liste des classes']")));
            if (expectedResult.equalsIgnoreCase("Valid")){
                if (cp.isClassPresentOnce(className, module, year)){
                    Assert.assertTrue(true);
                }else {
                    Assert.fail();
                }
            } else if (expectedResult.equalsIgnoreCase("Invalid")){
                if (!cp.isClassPresentOnce(className, module, year)|| cp.isClassEmpty(className, module, year)){
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch (Exception e){
            Assert.fail();
        }
       logger.info("******* Ending CreateClassDDT ******");
    }
}
