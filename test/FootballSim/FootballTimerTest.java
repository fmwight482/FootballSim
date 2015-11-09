package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballTimerTest {
	FootballTimer aTimer;
	TestEvent event1;
	TestEvent event2;
	TestEvent event3;
	
	@Before
	public void setup() {
		aTimer = new FootballTimer();
		event1 = new TestEvent(0);
		event2 = new TestEvent(30);
		event3 = new TestEvent(100);
	}

	@Test
	public void constructorTest() {
		assertNotNull(aTimer);
	}
	
	@Test
	public void getSetCurrentTimeTests() {
		assertEquals(aTimer.getCurrentTime(), 0);
		aTimer.setCurrentTime(500);
		assertEquals(aTimer.getCurrentTime(), 500);
	}
	
	@Test
	public void addEventTest() {
		assertEquals(0, aTimer.getSize());
		aTimer.addEvent(event1);
		aTimer.addEvent(event2);
		aTimer.addEvent(event3);
		assertEquals(3, aTimer.getSize());
	}
	
	@Test
	public void getNextEventTest() {
		
	}
}
