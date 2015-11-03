package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballGameTest {
	FootballGame aGame;
	Route route1;
	
	@Before
	public void setup() {
		aGame = new FootballGame();
		route1 = new Route();
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(aGame);
		assertNotNull(aGame.fbField);
		assertNotNull(aGame.fbTimer);
		assertNotNull(aGame.QB);
		assertNotNull(aGame.WR);
	}
	
	@Test
	public void runRouteTest() throws FootballException {
		/*route1.addStep(new FieldCoordinate(7, 0));
		route1.addStep(new FieldCoordinate(0, 1));
		route1.addStep(new FieldCoordinate(-1, 0));
		aGame.runRoute(new FieldCoordinate(23, 15), route1, aGame.WR);*/
		fail("Not fully implemented");
	}
}
