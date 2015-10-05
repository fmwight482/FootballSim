package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FieldTest {
	Field field1;
	FootballPlayer qb1;
	FootballPlayer wr1;
	FootballPlayer cb1;
	FieldCoordinate coord1;
	FieldCoordinate coord2;
	
	@Before
	public void setUpField() {
		field1 = new Field();
		qb1 = new FootballPlayer("QB");
		wr1 = new FootballPlayer("WR");
		cb1 = new FootballPlayer("CB");
		coord1 = new FieldCoordinate(100, 30);
		coord2 = new FieldCoordinate(90, 25);
	}

	@Test
	public void constructorTest() {
		assertNotNull(field1);
		assertEquals(field1.getPlayerNumAt(coord1), 0);
		assertEquals(field1.getPlayerNumAt(new FieldCoordinate(0, 52)), 0);
	}
	
	@Test
	public void insertPlayerTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		assertEquals(field1.getPlayerAt(coord1), qb1);
	}
	
	@Test (expected=FootballException.class)
	public void insertPlayerCollisionTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		field1.insertPlayer(coord1, wr1);
	}
	
	@Test (expected=FootballException.class)
	public void insertPlayerAtInvalidSmallVertTest() throws FootballException {
		field1.insertPlayer(new FieldCoordinate(-1, 30), wr1);
	}
	
	@Test (expected=FootballException.class)
	public void insertPlayerAtInvalidLargeVertTest() throws FootballException {
		field1.insertPlayer(new FieldCoordinate(120, 30), wr1);
	}
	
	@Test (expected=FootballException.class)
	public void insertPlayerAtInvalidSmallHorzTest() throws FootballException {
		field1.insertPlayer(new FieldCoordinate(20, -1), wr1);
	}
	
	@Test (expected=FootballException.class)
	public void insertPlayerAtInvalidLargeHorzTest() throws FootballException {
		field1.insertPlayer(new FieldCoordinate(20, 53), wr1);
	}
	
	@Test
	public void movePlayerTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		field1.movePlayer(coord1, coord2);
		assertEquals(field1.getPlayerNumAt(coord1), 0);
		assertNotEquals(field1.getPlayerNumAt(coord2), 0);
		assertEquals(field1.getPlayerAt(coord2), qb1);
	}
	
	@Test (expected=FootballException.class)
	public void checkPlayerMovedTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		field1.movePlayer(coord1, coord2);
		field1.getPlayerAt(coord1);
	}
	
	@Test (expected=FootballException.class)
	public void movePlayerToOcupiedSpaceTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		field1.insertPlayer(coord2, wr1);
		field1.movePlayer(coord1, coord2);
	}
	
	@Test (expected=FootballException.class)
	public void movePlayerFromEmptyTileTest() throws FootballException {
		field1.movePlayer(coord1, coord2);
	}
	
	@Test
	public void toStringTest() throws FootballException {
		field1.insertPlayer(coord1, qb1);
		field1.insertPlayer(coord2, wr1);
		field1.printField();
		String fieldString = field1.toString();
		assertNotNull(fieldString);
		assertTrue(fieldString.length() > 903);
	}
}
