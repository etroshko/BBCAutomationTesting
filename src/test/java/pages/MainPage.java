package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(MainPage.class);
    private final String BASE_URL = "http://www.bbc.com/";

    @FindBy(className = "id4-cta-signout")
    private WebElement signOutLink;

    @FindBy(id = "idcta-link")
    private WebElement signInButton;

    @FindBy(id = "orb-search-q")
    private WebElement searchField;

    @FindBy(id = "orb-search-button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='search-content']/ol")
    private WebElement searchContent;

    @FindBy(xpath = "//*[@id='orb-nav-more']/a")
    private WebElement moreCategoriesLink;

    @FindBy(xpath = "//*[@id='orb-panel-more']/div/ul/li[18]/a")
    private WebElement musicLink;

    @FindBy(xpath = "//*[@id='mn']/div/div/a/span")
    private WebElement categoryText;

    @FindBy(xpath = "//ul[@class='media-list']/li[1]")
    private WebElement topNews;

    @FindBy(xpath = "//*[@id='page']/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement newsHeader;

    public MainPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
    }

    public void signOut() {
        signInButton.click();
        signOutLink.click();
        logger.info("Sign out completed");
    }

    public void openTopNews()
    {
        topNews.click();
        logger.info("Top news opened");
    }

    public boolean TopNewsIsOpen()
    {
        return newsHeader.getText().length()!=0;
    }

    public void openBBCMusic(){
        moreCategoriesLink.click();
        musicLink.click();
        logger.info("BBC Music opened");
    }

    public void search(String searchString)
    {
        searchField.sendKeys(searchString);
        searchButton.click();
        logger.info("Search completed");
    }

    public boolean searchQueryIsNotEmpty()
    {
        return searchContent.getCssValue("data-total-results")!= null;
    }

    public boolean isBBCMusicOpened() {
        return driver.getCurrentUrl().contains(categoryText.getText().toLowerCase().trim());
    }


}




