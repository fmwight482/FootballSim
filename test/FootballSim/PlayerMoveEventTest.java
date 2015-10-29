package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerMoveEventTest {
	FootballGame aGame;
	PlayerMoveEvent playerMove1;
	PlayerMoveEvent playerMove2;
	FieldCoordinate coord1;
	FieldCoordinate coord2;
	FieldCoordinate coord3;
	FieldCoordinate coord4;
	Route route1;
	Route route2;
	FootballPlayer player1;
	FootballPlayer player2;
	
	@Before
	public void setup() throws FootballException {
		aGame = new FootballGame();
		player1 = new FootballPlayer("WR");
		player2 = new FootballPlayer("QB");
		coord1 = new FieldCoordinate(39, 45);
		coord2 = new FieldCoordinate(1, 0);
		coord3 = new FieldCoordinate(1, 0);
		coord4 = new FieldCoordinate(1, 0);
		route1 = new Route();
		route1.addStep(coord2);
		route1.addStep(coord3);
		route1.addStep(coord4);
		route2 = new Route(route1);
		route2.getNextStep();
		playerMove1 = new PlayerMoveEvent(100, coord1, route1, player1);
		playerMove2 = new PlayerMoveEvent(playerMove1);
	}
	
	@Test
	public void constructorTest() throws FootballException {
		assertNotNull(playerMove1);
		assertNotNull(playerMove2);
		
		assertEquals(playerMove1.getRoute(), route2);
		assertEquals(playerMove1.getOldCoord(), coord1);
		assertEquals(playerMove1.getNewCoord(), new FieldCoordinate(coord1, coord2));
		assertEquals(playerMove1.getPlayer(), player1);
		
		assertEquals(playerMove2.getRoute(), route2);
		assertEquals(playerMove2.getOldCoord(), coord1);
		assertEquals(playerMove2.getNewCoord(), new FieldCoordinate(coord1, coord2));
		assertEquals(playerMove2.getPlayer(), player1);
	}
	
	@Test
	public void getterSetterTest() {
		playerMove1.setRoute(route1);
		playerMove1.setOldCoord(coord2);
		playerMove1.setNewCoord(coord2);
		playerMove1.setPlayer(player2);
		assertEquals(playerMove1.getRoute(), route1);
		assertEquals(playerMove1.getOldCoord(), coord2);
		assertEquals(playerMove1.getNewCoord(), coord2);
		assertEquals(playerMove1.getPlayer(), player2);
	}
}
