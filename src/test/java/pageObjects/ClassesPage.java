package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ClassesPage extends BasePage {

    public ClassesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Classes']")
    WebElement btnClasses;

    @FindBy(css = "button[type='button']")
    WebElement btnAddClass;

    @FindBy(xpath = "//input[@placeholder='Nom de la classe']")
    WebElement txtClassName;

    @FindBy(xpath = "//input[@placeholder='Module']")
    WebElement txtModule;

    @FindBy(xpath = "//input[@placeholder='Année scolaire']")
    WebElement txtAnneeScolaire;

    @FindBy(xpath = "//button[normalize-space()='Ajouter']")
    WebElement btnAjouter;

    @FindBy(xpath = "//button[@title='Modifier']")
    WebElement btnModifier;

    @FindBy(xpath = "(//input)[2]")
    WebElement txtEditClassName;

    @FindBy(xpath = "(//input)[3]")
    WebElement txtEditModule;

    @FindBy(xpath = "(//input)[4]")
    WebElement txtEditYear;

    @FindBy(xpath = "//button[@title='Enregistrer']")
    WebElement btnEnregistrer;

    @FindBy(xpath = "//tr[1]//td[1]")
    WebElement className;

    @FindBy(xpath = "//tr[1]//td[2]")
    WebElement module;

    @FindBy(xpath = "//tr[1]//td[3]")
    WebElement year;

    @FindBy(xpath = "//button[@title='Supprimer']")
    WebElement btnSupprimer;

    @FindBy(xpath = "//tbody//tr")
    List<WebElement> rows;

    public void clickBtnClasses(){
        btnClasses.click();
    }
    public void clickBtnAddClass(){
        btnAddClass.click();
    }
    public void setTxtClassName(String name){
        txtClassName.sendKeys(name);
    }
    public void setTxtModule(String module){
        txtModule.sendKeys(module);
    }
    public void setTxtAnneeScolaire(String scolaire){
        txtAnneeScolaire.sendKeys(scolaire);
    }
    public void clickBtnAjouter(){
        btnAjouter.click();
    }
    public boolean isClassPresentOnce(String className, String module, String year) {
        //String xpath = "//table//tr[td[text()='" + className + "'] and td[text()='" + module + "'] and td[text()='" + year + "']]";
        int counter = 0;
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
                String cellClassName = cells.get(0).getText().trim();
                String cellModule = cells.get(1).getText().trim();
                String cellYear = cells.get(2).getText().trim();

                if (cellClassName.equals(className) &&
                        cellModule.equals(module) &&
                        cellYear.equals(year)) {
                    counter++;
                }
        }
        return counter == 1;
    }
    public boolean isClassEmpty(String className, String module, String year) {
        return className == null || className.isEmpty() || module == null || module.isEmpty() || year == null || year.isEmpty();
    }
    public void clickBtnModifier(){
        btnModifier.click();
    }

    public void setTxtEditClassName(String name){
        txtEditClassName.sendKeys(name);
    }
    public void setTxtEditModule(String module){
        txtEditModule.sendKeys(module);
    }
    public void setTxtEditYear(String year){
        txtEditYear.sendKeys(year);
    }
    public void clickBtnEnregistrer(){
        btnEnregistrer.click();
    }
    public String getClassName() {
        return className.getText();
    }
    public String getModule() {
        return module.getText();
    }
    public String getYear() {
        return year.getText();
    }
    public void clearTxtClassName() {
        txtEditClassName.clear();
    }
    public void clearTxtModule() {
        txtEditModule.clear();
    }
    public void clearTxtAnneeScolaire() {
        txtEditYear.clear();
    }
    public void clickBtnSupprimer(){
        btnSupprimer.click();
    }

}
