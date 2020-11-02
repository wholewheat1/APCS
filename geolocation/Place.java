package geolocation;

public class Place {
	String name, address;
	GeoLocation location;

	public Place(String n, String a, double lati, double longi) {
		name = n;
		address = a;
		location = new GeoLocation(lati, longi);
	}

	public Place(String n, String a, GeoLocation loc) {
		name = n;
		address = a;
		loc = location;
	}

	public double distanceTo(Place other) {
		return GeoLocation.distanceTo(other.location);

	}

	public String toString() {
		return name + "\n" + address + "\nlatitude: " + GeoLocation.latitude + ", longitude: " + GeoLocation.longitude;

	}
}
