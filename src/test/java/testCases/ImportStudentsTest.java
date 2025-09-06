package testCases;

import app.getxray.xray.testng.annotations.XrayTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.StudentsPage;
import testBase.BaseClass;

import java.time.Duration;

public class ImportStudentsTest extends BaseClass {

    //@XrayTest(key = "NTP-30") // invalid
    @XrayTest(key = "NTP-29") // valid
    @Test(groups = {"Master"})
    public void testImportStudents() {
        logger.info("******* Starting testImportStudents ******");
        logger.info("******* Login  ******");
        try {
            LoginForTest();
            StudentsPage sp = new StudentsPage(driver);
            sp.clickBtnEtudiants();
            driver.navigate().refresh();
            logger.info("******* Starting Importation ******");
            sp.clickBtnImporter();
            String selectedClass = sp.selectClass();
            logger.info("******* Select file ******");
            sp.selectFile(System.getProperty("user.dir") + "\\testData\\" + prop.getProperty("studentsList"));
            logger.info("******* file selected ******");
            sp.clickBtnImport();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            logger.info("Alert text: " + alertText);
            alert.accept();
            if (prop.getProperty("studentsList").equals("liste_eleves.xlsx")){
                if(alertText.equals("Erreur lors de l'importation.")){
                    Assert.fail();
                } else if (alertText.equals("Importation réussie !")) {
                    sp.selectClasse(selectedClass);
                    if (sp.numberOfImportedStudents()==10){
                        Assert.assertTrue(true);
                    }else {
                        Assert.fail();
                    }
                }
            } else {
                if(alertText.equals("Erreur lors de l'importation.")){
                    Assert.assertTrue(true);
                } else if (alertText.equals("Importation réussie !")) {
                    Assert.fail();
                }
            }

        }catch (Exception e){
            Assert.fail();
        }
        logger.info("******* Ending testImportStudents ******");

    }
}
