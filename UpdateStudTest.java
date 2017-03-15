package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateStudTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.updateStud("Chimie","Hipocrate","1");
		
		assertEquals(true,output);
	}

}
