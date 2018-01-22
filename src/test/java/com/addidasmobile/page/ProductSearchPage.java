package com.addidasmobile.page;

import org.hamcrest.Matchers;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Reporter;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;

public class ProductSearchPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "maincategory.productsearch.addidas")
	private QAFWebElement maincategoryProductsearchAddidas;
	@FindBy(locator = "textbox.productsearch.addidas")
	private QAFWebElement textboxProductsearchAddidas;
	@FindBy(locator = "dropdown.womenandmenandclid.productsearch.addidas")
	private QAFWebElement dropdownWomenandmenandclidProductsearchAddidas;
	@FindBy(locator = "morworchildcategory.productsearch.addidas")
	private QAFWebElement morworchildcategoryProductsearchAddidas;
	@FindBy(locator = "prodcategory.productsearch.addidas")
	private QAFWebElement prodcategoryProductsearchAddidas;
	@FindBy(locator = "prodpurpose.productsearch.addidas")
	private QAFWebElement prodpurposeProductsearchAddidas;
	
	

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSubCategoryProductsearchAddidas() {
		return maincategoryProductsearchAddidas;
	}

	public QAFWebElement getTextboxProductsearchAddidas() {
		return textboxProductsearchAddidas;
	}

	public QAFWebElement getDropdownWomenandmenandclidProductsearchAddidas() {
		return dropdownWomenandmenandclidProductsearchAddidas;
	}

	public QAFWebElement getMorworchildcategoryProductsearchAddidas() {
		return morworchildcategoryProductsearchAddidas;
	}

	public QAFWebElement getProdCategoryProductsearchAddidas() {
		return prodcategoryProductsearchAddidas;
	}
	public QAFWebElement getProdPurposeProductsearchAddidas() {
		return prodpurposeProductsearchAddidas;
	}
	@QAFTestStep(description = "user should see shop by dropby")
	public void verifyProductSearch() {
		dropdownWomenandmenandclidProductsearchAddidas.waitForPresent();
		Validator.verifyThat(dropdownWomenandmenandclidProductsearchAddidas.isPresent(), Matchers.equalTo(true));
	}
	
	@QAFTestStep(description = "user selects {0} category")
	
	public void selectProductByMenWomenKid(String mwkCategory)
	{
		dropdownWomenandmenandclidProductsearchAddidas.waitForPresent();
		if(dropdownWomenandmenandclidProductsearchAddidas.isDisplayed()&&dropdownWomenandmenandclidProductsearchAddidas.isPresent())
		{
		dropdownWomenandmenandclidProductsearchAddidas.click();
		}
		else
		{
			Reporter.log("Element not visible");
		}
		
		QAFExtendedWebElement mwkCat= new QAFExtendedWebElement(String.format(
				ConfigurationManager.getBundle().getString(
						"morworchildcategory.productsearch.addidas"), mwkCategory));
		mwkCat.waitForPresent();
		mwkCat.click();
	}
	@QAFTestStep(description = "user selects {0} product category")
	public void selectProductByCategory(String productCategory)
	{
		QAFExtendedWebElement proCat= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("prodcategory.productsearch.addidas"),productCategory));
		proCat.waitForPresent();
		proCat.click();
	}
	@QAFTestStep(description = "user select {0} of product")
	public void selectProductByUsage(String prodPurpose)
	{
		QAFExtendedWebElement purpose= new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("prodpurpose.productsearch.addidas"), prodPurpose));
		purpose.waitForPresent();
		purpose.click();
		
	}
	
	
}
