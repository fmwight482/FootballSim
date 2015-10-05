package FootballSim;

import java.util.ArrayList;

/**
 * Class to hold a group of all players on a given team
 * @author Rick
 *
 */
public class FootballRoster {
	private ArrayList<FootballPlayer> players;
	
	public FootballRoster() {
		players = new ArrayList<FootballPlayer>();
	}
	
	/**
	 * add a player to the roster
	 * @param aPlayer
	 */
	public void addPlayer(FootballPlayer aPlayer) {
		players.add(aPlayer);
	}
	
	// add functions to handle depth charts and passing lineups 
}
