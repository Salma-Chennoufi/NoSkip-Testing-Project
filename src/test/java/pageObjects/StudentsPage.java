package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StudentsPage extends BasePage {

    public StudentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Étudiants']")
    WebElement btnEtudiants;

    @FindBy(xpath = "//button[normalize-space()='Importer']")
    WebElement btnImporter;

    @FindBy(xpath = "(//select)[2]")
    WebElement drpClassEle;

    @FindBy(xpath = "//input[@type='file']")
    WebElement selectFile;

    @FindBy(xpath = "(//button[normalize-space()='Importer'])[2]")
    WebElement btnImport;

    @FindBy(xpath = "//select[@id='classe']")
    WebElement drpSelectClass;

    @FindBy(xpath = "//tbody//tr")
    List<WebElement> studentsTable;

    @FindBy(xpath = "(//td)[2]")
    WebElement studentName;

    @FindBy(xpath = "//button[normalize-space()='Marquer']")
    WebElement btnMarquer;


    public void  clickBtnEtudiants() {
        btnEtudiants.click();
    }
    public void  clickBtnImporter() {
        btnImporter.click();
    }
    public String selectClass() {
        Select drpClass = new Select(drpClassEle);
        drpClass.selectByIndex(1);
        List<WebElement> options =drpClass.getOptions();
        return options.get(1).getText();
    }
    public String selectClassToShow() {
        Select drpClass = new Select(drpSelectClass);
        drpClass.selectByIndex(1);
        List<WebElement> options =drpClass.getOptions();
        return options.get(1).getText();
    }
    public void  selectFile(String filePath) {
        selectFile.sendKeys(filePath);
    }
    public void  clickBtnImport() {
        btnImport.click();
    }
    public void selectClasse(String className) {
        Select drpClass = new Select(drpSelectClass);
        drpClass.selectByVisibleText(className);
    }
    public int numberOfImportedStudents(){
        List<WebElement> rows = studentsTable;
        return rows.size();
    }
    public void  clickBtnMarquer() {
        btnMarquer.click();
    }
    public String getStudentName() {
        return studentName.getText();
    }
}
