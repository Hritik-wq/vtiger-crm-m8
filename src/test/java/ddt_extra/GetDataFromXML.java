package ddt_extra;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GetDataFromXML {
	
	@Parameters({"fn","ln"})
	@Test
	public void printFullName(String fn, String ln) {
		System.out.println(fn + " " + ln );
	}
}