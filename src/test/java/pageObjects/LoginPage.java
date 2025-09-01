package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Adresse Email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@placeholder='Mot de passe']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;


     public void setEmail(String email){
         txtEmail.sendKeys(email);
     }
     public void setPassword(String password){
         txtPassword.sendKeys(password);
     }
     public void clearEmail(){
         txtEmail.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
     }
     public void clearPassword(){
         txtPassword.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
     }
     public void clickLogin(){
        btnLogin.click();
     }

}
