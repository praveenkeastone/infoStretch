package com.addidasmobile.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class CartComponent extends QAFWebComponent {

	public CartComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(locator = "prodname.cartpage.addidas")
	private QAFWebElement prodnameCartpageAddidas;
	@FindBy(locator = "prodprice.cartpage.addidas")
	private QAFWebElement prodpriceCartpageAddidas;
	
	public QAFWebElement getProdnameCartpageAddidas() {
		return prodnameCartpageAddidas;
	}

	public QAFWebElement getProdpriceCartpageAddidas() {
		return prodpriceCartpageAddidas;
	}

}
