package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddEnrollTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output1=Driver.addStud("11", "2015-08-12", "1", "2");
		
		assertEquals(true,output1);
	}

}
