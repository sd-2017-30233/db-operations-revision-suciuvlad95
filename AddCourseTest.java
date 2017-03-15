package first;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddCourseTest {

	@Test
	public void test() {
		Driver.connection();
		boolean output= Driver.addCourse("10", "Romana", "Cosmina Suciu", "1");
		assertEquals(true,output);
	}
}
