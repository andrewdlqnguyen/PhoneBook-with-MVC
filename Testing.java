import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuddyInfoTest {

	@Test
	void testBuddyInfo() {
		BuddyInfo test = new BuddyInfo("Tom", "Carleton", "647 999 1230");
		String output = test.getName();

		assertEquals("Tom", output);
	}

	@Test
	void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAddress() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPhoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPhoneNumber() {
		fail("Not yet implemented");
	}

}
