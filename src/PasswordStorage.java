
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordStorage {
	Password ob = new Password();

	@Test
	void addPassword() {

		assertEquals(true, ob.addPassword("hello3AE"));
		assertEquals(false, ob.addPassword("hello1AE"));
		assertEquals(false, ob.addPassword("abcdefg"));
		assertEquals(false, ob.addPassword("abcdefg6"));
		assertEquals(false, ob.addPassword("abcdefgh 1"));
		assertEquals(false, ob.addPassword("abcdefgh7"));
		assertEquals(false, ob.addPassword("abcdefgh1"));
		assertEquals(true, ob.addPassword("abcdefgh5UI"));
		assertEquals(true, ob.addPassword("admin"));
		assertEquals(false, ob.addPassword("admin"));
		assertEquals(true, ob.addPassword("mod"));
		assertEquals(false, ob.addPassword("mod"));

	}

}