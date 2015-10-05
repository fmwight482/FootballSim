package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field field1;
	
	@Before
	public void setUpField() {
		field1 = new Field();
	}

	@Test
	public void constructorTest() {
		assertNotNull(field1);
	}
}
