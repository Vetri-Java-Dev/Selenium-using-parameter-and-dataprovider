package parameterDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
	@DataProvider(name="testData", parallel=true)
	  public Object[][] testData() {
		  return new Object[][]{
			  {"Selenium"},
			  {"TestNG"},
			  {"Java"},
			  {"Spring boot"}
		  };
	  }
}
