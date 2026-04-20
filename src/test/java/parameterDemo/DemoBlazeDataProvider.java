package parameterDemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoBlazeDataProvider {
	
	@DataProvider(name="testData", parallel=true)
	  public Object[][] testData() {
		  return new Object[][]{
			  {"vetri173","1234"},
			  {"vetri1734","123"}
		  };
	  }
}
