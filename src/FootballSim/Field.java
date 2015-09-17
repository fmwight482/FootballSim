package FootballSim;

public class Field {
	int gridiron[][];
	
	public Field() {
		gridiron = new int[120][53];
	}
	
	public double getDist(FieldCoordinate coord1, FieldCoordinate coord2) {
		double dist = Math.sqrt(Math.pow(coord1.getVert() - coord2.getVert(), 2) + 
				Math.pow(coord1.getHorz() - coord2.getHorz(), 2));
		return dist;
	}
	
	public void movePlayer(FieldCoordinate startPos, FieldCoordinate endPos) {
		// move the player
	}
}
