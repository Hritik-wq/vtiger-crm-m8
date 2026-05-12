package generic_utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JavaUtility {
	public static int generateRandomNumber() {
		double ran = Math.random()*10000;
		int random = (int) ran;
		return random;
	}
	
public static String generateTime() {
		
		LocalDateTime now = LocalDateTime.now();
		String time = DateTimeFormatter.ofPattern("HHmmss_ddMMyyyy").format(now);
		return time;
	}

}
