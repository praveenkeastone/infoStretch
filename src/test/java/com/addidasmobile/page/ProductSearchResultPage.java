package com.addidasmobile.page;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.addidasmobile.bean.AddidasBean;
import com.addidasmobile.component.AddidasProductComponent;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.util.Validator;



public class ProductSearchResultPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "component.searchresult.addidas")
	private List<AddidasProductComponent> componentSearchresultAddidas;
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public  List<AddidasProductComponent>  getComponentSearchresultAddidas() {
		return componentSearchresultAddidas;
	}
	@QAFTestStep(description = "user should see the product result")
	public void verifyProductResultPage()
	{
		componentSearchresultAddidas.get(0).getProdnameSearchresultAddidas().waitForPresent();
		Validator.verifyThat(componentSearchresultAddidas.size(), Matchers.greaterThan(0));
		for(AddidasProductComponent comp:getComponentSearchresultAddidas())
		{
			Reporter.log(comp.getProdnameSearchresultAddidas().getText());
			Reporter.log(comp.getProdpriceSearchresultAddidas().getText());
		}
		
	}
	@QAFTestStep(description = "user selects {0} product from product list")
	public void selectProductByIndex(int index)
	{	AddidasBean bean= new AddidasBean();
	bean.setProductName(getComponentSearchresultAddidas().get(index).getProdnameSearchresultAddidas().getText());
	bean.setProductPrice(getComponentSearchresultAddidas().get(index).getProdpriceSearchresultAddidas().getText());
		ConfigurationManager.getBundle().setProperty("select.prod",bean);
		getComponentSearchresultAddidas().get(index).click();
		QAFTestBase.pause(3000);
	}
	

}
