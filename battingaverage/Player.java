package battingaverage;

public class Player {
	String name;
	int number;
	int atBats;
	int hits;

	Player(String name, int number) {
		this.name = name;
		this.number = number;
		this.atBats = 0;
		this.hits = 0;
	}

	Player(String name, int number, int atBats, int hits) {
		this.name = name;
		this.number = number;
		this.atBats = atBats;
		this.hits = hits;
	}

	public double getBattingAverage() {
		return hits / (double) atBats;
	}

	public String getBattingAverageString() {
		double stringa = Math.round(getBattingAverage() * 1000);
		return "" + stringa;
	}

	public String getName() {
		return this.name;
	}

	public int getNumber() {
		return this.number;
	}

}
