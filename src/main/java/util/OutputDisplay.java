package util;

import java.time.Instant;

public class OutputDisplay {

	public void showText(String text) {

		Instant now = Instant.now();
		System.out.println( "time: " + now + "-" + text);
	}
	
}
