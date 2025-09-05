package testCases;

import app.getxray.xray.testng.annotations.XrayTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

    @XrayTest(key = "NTP-17")
    @Test(groups = {"Sanity", "Master"})
    public void loginTest(){

        logger.info("******* Starting LoginTest ******");

        try {
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(prop.getProperty("email"));
            lp.setPassword(prop.getProperty("password"));
            lp.clickLogin();
            logger.info("******* Login button clicked ******");
            DashboardPage dp = new DashboardPage(driver);
            boolean targetPage = dp.isDashboardPageDisplayed();
            Assert.assertTrue(targetPage);
        } catch (Exception ex) {
            Assert.fail();
        }

        logger.info("******* Finished LoginTest ******");
    }
}
