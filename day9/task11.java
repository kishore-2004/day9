package day9;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class task11 {
	Integer a,b,c;
  @Test(dataProvider = "dp")
  public void add(Integer a, Integer b) {
	 c=a+b;
	 Assert.assertEquals(c, a+b);
  }
  
  @Test(dataProvider = "dp")
  public void sub(Integer a, Integer b) {
	 c=a-b;
	 Assert.assertEquals(c, a-b);
  }

  
  @Test(dataProvider = "dp")
  public void multi(Integer a, Integer b) {
	 c=a*b;
	 Assert.assertEquals(c, a*b);
  }
  
  @Test(dataProvider = "dp")
  public void div(Integer a, Integer b) {
	 c=a/b;
	 Assert.assertEquals(c, a/b);
  }
   
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 10, 15 },
      new Object[] { 12, 10 },
      
    };
  }
}
