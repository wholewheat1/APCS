package battingaverage;

import java.util.ArrayList;

public class ArrayListTeam {
	ArrayList<Player> players = new ArrayList<Player>();

	public ArrayListTeam() {

	}

	public void addPlayer(Player obj) {
		players.add(obj);
	}

	public void printTeamStats() {
		for (int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i).getName() + " #" + players.get(i).getNumber() + " average >>> "
					+ players.get(i).getBattingAverageString());
		}
	}

}
