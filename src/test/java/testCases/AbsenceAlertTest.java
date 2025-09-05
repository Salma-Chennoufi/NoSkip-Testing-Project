package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AlertsPage;
import pageObjects.StudentsPage;
import testBase.BaseClass;

public class AbsenceAlertTest extends BaseClass {

    @Test(groups = {"Master"})
    public void testAbsenceAlert() {
        logger.info("******* Starting AbsenceAlertTest *******");
        logger.info("******* Login *******");
        try {
            LoginForTest();
            StudentsPage sp = new StudentsPage(driver);
            sp.clickBtnEtudiants();
            driver.navigate().refresh();
            String selectedClass = sp.selectClassToShow();
            sp.selectClasse(selectedClass);
            String studentName = sp.getStudentName();
            for (int i=0; i<3; i++) {
                sp.clickBtnMarquer();
            }
            logger.info("******* Absences marquée ");
            AlertsPage al = new AlertsPage(driver);
            al.clickBtnAlertes();
            al.selectClasse(selectedClass);
            if (al.getStudentName().contains(studentName)) {
                Assert.assertTrue(true);
            }else
                Assert.fail();
        } catch (Exception e) {
            Assert.fail();
        }

    }
}
