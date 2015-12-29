import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.Steps;

public class BBCAutomationTest {

    private Steps steps;
    private final String USERNAME = "troshko.evgeny@gmail.com";
    private final String PASSWORD = "nokia6303";
    private final String GOODSEARCH = "Didier Drogba";
    private final String BADSEARCH = "fbiofnboefnvsoivnwdoivn";

    @BeforeMethod(description = "Init browser")
    public void initBrowser()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test(description = "Sign in")
    public void signin()
    {
        steps.signInBBC(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isSignedIn());
    }

    @Test(description = "Sign out")
    public void signout()
    {
        steps.signInBBC(USERNAME, PASSWORD);
        steps.signOutBBC();
        Assert.assertFalse(steps.isSignedIn());
    }

    @Test(description = "Search results for query")
    public void goodSearch()
    {
        steps.search(GOODSEARCH);
        Assert.assertTrue(steps.searchQueryIsNotEmpty());
    }

    @Test (expectedExceptions = NoSuchElementException.class, description = "Search results for query")
    public void badSearch()
    {
        steps.search(BADSEARCH);
        Assert.assertFalse(steps.searchQueryIsNotEmpty());
    }

    @Test (description = "Open music category")
    public void openBBCMusic()
    {
        steps.openBBCMusic();
        Assert.assertTrue(steps.isBBCMusicOpened());
    }

    @Test (description = "Open top news")
    public void openTopNews()
    {
        steps.openTopNews();
        Assert.assertTrue(steps.TopNewsIsOpen());
    }

}
