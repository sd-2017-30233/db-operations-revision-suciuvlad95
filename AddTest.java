package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void addtest() {
		Driver.connection();
		boolean output=Driver.addStud("8", "Albert", "1995-19-11", "Filnanjaro");
		
		assertEquals(true,output);
	}

}
