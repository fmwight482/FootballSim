package FootballSim;

import java.util.HashMap;

/**
 * Class to keep track of where players and other entities are currently located 
 * on the playing field. 
 * @author Rick
 *
 */
public class Field {
	private int gridiron[][];
	private HashMap<FieldCoordinate, FootballPlayer> playerLocations;
	
	/**
	 * standard constructor
	 */
	public Field() {
		initializeGridiron();
		playerLocations = new HashMap<FieldCoordinate, FootballPlayer>();
	}
	
	/**
	 * initializes the gridiron integer array and fills it with zeros
	 */
	private void initializeGridiron() {
		gridiron = new int[120][53];
		
		for (int i=0; i<120; i++) {
			for (int j=0; j<53; j++) {
				gridiron[i][j] = 0;
			}
		}
	}
	
	/**
	 * place the player at the specified coordinates
	 * @param pos
	 * @param player
	 * @throws FootballException
	 */
	public void insertPlayer(FieldCoordinate pos, FootballPlayer player) throws FootballException {
		int vert = pos.getVert();
		int horz = pos.getHorz();
		
		if (vert < 0 || vert > 119 || horz < 0 || horz > 52) {
			throw new FootballException(pos.toString() + " is not a valid location");
		}
		
		int posNum = gridiron[vert][horz];
		if (posNum != 0) {
			throw new FootballException("cannot place player at coordinates " + pos.toString() + 
					" space is already occupied by player number " + posNum);
		}
		else {
			// player number should probably be a unique ID number once players are given those
			int playerNum = 1;
			gridiron[vert][horz] = playerNum;
			playerLocations.put(pos, player);
		}
	}
	
	/**
	 * Checks if there is a player at startPos and no player at endPos.
	 * If so, moves the player from startPos to endPos.
	 * @param startPos
	 * @param endPos
	 * @throws FootballException
	 */
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

			System.out.println("Moved Player from " + startPos + " to " + endPos);
		}
	}
	
	/**
	 * @param aCoord
	 * @return the football player at the given location on the field
	 */
	public FootballPlayer getPlayerAt(FieldCoordinate aCoord) throws FootballException {
		FootballPlayer player;
		if (playerLocations.containsKey(aCoord)) {
			player = playerLocations.get(aCoord);
		}
		else {
			throw new FootballException("There is no player at coordinates " + aCoord.toString());
		}
		
		return player;
	}
	
	/**
	 * @param aCoord
	 * @return the player number of the football player at the given location on the field
	 */
	public int getPlayerNumAt(FieldCoordinate aCoord) {
		int playerNum = gridiron[aCoord.getVert()][aCoord.getHorz()];
		return playerNum;
	}
	
	/**
	 * toString override
	 */
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
	
	/**
	 * prints the input value if the tile is unoccupied, otherwise prints the 
	 * toString value for the occupying player
	 * @param b
	 * @param input
	 * @param vert
	 * @param horz
	 */
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
