package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballGameTest {
	FootballGame aGame;
	
	@Before
	public void setup() {
		aGame = new FootballGame();
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
	public void runRouteTest() {
		fail("not yet implemented");
	}
}
