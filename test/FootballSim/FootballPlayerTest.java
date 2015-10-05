package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballPlayerTest {
	FootballPlayer qb1;
	FootballPlayer wr1;
	FootballPlayer cb1;
	FootballPlayer noPosPlayer;
	
	@Before
	public void setUpPlayers() {
		qb1 = new FootballPlayer("QB");
		wr1 = new FootballPlayer("WR");
		cb1 = new FootballPlayer("CB");
		noPosPlayer = new FootballPlayer("no position");
	}

	@Test
	public void constructorTest() {
		assertNotNull(qb1);
		assertNotNull(wr1);
		assertNotNull(cb1);
		assertNotNull(noPosPlayer);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(qb1.toString(), "Q");
		assertEquals(wr1.toString(), "W");
		assertEquals(cb1.toString(), "C");
		assertEquals(noPosPlayer.toString(), "?");
	}
	
	@Test
	public void getterSetterTest() {
		qb1.setArm(90);
		qb1.setSpeed(45);
		qb1.setCatching(3);
		noPosPlayer.setPos("still no position");
		
		assertEquals(qb1.getArm(), 90);
		assertEquals(qb1.getSpeed(), 45);
		assertEquals(qb1.getCatching(), 3);
		assertEquals(noPosPlayer.getPos(), "still no position");
	}
}
