package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowStudTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.showInfoStudent("Vald");
	
		assertEquals(true,output);
	}

}
