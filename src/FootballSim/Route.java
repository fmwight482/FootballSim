package FootballSim;

import java.util.LinkedList;

/**
 * Class to hold the path (route) a player will take moving from one point to another
 * @author Rick
 *
 */
public class Route {
	private LinkedList<FieldCoordinate> steps;
	
	public Route() {
		steps = new LinkedList<FieldCoordinate>();
	}
	
	public Route(Route aRoute) {
		steps = new LinkedList<FieldCoordinate>(aRoute.getSteps());
	}
	
	/**
	 * adds a (vector) coordinate denoting a new movement
	 * @param newCoord
	 */
	public void addStep(FieldCoordinate newCoord) {
		steps.add(newCoord);
	}
	
	/**
	 * @return the next movement vector on the list
	 */
	public FieldCoordinate getNextStep() {
		return steps.pop();
	}
	
	/**
	 * @return the number of distinct movement vectors in this route
	 */
	public int countSteps() {
		return steps.size();
	}
	
	public LinkedList<FieldCoordinate> getSteps() {
		return steps;
	}
	
	public void setSteps(LinkedList<FieldCoordinate> someSteps) {
		steps = new LinkedList<FieldCoordinate>(someSteps);
	}
	
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Route) {
			Route aRoute = new Route((Route)o);
			Route thisRoute = new Route(this);
			if (countSteps() == aRoute.countSteps()) {
				int numSteps = countSteps();
				for (int i=0; i<numSteps; i++) {
					if (!(aRoute.getNextStep().equals(thisRoute.getNextStep()))) {
						return false;
					}
				}
				isEqual = true;
			}
		}
		return isEqual;
	}
}
