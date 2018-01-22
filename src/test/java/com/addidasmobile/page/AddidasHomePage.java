package com.addidasmobile.page;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddidasHomePage extends WebDriverBaseTestPage<WebDriverTestPage   > {

	@FindBy(locator = "cart.homepage.addidas")
	private QAFWebElement cartHomepageAddidas;
	@FindBy(locator = "productsearch.homepage.addidas")
	private QAFWebElement productsearchHomepageAddidas;
	@FindBy(locator = "profileicon.homepage.addidas")
	private QAFWebElement profileiconHomepageAddidas;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getCartHomepageAddidas() {
		return cartHomepageAddidas;
	}

	public QAFWebElement getProductsearchHomepageAddidas() {
		return productsearchHomepageAddidas;
	}

	public QAFWebElement getProfileiconHomepageAddidas() {
		return profileiconHomepageAddidas;
	}
	
	@QAFTestStep(description = "user is on addidas application")
	public void userIsOnAddidasApplication() {

	}
	
	
	
	@QAFTestStep(description = "user selects shopnow")
	
	public void selectMainmenu()
	{
		getProductsearchHomepageAddidas().verifyPresent();
		getProductsearchHomepageAddidas().click();
	}
	@QAFTestStep(description = "product has been added to cart")
	public void goToCartWindow()
	{
		getCartHomepageAddidas().waitForPresent();
		getCartHomepageAddidas().click();
		CartTestPage cart= new CartTestPage();
		NaviagationTestPage nav= new NaviagationTestPage();
		cart.verifyProductOnCartPage();
		nav.getBackToHomePage();
		System.out.println("first");
		System.out.println("second");
		System.out.println("Third");
		
		
	}

}
