package com.addidasmobile.page;

import java.util.NoSuchElementException;

import org.hamcrest.Matchers;
import org.testng.Reporter;

import com.addidasmobile.bean.AddidasBean;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.core.QAFTestBase;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class ProdDetailsPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "prodname.proddetails.addidas")
	private QAFWebElement prodnameProddetailsAddidas;
	@FindBy(locator = "buybutton.proddetails.addidas")
	private QAFWebElement buybuttonProddetailsAddidas;
	@FindBy(locator = "sizechart.proddetail.addidas")
	private QAFWebElement sizechartProddetailsAddidas;
	@FindBy(locator = "addtocart.proddetail.addidas")
	private QAFWebElement addtoCartProddetailsAddidas;
	@FindBy(locator = "paybutton.proddetail.addidas")
	private QAFWebElement paybuttonProddetailsAddidas;
	@FindBy(locator = "sizechartview.detailpage.addidas")
	private QAFWebElement sizeChartViewProddetailsAddidas;	
	
	
	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getProdnameProddetailsAddidas() {
		return prodnameProddetailsAddidas;
	}

	public QAFWebElement getBuybuttonProddetailsAddidas() {
		return buybuttonProddetailsAddidas;
	}

	
	public QAFWebElement getSizeChartProddetailsAddidas() {
		return sizechartProddetailsAddidas;
	}
	public QAFWebElement getAddtoCartProddetailsAddidas() {
		return addtoCartProddetailsAddidas;
	}
	public QAFWebElement getpaybuttonProddetailsAddidas() {
		return paybuttonProddetailsAddidas;
	}
	public QAFWebElement getSizeChartViewProddetailsAddidas() {
		return sizeChartViewProddetailsAddidas;
	}

	@QAFTestStep(description = "user should see product details matching correctly")
	public void verifyProductDetailsPage()
	{
		QAFTestBase.pause(5000);
		Reporter.log(getProdnameProddetailsAddidas().getText());
		Reporter.log(((AddidasBean)ConfigurationManager.getBundle().getProperty("select.prod")).getProductName());
		Validator.verifyThat(getProdnameProddetailsAddidas().getText(),Matchers.containsString(((AddidasBean)ConfigurationManager.getBundle().getProperty("select.prod")).getProductName()));
	}
	@QAFTestStep(description = "user selects buy now")
	public void buyProduct()
	{
		getBuybuttonProddetailsAddidas().waitForPresent();
		getBuybuttonProddetailsAddidas().click();
	}
	@QAFTestStep(description = "size chart should show up.")
	public void verifySizeChart()
	{
		getSizeChartViewProddetailsAddidas().waitForPresent();
		Validator.verifyThat(getSizeChartViewProddetailsAddidas().isDisplayed()&&getSizeChartViewProddetailsAddidas().isPresent(), Matchers.equalTo(true));
	}
	@QAFTestStep(description = "user select {0} size")
	public void selectSize(String sizeChart)
	{
		QAFExtendedWebElement sizeChat= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("sizechart.proddetail.addidas"), sizeChart));
		sizeChat.waitForPresent();
		sizeChat.click();
	}
	
	@QAFTestStep(description = "user select addtoCart")
	public void selectAddtoCart()
	{
		try
		{
			
				if(getAddtoCartProddetailsAddidas().isDisplayed()&&getAddtoCartProddetailsAddidas().isPresent())
			{
				getAddtoCartProddetailsAddidas().click();
			}
		}
		catch (NoSuchElementException ignored)
		{
			Reporter.log("Size is not availble Please select the size which is availble");
			driver.quit();
		}	
		
	}
	
}
