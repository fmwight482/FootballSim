package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballTimerTest {
	FootballTimer aTimer;
	
	@Before
	public void setup() {
		aTimer = new FootballTimer();
	}

	@Test
	public void constructorTest() {
		assertNotNull(aTimer);
	}
	
	@Test
	public void getCurrentTimeTests() {
		assertEquals(aTimer.getCurrentTime(), 0);
	}
}
