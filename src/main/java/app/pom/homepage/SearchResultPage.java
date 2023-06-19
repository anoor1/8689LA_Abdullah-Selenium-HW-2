package app.pom.homepage;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage {


    @FindBy (xpath= "//a[@class='product-item-link']")
    public WebElement textSearchTerm;

    public SearchResultPage(){
        PageFactory.initElements(driver, this);
    }
    public List<WebElement> getSearchResults(){
        return driver.findElements(By.xpath("//img[@class='product-image-photo']"));
    }
}
