package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AlertsPage extends BasePage{

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Alertes']")
    WebElement btnAlertes;

    @FindBy(xpath = "//select")
    WebElement drpSelectClass;

    @FindBy(xpath = "//td")
    WebElement studentName;

    public void clickBtnAlertes(){
        btnAlertes.click();
    }
    public void selectClasse(String className) {
        Select drpClass = new Select(drpSelectClass);
        drpClass.selectByVisibleText(className);
    }
    public String getStudentName(){
        return studentName.getText();
    }
}
