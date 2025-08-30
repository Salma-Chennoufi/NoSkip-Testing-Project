package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Tableau de bord']")
    WebElement btnDashboard;

    @FindBy(xpath = "//button")
    WebElement profileIcon;

    @FindBy(xpath = "//span[normalize-space()='Se déconnecter']")
    WebElement btnLogout;


    public boolean isDashboardPageDisplayed(){
        try {
            return btnDashboard.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProfileIcon(){
        profileIcon.click();
    }

    public void clickBtnLogout(){
        btnLogout.click();
    }

}
