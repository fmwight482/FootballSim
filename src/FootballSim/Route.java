package FootballSim;

import java.util.LinkedList;

public class Route {
	LinkedList<FieldCoordinate> steps;
	
	public Route() {
		steps = new LinkedList<FieldCoordinate>();
	}
	
	public void addStep(FieldCoordinate newCoord) {
		steps.add(newCoord);
	}
	
	public FieldCoordinate getNextStep() {
		return steps.pop();
	}
	
	public int countSteps() {
		return steps.size();
	}
}
