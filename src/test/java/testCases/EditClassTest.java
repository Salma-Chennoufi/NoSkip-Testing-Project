package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ClassesPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class EditClassTest extends BaseClass {

    @Test(dataProvider = "EditClassData",  dataProviderClass = DataProviders.class, groups = {"Master"})
    public void testEditClass(String className, String module, String year) {
        logger.info("******* Starting EditClassTest *******");
        logger.info("******* Logging in *******");
        try {
            LoginForTest();
            ClassesPage cp = new ClassesPage(driver);
            cp.clickBtnClasses();
            driver.navigate().refresh();
            logger.info("******* Editing class *******");
            cp.clickBtnModifier();
            cp.clearTxtClassName();
            cp.setTxtEditClassName(className);
            cp.clearTxtModule();
            cp.setTxtEditModule(module);
            cp.clearTxtAnneeScolaire();
            cp.setTxtEditYear(year);
            cp.clickBtnEnregistrer();

            if (cp.getClassName().equals(className)  &&  cp.getModule().equals(module) && cp.getYear().equals(year)){
                Assert.assertTrue(true);
            }else
                Assert.fail();
        } catch (Exception ex) {
            logger.info("******* Failed EditClassTest *******");
            Assert.fail();
        }

    }
}
