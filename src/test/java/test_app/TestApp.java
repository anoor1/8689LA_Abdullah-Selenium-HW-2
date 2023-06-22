package test_app;

import app.pom.addmodifycartpage.AddModifyCartPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import app.pom.createaccountpage.CreateAccountPage;
import app.pom.homepage.Homepage;
import app.pom.itemsearchpage.ItemSearchPage;
import app.pom.loginpage.LoginPage;
import base.BasePage;
import utils.ExcelData;

public class TestApp extends BasePage {


    @Test (priority = 0, groups = {"BAT"})
    public void testNavigationToApplication() {
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }
    
    
    
    @Test (priority = 1, groups = {"BAT"})
    public void testCreateAccountInApplication() {
        CreateAccountPage accountpage = new CreateAccountPage();
        accountpage.createAccount();
        Assert.assertTrue(isElementVisible(accountpage.registeruservalidation));
    }
    
    
    
    @Test (priority = 2, groups = {"BAT"})
    public void testLogin() {
        LoginPage loginpage = new LoginPage();
        loginpage.login();
        Assert.assertTrue(isElementVisible(loginpage.welcompagetext));
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));
    }
    
    
    
    @Test (priority = 3, groups = {"BAT"},dataProvider = "datacreateaccount")
    public void testCreateAccountUsingDataProvider(String fName,String lName,String emailId,String pass) {
        CreateAccountPage accountpage = new CreateAccountPage();
        accountpage.createAccountwithParam(fName, lName, emailId, pass);
        Assert.assertTrue(isElementVisible(accountpage.registeruservalidation));
    }
    
    
    
    @DataProvider(name="datacreateaccount")
    public String[][] createAccountDataProvider()
    {
    	
    	String path= System.getProperty("user.dir")+"\\src\\main\\resources\\externalData\\testdata.xlsx";
		ExcelData ex=new ExcelData(path);
		String data[][]=ex.readStringArrays("createaccount");
		return data;
    	
    }
    
    
    
    
    @Test (priority = 4, groups = {"BAT"},dataProvider = "datalogin")
    public void testLoginUsingDataProvider(String emailId,String password) {
        LoginPage loginpage = new LoginPage();
        loginpage.loginwithparam(emailId, password);
        Homepage homepage = new Homepage();

        Assert.assertTrue(isElementVisible(homepage.logo));   
        }
    
    
    
    @DataProvider(name="datalogin")
    public String[][] loginDataProvider()
    {
    	
    	String path= System.getProperty("user.dir")+"\\src\\main\\resources\\externalData\\testdata.xlsx";
		ExcelData ex=new ExcelData(path);
		String data[][]=ex.readStringArrays("signin");
		return data;
    	
    }
    
    
    
    @Test (priority = 5, groups = {"BAT"},dataProvider = "searchItems")
    public void testSearchItemDataProvider(String item) {
        ItemSearchPage page = new ItemSearchPage();
        page.searchItem(item);
        }
    
    
    
    @DataProvider(name="searchItems")
    public String[][] searchItemProvider()
    {
    	
    	String path= System.getProperty("user.dir")+"\\src\\main\\resources\\externalData\\testdata.xlsx";
		ExcelData ex=new ExcelData(path);
		String data[][]=ex.readStringArrays("searchdata");
		return data;
    	
    }

    @Test (priority = 6, groups = {"BAT"})
    public void testAddModifyCartData() {
        ItemSearchPage page = new ItemSearchPage();
        page.searchItem("Duffle Bag");
        AddModifyCartPage add=new AddModifyCartPage();
        add.addtoCartItem();
        add.modifyItem();
        add.removeCartItem();
    }

    @Test (priority = 7, groups = {"BAT"})
    public void testCategoryResult(){
        Homepage homepage = new Homepage();
        homepage.doFilterTo();
        Assert.assertTrue(isElementVisible(homepage.categoryJacketResult));
    }

   @Test (priority=8, groups = {"BAT"})
    public void testSearchInvalidResult(){
        ItemSearchPage page = new ItemSearchPage();
        page.searchWrongItem("12345");
        Assert.assertTrue((isElementVisible(page.noResultsReturned)));
   }

}
