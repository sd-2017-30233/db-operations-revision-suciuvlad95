package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void test() {
		Driver test= new Driver();
		boolean output= test.connection();
		assertEquals(true,output);
	}

}
