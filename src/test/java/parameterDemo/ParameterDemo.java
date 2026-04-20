package parameterDemo;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;


public class ParameterDemo {
	
	  @Test
	  @Parameters({"value1","value2"})
	  public void addition(int value1, int value2) {
		  System.out.print(value1+value2);
	  }
	  
	  @Test
	  @Parameters({"value1","value2"})
	  public void subtraction(int value1, int value2) {
		  System.out.print(value1-value2);
	  }
	  
  
}
