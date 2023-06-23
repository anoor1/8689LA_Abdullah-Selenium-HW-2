package app.pom.itemsearchpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.BasePage;

public class ItemSearchPage extends BasePage {

	
	public ItemSearchPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="q")
	public WebElement searchitemtxtbox;
	
	@FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
	public WebElement searchedheadertext;

	@FindBy(xpath = "//div[contains(text(),'Your search returned no results.')]")
	public WebElement noResultsReturned;
	
	public void searchItem(String item)
	{
		
		enterAndHitEnterKeyword(searchitemtxtbox, item);
		String textactual = getTrimmedElementText(searchedheadertext);

	}

	public void searchWrongItem(String wrongItem){
		enterAndHitEnterKeyword(searchitemtxtbox, wrongItem);
		isElementVisible(noResultsReturned);
	}
	
	
	
}
