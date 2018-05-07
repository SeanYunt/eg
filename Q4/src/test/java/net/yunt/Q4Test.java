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
		return new Object[][] {{4, 2, "100"}, {10, 10, "10"}, {1, 16, "1"}, {0,0,"0"},{1, 2, "1"},{7, 2, "111"},{2, 8, "2"},{10,16,"a"},{10,8,"12"},{10,2,"1010"},{-5,10,"-5"},
			{256,16,"100"}, {256,8,"400"},{256,2,"100000000"},{1,10,"1"},{1,2,"1"},{1,8,"1"},{1,16,"1"}};
	}	
	
	@Test(dataProvider = "test1")
	public void f(Integer value, Integer base, String expected) {
		Assert.assertEquals(testSubject.itoa(value.intValue(), base.intValue()), expected);
	}
}
