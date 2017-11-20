import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class squareTest2 {

	@Test
	public void test() {
		BuddyInfo test = new BuddyInfo("Tom", "Carleton", "647 999 1230");
		
		String output = test.getName();

		assertEquals("Tom", output);
		

	}


}
