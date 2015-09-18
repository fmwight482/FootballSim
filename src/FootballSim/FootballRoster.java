package FootballSim;

import java.util.ArrayList;

public class FootballRoster {
	private ArrayList<FootballPlayer> players;
	
	public FootballRoster() {
		players = new ArrayList<FootballPlayer>();
	}
	
	public void addPlayer(FootballPlayer aPlayer) {
		players.add(aPlayer);
	}
	
	// add functions to handle depth charts and passing lineups 
}
