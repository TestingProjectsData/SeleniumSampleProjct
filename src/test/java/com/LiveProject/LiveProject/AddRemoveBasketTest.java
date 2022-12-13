package com.LiveProject.LiveProject;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.ExtentManager;
import Base.Hooks;
import PageObject.HomePage;
import PageObject.ShopContentPanel;
import PageObject.ShopHomePage;
import PageObject.ShopProductPage;
import PageObject.ShoppingCart;
@Listeners(Resources.Listeners.class)
public class AddRemoveBasketTest extends Hooks{

	public AddRemoveBasketTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@ Test 
	public void addRemoveItem () throws Exception {
		
		ExtentManager.log("Starting AddRemoveBasketTest...");
		
		HomePage home = new HomePage ();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		home.getTestStoreLink().click();
		
		ShopHomePage shop = new ShopHomePage ();
		ExtentManager.pass("Reach the shop homepage");
		shop.getProdOne().click();
	
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Reach the shop product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("L");
		ExtentManager.pass("Have successfully selected product size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have successfully incresed quantity");
		shopProd.getAddToCartBtn().click();
//driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		ExtentManager.pass("Have successfully add prodyct to basket");
		
		
		ShopContentPanel panel = new ShopContentPanel();
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		waitForElementInvisible(panel.getContinueShopBtn(), Duration.ofSeconds(5));
	//  wait.until(ExpectedConditions.invisibilityOf(panel.getContinueShopBtn()));
		panel.getContinueShopBtn().click();
		shopProd.getHomepageLink().click();
		shop.getProdTwo().click();
		shopProd.getAddToCartBtn().click();
		panel.getCheckoutBtn().click();
		
		ShoppingCart shopCart = new ShoppingCart ();
		shopCart.getDeleteItemTwo().click();
	// WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		waitForElementInvisible(shopCart.getDeleteItemTwo(), Duration.ofSeconds(5));
	//	  wait.until(ExpectedConditions.invisibilityOf(shopCart.getDeleteItemTwo()));
		try {
		Assert.assertEquals(shopCart.getTotalAmount().getText(), "$45.24");
		ExtentManager.pass("The total amount matches the expexted amount");
		} catch (AssertionError e){
			Assert.fail(" The total amount did not match the expexted amount" + shopCart.getTotalAmount().getText() + "but expected $45.24");
		ExtentManager.fail("The total amount did not matched");
		}
		System.out.println(shopCart.getTotalAmount().getText());
		
	//	45,24
		
}
}
