package Pages;

import Constants.locators.LoginPageConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username= By.id(LoginPageConstant.USERNAME);
    private By password= By.id(LoginPageConstant.PASSWORD);
    private By button= By.className(LoginPageConstant.SUBMIT);

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void fillUsername(String inputUsername ){
        driver.findElement(username).sendKeys(inputUsername);
    }
    public void fillPassword(String inputPassword){
        driver.findElement(password).sendKeys(inputPassword);
    }
    public void clickButton() {
        driver.findElement(button).click();
    }

}
