package com.addidasmobile.page;

import java.util.List;

import org.hamcrest.Matchers;

import com.addidasmobile.bean.AddidasBean;
import com.addidasmobile.component.CartComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.util.Validator;

public class CartTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	
	@FindBy(locator = "prodcomponent.cartpage.addidas")
	private List<CartComponent> prodComponentCartpageAddidas;
	

	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	
	public List<CartComponent> getProdComponentCartpageAddidas() {
		return prodComponentCartpageAddidas;
	}

	public void verifyProductOnCartPage()
	{
		prodComponentCartpageAddidas.get(0).waitForPresent();
		for(CartComponent comp: getProdComponentCartpageAddidas())
		{
			if(comp.getProdnameCartpageAddidas().getText().equals(((AddidasBean)ConfigurationManager.getBundle().getProperty("select.prod")).getProductName()))
			{
				Validator.verifyThat(comp.getProdnameCartpageAddidas().getText(),Matchers.containsString(((AddidasBean)ConfigurationManager.getBundle().getProperty("select.prod")).getProductName()));
				Validator.verifyThat(comp.getProdpriceCartpageAddidas().getText(),Matchers.containsString(((AddidasBean)ConfigurationManager.getBundle().getProperty("select.prod")).getProductPrice()));
				
			}
		}
	}
}
