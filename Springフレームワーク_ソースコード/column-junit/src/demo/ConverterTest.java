package demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConverterTest {

	private Converter c = new Converter();

	@Test
	void testArrayToCsv() {
		String[] ary = { "abc", "def" };
		assertEquals("abc,def", c.arrayToCsv(ary));
	}
}
