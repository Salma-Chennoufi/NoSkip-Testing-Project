package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ClassesPage;
import testBase.BaseClass;

public class DeleteClassTest extends BaseClass {
    @Test(groups = "Master")
    public void deleteClassTest(){
        logger.info("******* Starting DeleteClassTest *******");
        logger.info("******* Logging in *******");

        try {
            LoginForTest();
            ClassesPage cp = new ClassesPage(driver);
            cp.clickBtnClasses();
            driver.navigate().refresh();
            logger.info("******* Capturing class info *******");
            String className = cp.getClassName();
            logger.info("******* Class name is: " + className);
            String module =  cp.getModule();
            logger.info("******* Module is: " + module);
            String year =  cp.getYear();
            logger.info("******* Year is: " + year);
            logger.info("******* Deleting class *******");
            cp.clickBtnSupprimer();
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            if (cp.isClassPresentOnce(className, module, year)){
                Assert.fail();
            }else
                Assert.assertTrue(true);
        }catch (Exception e){
            Assert.fail();
        }

        logger.info("******* Finishing DeleteClassTest *******");
    }
}
