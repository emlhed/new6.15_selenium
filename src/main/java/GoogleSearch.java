import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoogleSearch extends PageObject {

    @FindBy(name = "q")
    private WebElement searchField;


    @FindBy(name = "btnK")
    private WebElement searchButton;

    @FindBy(id = "search")
    private WebElement allSearchResult;

    @FindBy(id = "L2AGLb")
    private WebElement acceptanceTermsButton;

    public GoogleSearch (WebDriver driver) {
        super(driver);
    }

    public void enterSearchTerm(String searchTerm){
        searchField.sendKeys(searchTerm);
    }

    public void clickSearch(){
        searchButton.click();
    }

    public void acptTerms(){
        if (acceptanceTermsButton.isDisplayed()){
            acceptanceTermsButton.click();
        }
    }

    public boolean searchForStringInResult(String text){
       return allSearchResult.getText().contains(text);
    }

}
