import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();
    private static final String SEARCH_TERM = "ltu";

    @BeforeSuite
    public static void setUP() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "search google")
    public static void searchOnGoogle() throws InterruptedException{

        //Expect erroer when testing
        //String textFel = "Llkfsafaeelöfmaöksemftu";
        driver.get(Utils.BASE_URL);
        GoogleSearch search = new GoogleSearch(driver);
        search.acptTerms();
        Thread.sleep(1000);
        search.enterSearchTerm(SEARCH_TERM);
        Thread.sleep(1000);
        search.clickSearch();
        Assert.assertTrue(search.searchForStringInResult(SEARCH_TERM));
        Thread.sleep(3000);
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}