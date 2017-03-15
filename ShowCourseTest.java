package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShowCourseTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output=Driver.showInfoCourse("Chimie");
		
		assertEquals(true,output);
	}

}
