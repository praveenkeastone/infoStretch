package com.addidasmobile.component;

import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebComponent;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;

public class AddidasProductComponent extends QAFWebComponent{
	
	public AddidasProductComponent(String locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "prodname.searchresult.addidas")
	private QAFWebElement prodnameSearchresultAddidas;
	@FindBy(locator = "prodprice.searchresult.addidas")
	private QAFWebElement prodpriceSearchresultAddidas;
	
	public QAFWebElement getProdnameSearchresultAddidas() {
		return prodnameSearchresultAddidas;
	}

	public QAFWebElement getProdpriceSearchresultAddidas() {
		return prodpriceSearchresultAddidas;
	}
	

}
