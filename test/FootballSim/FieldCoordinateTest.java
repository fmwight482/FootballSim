package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldCoordinateTest {
	FieldCoordinate coord1;
	FieldCoordinate coord2;
	FieldCoordinate coord3;
	FieldCoordinate coord4;
	FieldCoordinate coord5;
	FieldCoordinate coord6;
	FieldCoordinate coord7;
	FieldCoordinate coord8;
	FieldCoordinate coord9;
	
	@Before
	public void createCoords() throws FootballException {
		coord1 = new FieldCoordinate(1, 1);
		coord2 = new FieldCoordinate(coord1);
		coord3 = new FieldCoordinate(0, 4);
		coord4 = new FieldCoordinate(-3, 5);
		coord5 = new FieldCoordinate(10, 10);
		coord6 = new FieldCoordinate(coord4, coord5);
		coord7 = new FieldCoordinate(coord1, coord2);
		coord8 = new FieldCoordinate(119, 52);
	}
	

	@Test
	public void constructorTest() {
		assertNotNull(coord1);
		assertNotNull(coord3);
		assertNotNull(coord4);
		assertNotNull(coord6);
		assertNotNull(coord8);
	}
	
	@Test (expected=FootballException.class)
	public void vertLargeOutOfBoundsTest() throws FootballException {
		coord9 = new FieldCoordinate(coord8, new FieldCoordinate(1, 0));
	}
	
	@Test (expected=FootballException.class)
	public void horzLargeOutOfBoundsTest() throws FootballException {
		coord9 = new FieldCoordinate(coord8, new FieldCoordinate(0, 1));
	}
	
	@Test (expected=FootballException.class)
	public void vertSmallOutOfBoundsTest() throws FootballException {
		coord9 = new FieldCoordinate(coord3, coord4);
	}
	
	@Test (expected=FootballException.class)
	public void horzSmallOutOfBoundsTest() throws FootballException {
		coord9 = new FieldCoordinate(coord1, new FieldCoordinate(0, -3));
	}
	
	@Test
	public void getVertTest() {
		assertEquals(coord1.getVert(), 1);
		assertEquals(coord2.getVert(), 1);
		assertEquals(coord3.getVert(), 0);
		assertEquals(coord4.getVert(), -3);
	}
	
	@Test
	public void getHorzTest() {
		assertEquals(coord1.getHorz(), 1);
		assertEquals(coord2.getHorz(), 1);
		assertEquals(coord3.getHorz(), 4);
		assertEquals(coord4.getHorz(), 5);
	}
	
	@Test
	public void equalsTest() {
		assertNotEquals(coord1, coord3);
		assertNotEquals(coord2, 4);
		assertEquals(coord1, coord2);
	}
	
	@Test
	public void hashCodeTest() {
		assertEquals(coord1.hashCode(), coord2.hashCode());
		assertNotEquals(coord1.hashCode(), coord4.hashCode());
	}
	
	@Test
	public void toStringTest() {
		assertEquals(coord1.toString(), "(1, 1)");
		assertEquals(coord8.toString(), "(119, 52)");
	}
}
