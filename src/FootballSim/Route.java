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
		
	}
}
