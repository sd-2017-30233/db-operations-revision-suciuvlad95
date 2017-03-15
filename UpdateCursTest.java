package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateCursTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.updateStud("Vald","Vlad","China");
		
		assertEquals(true,output);
	}

}
