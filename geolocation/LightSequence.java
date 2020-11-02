package geolocation;

public class LightSequence {

	String reSeq(String seq, String seg) {
		int index = seq.indexOf(seg);
		int indexplus = seg.length();
		String newSeq = seq.substring(indexplus + index);

		return newSeq;
	}
}
