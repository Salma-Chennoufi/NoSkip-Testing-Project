package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void loginTest(){

        logger.info("******* Starting LoginTest ******");

        try {
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(prop.getProperty("email"));
            lp.setPassword(prop.getProperty("password"));
            lp.clickLogin();

            DashboardPage dp = new DashboardPage(driver);
            boolean targetPage = dp.isDashboardPageDisplayed();

            Assert.assertTrue(targetPage);
        } catch (Exception ex) {
            Assert.fail();
        }

        logger.info("******* Finished LoginTest ******");
    }
}
