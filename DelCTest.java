package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class DelCTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.deleteCurs("Romana");
		
		assertEquals(true,output);
	}

}
