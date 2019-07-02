package automationPracticePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
    WebDriver driver;

    public LoginElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "a.login")
    WebElement locateSignIn;

    @FindBy(how = How.CSS, using = "input#email")
    WebElement emailLogIn;

    @FindBy(how = How.CSS, using = "input#passwd")
    WebElement passwordLogin;

    @FindBy(how = How.CSS, using = "button#SubmitLogin")
    WebElement submit_button;

    public void loginMethod(String email, String password) {
        locateSignIn.click();
        emailLogIn.sendKeys(email);
        passwordLogin.sendKeys(password);
        submit_button.click();
    }
}
