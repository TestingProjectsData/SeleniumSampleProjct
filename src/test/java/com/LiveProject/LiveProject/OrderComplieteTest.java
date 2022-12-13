package com.LiveProject.LiveProject;

import java.io.IOException;


import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.ExtentManager;
import Base.Hooks;
import PageObject.HomePage;
import PageObject.OrderFormDelivery;
import PageObject.OrderFormPayment;
import PageObject.OrderFormPersonaInfo;
import PageObject.OrderFormShippingMethod;
import PageObject.ShopContentPanel;
import PageObject.ShopHomePage;
import PageObject.ShopProductPage;
import PageObject.ShoppingCart;
import Resources.*;


@Listeners(Resources.Listeners.class)
public class OrderComplieteTest extends Hooks {

	public OrderComplieteTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@ Test 
	public void endToEndTest () throws InterruptedException, IOException {
		ExtentManager.log("Starting OrderComplieteTest...");
		
		HomePage home = new HomePage ();
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		home.getTestStoreLink().click();
		ExtentManager.pass("Reach the shop homepage");
		ShopHomePage shop = new ShopHomePage ();
		shop.getProdOne().click();
		ExtentManager.pass("Have successfully clicked on product" );
		ShopProductPage shopProd = new ShopProductPage();
		ExtentManager.pass("Have successfully reach product page");
		Select option = new Select(shopProd.getSizeOption());
		option.selectByVisibleText("L");
		ExtentManager.pass("Have successfully selected product size");
		shopProd.getQuantIncrease().click();
		ExtentManager.pass("Have successfully increased quantity");
		shopProd.getAddToCartBtn().click();
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ExtentManager.pass("Have successfully add prodyct to basket");
		ShopContentPanel panel = new ShopContentPanel();
		panel.getCheckoutBtn().click();
		
				
		ShoppingCart shopCart = new ShoppingCart ();
		shopCart.getHavePromo().click();
	//	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ExtentManager.pass("Have successfully selected promo button");
		shopCart.getPromoTextbox().sendKeys("20OFF");
		shopCart.getPromoAddBtn().click();
		shopCart.getProceedCheckoutBtn().click();
		ExtentManager.pass("Have successfully selected Checkout Button");
		OrderFormPersonaInfo persInfo = new OrderFormPersonaInfo ();
		persInfo.getGenderMr().click();
		persInfo.getFirstNameField().sendKeys("Oktawio");
		persInfo.getLastnameField().sendKeys("Bala");
		persInfo.getEmailField().sendKeys("oktawio1@gmail.com");
		persInfo.getTermsConditionsCheckbox().click();
		persInfo.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered customer details");
		
		OrderFormDelivery formDel = new OrderFormDelivery ();
		formDel.getAddressField().sendKeys("123 Main Street");
		formDel.getCityField().sendKeys("London");
		Select state = new Select(formDel.getStateDropdown());
		state.selectByVisibleText("Texas");
		formDel.getPostcodeField().sendKeys("11022");
		Thread.sleep(3000);
		formDel.getContinueBtn().click();
		ExtentManager.pass("Have successfully entered delivery details");
		
		
		OrderFormShippingMethod shipM = new OrderFormShippingMethod ();
		shipM.getDeliveryMsgTextbox().sendKeys("If I am not in please leave to next door");
		shipM.getContinueBtn().click();
		ExtentManager.pass("Have successfully selected shipping method");
		
		OrderFormPayment payment = new OrderFormPayment ();
		payment.getPayByCheckRadioBtn().click();
		payment.getTermsConditionsCheckbox().click();
		Thread.sleep(3000);
		payment.getOrderBtn().click();
		ExtentManager.pass("Have successfully passed order");
		
	}
}
