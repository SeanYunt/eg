package net.yunt;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q4Test {
	
	private Q4 testSubject;	
	
	@BeforeTest
	private void initStuff() {
		testSubject = new Q4();
	}

	   @DataProvider(name = "test1")
	   public static Object[][] inputs() {
	      return new Object[][] {{4, 2, "100"}, {10, 10, "10"}, {15, 16, "F"}, {0,0,"0"}};
	   }	
	
  @Test(dataProvider = "test1")
  public void f(Integer value, Integer base, String expected) {
	  Assert.assertEquals(testSubject.itoa(value.intValue(), base.intValue()), expected);
  }
}
