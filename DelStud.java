package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class DelStud {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.deleteStud("Cosmin");
		
		assertEquals(true,output);
	}

}
