package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RouteTest {
	Route route1;
	Route route2;
	FieldCoordinate coord1;
	FieldCoordinate coord2;
	FieldCoordinate coord3;
	
	@Before
	public void setup() {
		route1 = new Route();
		coord1 = new FieldCoordinate(7, 0);
		coord2 = new FieldCoordinate(0, 1);
		coord3 = new FieldCoordinate(-1, 0);
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(route1);
	}
	
	@Test
	public void copyConstructorTest1() {
		route1.addStep(coord1);
		route1.addStep(coord2);
		route1.addStep(coord3);
		route2 = new Route(route1);
		assertEquals(route1, route2);
	}
	
	@Test
	public void copyConstructorTest2() {
		route1.addStep(coord3);
		route1.addStep(coord2);
		route1.addStep(coord1);
		route2 = new Route(route1);
		assertEquals(route1, route2);
	}
	
	@Test
	public void addRemoveSetpsTest() {
		assertEquals(route1.countSteps(), 0);
		route1.addStep(coord1);
		route1.addStep(coord2);
		route1.addStep(coord3);
		assertEquals(route1.countSteps(), 3);
		FieldCoordinate coord4 = route1.getNextStep();
		assertEquals(coord4, coord1);
		assertEquals(route1.countSteps(), 2);
	}
	
	@Test
	public void equalsTest1() {
		route2 = new Route();
		assertEquals(route1, route2);
		route1.addStep(coord1);
		route1.addStep(coord2);
		route1.addStep(coord3);
		route2.addStep(coord1);
		route2.addStep(coord2);
		route2.addStep(coord3);
		assertEquals(route1, route2);
	}
	
	@Test
	public void equalsTest2() {
		route2 = new Route();
		route1.addStep(coord1);
		assertNotEquals(route1, route2);
		route1.addStep(coord2);
		route1.addStep(coord3);
		route2.addStep(coord2);
		assertNotEquals(route1, route2);
		route2.addStep(coord3);
		route2.addStep(coord1);
		assertNotEquals(route1, route2);
	}
	
	@Test
	public void hashCodeTest() {
		route2 = new Route();
		assertEquals(route1.hashCode(), route2.hashCode());
		route1.addStep(coord1);
		route1.addStep(coord2);
		route1.addStep(coord3);
		route2.addStep(coord1);
		route2.addStep(coord2);
		route2.addStep(coord3);
		assertEquals(route1.hashCode(), route2.hashCode());
	}
}
