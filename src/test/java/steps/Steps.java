package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class Steps
{
    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);

    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver()
    {
        driver.quit();
        logger.info("Browser stopped");
    }

    public void signInBBC(String username, String password)
    {
        SignInPage page = new SignInPage(driver);
        page.openPage();
        page.signIn(username, password);

    }
    public void signOutBBC() {
        MainPage page = new MainPage(driver);
        page.signOut();
    }

    public boolean isSignedIn()
    {
        SignInPage page = new SignInPage(driver);
        return (page.isSignedIn());
    }

    public boolean searchQueryIsNotEmpty()
    {
        MainPage page = new MainPage(driver);
        return (page.searchQueryIsNotEmpty());
    }

    public void search(String searchText)
    {
        MainPage page = new MainPage(driver);
        page.openPage();
        page.search(searchText);
    }

    public void openTopNews()
    {
        MainPage page = new MainPage(driver);
        page.openPage();
        page.openTopNews();
    }

    public void openBBCMusic() {
        MainPage page = new MainPage(driver);
        page.openPage();
        page.openBBCMusic();
    }

    public boolean isBBCMusicOpened() {
        MainPage page = new MainPage(driver);
        return page.isBBCMusicOpened();
    }

    public boolean TopNewsIsOpen()
    {
        MainPage page = new MainPage(driver);
        return (page.TopNewsIsOpen());
    }


}
