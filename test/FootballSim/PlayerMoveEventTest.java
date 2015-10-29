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
	FootballPlayer player1;
	
	@Before
	public void setup() {
		aGame = new FootballGame();
		player1 = new FootballPlayer("WR");
		coord1 = new FieldCoordinate(39, 45);
		coord2 = new FieldCoordinate(1, 0);
		coord3 = new FieldCoordinate(1, 0);
		coord4 = new FieldCoordinate(1, 0);
		route1 = new Route();
		route1.addStep(coord2);
		route1.addStep(coord3);
		route1.addStep(coord4);
		playerMove1 = new PlayerMoveEvent(100, coord1, route1, player1);
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(playerMove1);
	}

}
