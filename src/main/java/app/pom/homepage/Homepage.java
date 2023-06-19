package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends BasePage {

    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/']")
    public WebElement logo; // find element using this xpath


    @FindBy(xpath = "//input[@id='search']")
    public WebElement search_bar; //find search bar using this xpath

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonSearchSubmit;


    public Homepage() {
        PageFactory.initElements(driver, this);
    }

    public void inputSearchTerm(String searchTerm) {
        clearSendKeysToElement(search_bar, searchTerm);

    }
    public void clickSearchSubmitButton(){
        clickOnElement(buttonSearchSubmit);
    }
    public SearchResultPage doSearch(String searchTerm) {
        inputSearchTerm(searchTerm);
        clickSearchSubmitButton();
        return new SearchResultPage();
    }
}



