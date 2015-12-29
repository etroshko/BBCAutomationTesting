package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage extends AbstractPage {

    private final Logger logger = Logger.getLogger(SignInPage.class);
    private final String BASE_URL = "https://ssl.bbc.com/id/signin";

    @FindBy(id = "bbcid_unique")
    private WebElement usernameField;

    @FindBy(id = "bbcid_password")
    private WebElement passwordField;

    @FindBy(id = "bbcid_submit_button")
    private WebElement signinSubmitButton;

    @FindBy(id = "idcta-username")
    private WebElement signinCheck;


    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public void signIn(String username, String password)
    {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        signinSubmitButton.click();
        logger.info("Sign in completed");
    }

    public boolean isSignedIn()
    {
        return (signinCheck.getText()!= null && !signinCheck.getText().equals("Sign in"));
    }
}
