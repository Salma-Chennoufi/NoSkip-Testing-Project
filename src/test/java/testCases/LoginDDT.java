package testCases;

/*
Data is valid - login success - test pass - logout
                login failed - test fail

Data is invalid - login success - test fail - logout
                  login failed - test pass
 */

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData",  dataProviderClass = DataProviders.class, groups = {"DataDriven"})
    public void testLoginDDT(String email, String password, String expectedResult){

        logger.info("******* Starting LoginDDT *******");

        try {
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            DashboardPage dp = new DashboardPage(driver);
            boolean targetPage = dp.isDashboardPageDisplayed();

            if (expectedResult.equalsIgnoreCase("Valid")){
                if(targetPage){
                    dp.clickProfileIcon();
                    dp.clickBtnLogout();
                    Assert.assertTrue(true);
                } else {
                    lp.clearEmail();
                    lp.clearPassword();
                    Assert.fail();
                }
            } else if(expectedResult.equalsIgnoreCase("Invalid")) {
                if (targetPage) {
                    dp.clickProfileIcon();
                    dp.clickBtnLogout();
                    Assert.fail();
                } else{
                    lp.clearEmail();
                    lp.clearPassword();
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception ex) {
            Assert.fail();
        }

        logger.info("******* Finished LoginDDT *******");

    }
}
