package com.addidasmobile.page;

import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class NaviagationTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "closebutton.cartpage.addidas")
	private QAFWebElement closebuttonCartpageAddidas;
	@FindBy(locator = "navigatebutton.proddetails.addidas")
	private QAFWebElement navigatebuttonProddetailsAddidas;
	@FindBy(locator = "homeicon.homepage.addidas")
	private QAFWebElement homeiconHomepageAddidas;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getClosebuttonCartpageAddidas() {
		return closebuttonCartpageAddidas;
	}

	public QAFWebElement getNavigatebuttonProddetailsAddidas() {
		return navigatebuttonProddetailsAddidas;
	}

	public QAFWebElement getHomeiconHomepageAddidas() {
		return homeiconHomepageAddidas;
	}
	
	public void getBackToHomePage()
	{
		getClosebuttonCartpageAddidas().waitForPresent();
		getClosebuttonCartpageAddidas().click();
		getNavigatebuttonProddetailsAddidas().waitForPresent();
		getNavigatebuttonProddetailsAddidas().click();
		QAFTestBase.pause(3000);
		getHomeiconHomepageAddidas().waitForPresent();
		getHomeiconHomepageAddidas().click();
		AddidasHomePage page= new AddidasHomePage();
		page.selectMainmenu();
		ProductSearchPage search= new ProductSearchPage();
		search.verifyProductSearch();
		QAFTestBase.pause(3000);
		getHomeiconHomepageAddidas().click();
		page.selectMainmenu();
		search.verifyProductSearch();
	
	}

}
