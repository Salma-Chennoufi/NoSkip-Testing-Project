package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[normalize-space()='Inscription']")
    WebElement btnInscription;

    @FindBy(xpath = "//input[@placeholder='Prénom']")
    WebElement txtPrenom;

    @FindBy(xpath = "//input[@placeholder='Nom']")
    WebElement txtNom;

    @FindBy(xpath = "//input[@placeholder='Adresse Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Mot de passe']")
    WebElement txtPassword;

    @FindBy(css = "button[type='submit']")
    WebElement btnSinscrire;



    public void clickBtnInscription() {
        btnInscription.click();
    }

    public void setPrenom(String prenom){
        txtPrenom.sendKeys(prenom);
    }

    public void setNom(String nom){
        txtNom.sendKeys(nom);
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickSinscrire(){
        btnSinscrire.click();
    }

}
