package geolocation;

public class main {

	public static void main(String[] args) {
		String oldSeq = "1100000111";
		LightSequence light = new LightSequence();
		GeoLocation geo = new GeoLocation(33.123961, -96.7);
		Place fisd = new Place("Frisco ISD Admin Building", "5515 Ohio Dr, Frisco, TX 75035", geo);
		Place memorial = new Place("Memorial High School", "12300 Frisco St, Frisco, TX 75033", 33.1801240,
				-96.8297159);
		System.out.println(fisd.toString());
		System.out.println(memorial.distanceTo(fisd));

		System.out.println(light.reSeq(oldSeq, "11"));
	}

}
