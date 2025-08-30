package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class RegistrationTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void testRegistration(){

        logger.info("******* Starting RegistrationTest *******");
        try {
            RegistrationPage regPage = new RegistrationPage(driver);
            regPage.clickBtnInscription();
            logger.info("Providing user's details...");
            regPage.setPrenom("");
            regPage.setNom("");
            regPage.setEmail("");
            regPage.setPassword("");
            regPage.clickSinscrire();
            logger.info("Validating expected message...");
            String popupMsg=regPage.getPopupMsg();
            Assert.assertEquals(popupMsg,"Inscription reussie! Veuillez vérifier votre boîte de réception pour activer votre compte");
        } catch (Exception e) {
            logger.error("Test failed...");
            logger.debug("Debug logs...");
            Assert.fail();
        }

        logger.info("******* Finished RegistrationTest *******");

    }

}
