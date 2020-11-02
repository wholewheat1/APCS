package battingaverage;

public class Team {
	Player[] players;

	public Team() {

		for (int i = 0; i < 12; i++) {
			players[i] = new Player("Saman", 14);
		}
	}

	public Team(int numPlayers) {

		for (int i = 0; i < numPlayers; i++) {
			players[i] = new Player("Saman", 14);
		}
	}

	public void printTeamStats(int numPlayers) {
		for (int i = 0; i < numPlayers; i++) {
			System.out.println(players[i].getName() + " #" + players[i].getNumber() + " average >>> "
					+ players[i].getBattingAverageString());
		}
	}
}
