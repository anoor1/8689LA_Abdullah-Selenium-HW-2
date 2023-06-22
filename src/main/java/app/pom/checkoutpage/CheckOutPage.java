package app.pom.checkoutpage;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BasePage {

    public CheckOutPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="top-cart-btn-checkout")
    public WebElement checkOutButton;

    @FindBy(xpath = "//input[@id='VC41YIL']")
    public WebElement inputCompany;

    @FindBy(xpath = "//input[@id = 'B22XYI4']")
    public WebElement inputStreetAddress;

    @FindBy(xpath = "//input[@id='PMON5SM']")
    public WebElement inputCity;

    @FindBy(xpath = "//select[@class='select']")
    public WebElement stateProvinceDropdown;

    @FindBy(xpath = "//input[@id='HPF3581']")
    public WebElement zipInput;

    @FindBy(xpath = "//select[@id='PKXG6NA']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//input[@id='RR4GA7V']")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//*[@id='checkout-shipping-method-load']/table/tbody/tr[1]/td[1]/input")
    public WebElement shippingMethodButton;

    @FindBy(xpath = "//*[@id='shipping-method-buttons-container']/div/button")
    public WebElement nextButton;

    public void clickOnCheckoutButton(){
        safeClickOnElement(checkOutButton);
    }
    public void inputCompanyName(String companyName){
        sendKeysToElement(inputCompany, companyName);
    }
    public void setInputStreetAddress(String streetAddress){
        sendKeysToElement(inputStreetAddress, streetAddress);
    }
    public void setInputCity(String nameOfCity){
        sendKeysToElement(inputStreetAddress, nameOfCity);
    }

    public void setStateProvinceDropdown(){
        clickOnElement(stateProvinceDropdown);
    }
    public void setZipInput(String zipCode ){
        sendKeysToElement(zipInput, zipCode);
    }


}
