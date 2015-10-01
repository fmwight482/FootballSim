package FootballSim;

import java.util.HashMap;

public class Field {
	int gridiron[][];
	private HashMap<FieldCoordinate, FootballPlayer> playerLocations;
	
	public Field() {
		initializeGridiron();
		playerLocations = new HashMap<FieldCoordinate, FootballPlayer>();
	}
	
	private void initializeGridiron() {
		gridiron = new int[120][53];
		
		for (int i=0; i<120; i++) {
			for (int j=0; j<53; j++) {
				gridiron[i][j] = 0;
			}
		}
	}
	
	public double getDist(FieldCoordinate coord1, FieldCoordinate coord2) {
		double dist = Math.sqrt(Math.pow(coord1.getVert() - coord2.getVert(), 2) + 
				Math.pow(coord1.getHorz() - coord2.getHorz(), 2));
		return dist;
	}
	
	public void movePlayer(FieldCoordinate startPos, FieldCoordinate endPos) throws FootballException {
		int startNum = gridiron[startPos.getVert()][startPos.getHorz()];
		int endNum = gridiron[endPos.getVert()][endPos.getHorz()];
		if (startNum == 0) {
			throw new FootballException("No player at coordinates " + startPos.toString());
		}
		else if (endNum != 0) {
			throw new FootballException("Cannot move player number " + startNum + " to coordinates " + 
					endPos.toString() + ", space is already accupied by player number " + endNum);
		}
		else {
			FootballPlayer player = playerLocations.remove(startPos);
			playerLocations.put(endPos, player);
			
			gridiron[startPos.getVert()][startPos.getHorz()] = 0;
			gridiron[endPos.getVert()][endPos.getHorz()] = startNum;
		}
	}
	
	public String toString() {
		String fieldString = "blank";
		StringBuilder b = new StringBuilder();
		String eol = System.getProperty("line.separator");
		boolean secondDigit = false;
		for (int vert=0; vert<120; vert++) {
			for (int horz=0; horz<53; horz++) {
				String toAdd;
				if (horz == 0 || horz == 52) {
					toAdd = "|";
				}
				else if ((horz == 1 || horz == 51) &&
						((vert > 0 && vert < 9) || (vert > 110 && vert < 119))) {
					toAdd = "|";
				}
				else if ((vert == 0 || vert == 119 || vert == 9 || vert == 110 ||
						vert == 19 || vert == 29 || vert == 39 || vert == 49 ||
						vert == 70 || vert == 80 || vert == 90 || vert == 100) && 
						(horz > 0 && horz < 52)) {
					
					// adding yard line markers
					if (secondDigit) {
						secondDigit = false;
						toAdd = "";
					}
					else if ((horz == 6 || horz == 45) && vert > 9 && vert < 110) {
						if (vert <= 49) {
							toAdd = Integer.toString(vert - 9);
						}
						else {
							toAdd = Integer.toString(110 - vert);
						}
						secondDigit = true;
					}
					else {
						toAdd = "-";
					}
				}
				else if (vert == 59) {
					if (secondDigit) {
						secondDigit = false;
						toAdd = "";
					}
					else if (horz == 6 || horz == 45) {
						toAdd = Integer.toString(50);
						secondDigit = true;
					}
					else {
						toAdd = "_";
					}
				}
				else if ((vert == 1 || vert == 8 || vert == 111 || vert == 118) && 
						(horz > 1 && horz < 51)) {
					toAdd = "-";
				}
				else {
					toAdd = " ";
				}
				printSquare(b, toAdd, vert, horz);
			}
			b.append(eol);
		}
		
		fieldString = b.toString();
		return fieldString;
	}
	
	private void printSquare(StringBuilder b, String input, int vert, int horz) {
		if (gridiron[vert][horz] == 0) {
			b.append(input);
		}
		else {
			FieldCoordinate coord = new FieldCoordinate(vert, horz);
			String toAdd = playerLocations.get(coord).toString();
			b.append(toAdd);
		}
	}
	
	public void printField() {
		System.out.println(toString());
	}
}
