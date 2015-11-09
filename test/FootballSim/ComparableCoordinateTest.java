package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComparableCoordinateTest {
	ComparableCoordinate coord1;
	ComparableCoordinate coord2;
	ComparableCoordinate coord3;
	ComparableCoordinate coord4;
	
	@Before
	public void setup() {
		coord1 = new ComparableCoordinate(1, 0, 0);
		coord2 = new ComparableCoordinate(0, 1, 50);
		coord3 = new ComparableCoordinate(1, 1, 100);
		coord4 = new ComparableCoordinate(coord1);
	}

	@Test
	public void constructorTest() {
		assertNotNull(coord1);
		assertNotNull(coord2);
		assertNotNull(coord3);
		assertEquals(coord1.getTime(), 0);
		assertEquals(coord2.getTime(), 50);
		assertEquals(coord3.getTime(), 100);
	}
	
	@Test
	public void compareToTest() {
		assertEquals(coord1.compareTo(coord2), -1);
		assertEquals(coord1.compareTo(coord3), -1);
		assertEquals(coord1.compareTo(coord4), 0);
		assertEquals(coord2.compareTo(coord1), 1);
		assertEquals(coord2.compareTo(coord3), -1);
	}
	
	@Test
	public void getFieldCoordinateTest() {
		FieldCoordinate fCoord = coord1.getFieldCoordinate();
		assertNotNull(fCoord);
		assertEquals(1, fCoord.getVert());
		assertEquals(0, fCoord.getHorz());
	}
}
