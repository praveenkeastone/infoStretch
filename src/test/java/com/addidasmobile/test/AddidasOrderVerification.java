package com.addidasmobile.test;



import org.testng.annotations.Test;

import com.addidasmobile.page.AddidasHomePage;
import com.addidasmobile.page.CartTestPage;
import com.addidasmobile.page.NaviagationTestPage;
import com.addidasmobile.page.ProdDetailsPage;
import com.addidasmobile.page.ProductSearchPage;
import com.addidasmobile.page.ProductSearchResultPage;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class AddidasOrderVerification extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void testApp()
	{
	AddidasHomePage page= new AddidasHomePage();
	page.selectMainmenu();
	ProductSearchPage prod= new ProductSearchPage();
	prod.verifyProductSearch();
	prod.selectProductByMenWomenKid("Men");
	prod.selectProductByCategory("Shoes");
	prod.selectProductByUsage("Running");
	ProductSearchResultPage search= new ProductSearchResultPage();
	search.verifyProductResultPage();
	search.selectProductByIndex(3);
	ProdDetailsPage details= new ProdDetailsPage();
	details.verifyProductDetailsPage();
	details.buyProduct();
	details.verifySizeChart();
	details.selectSize("7.5");
	details.selectAddtoCart();
	page.goToCartWindow();
	CartTestPage cart= new CartTestPage();
	cart.verifyProductOnCartPage();
	NaviagationTestPage nav= new NaviagationTestPage();
	nav.getBackToHomePage();
		
	}
	
}
