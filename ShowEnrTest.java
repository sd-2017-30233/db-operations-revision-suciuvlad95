package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowEnrTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.showEnrollments("Chimie");
	
		assertEquals(true,output);
	}

}
