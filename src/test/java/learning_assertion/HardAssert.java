package learning_assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert { // => AssertionError
	@Test
	public void case1() {

		String a = "abc";
		String b = "bcd";
		String c = "abc";
		
		boolean status1 = a.equals(b); // false
		boolean status2 = a.equals(c); // true
		
		Assert.assertTrue(status2);	
		Assert.assertFalse(status1);
		
	}
}