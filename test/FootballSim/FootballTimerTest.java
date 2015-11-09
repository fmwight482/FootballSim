package FootballSim;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FootballTimerTest {
	FootballTimer aTimer;
	TestEvent event1;
	TestEvent event2;
	TestEvent event3;
	TestEvent event4;
	
	@Before
	public void setup() {
		aTimer = new FootballTimer();
		event1 = new TestEvent(100);
		event2 = new TestEvent(0);
		event3 = new TestEvent(30);
	}

	@Test
	public void constructorTest() {
		assertNotNull(aTimer);
	}
	
	@Test
	public void getSetCurrentTimeTests() {
		assertEquals(0, aTimer.getCurrentTime());
		aTimer.setCurrentTime(500);
		assertEquals(500, aTimer.getCurrentTime());
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
		aTimer.addEvent(event1);
		aTimer.addEvent(event2);
		aTimer.addEvent(event3);
		assertEquals(0, aTimer.getCurrentTime());
		aTimer.getNextEvent();
		assertEquals(0, aTimer.getCurrentTime());
		assertEquals(2, aTimer.getSize());
		aTimer.getNextEvent();
		assertEquals(30, aTimer.getCurrentTime());
		assertEquals(1, aTimer.getSize());
		aTimer.getNextEvent();
		assertEquals(100, aTimer.getCurrentTime());
		assertEquals(0, aTimer.getSize());
	}
}
