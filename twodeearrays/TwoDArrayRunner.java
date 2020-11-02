package twodeearrays;

public class TwoDArrayRunner {
	public static void main(String[] args) {
		TwoDArrayMethods t = new TwoDArrayMethods();
		t.printRow();
		t.printArray();

		System.out.println(t.getAt(5, 5));

		System.out.println("\nSum a specific column " + t.colSum(5) + "\n");
		System.out.println("\nSum a specific row " + t.rowSum(5) + "\n");
		System.out.println("\nSum a diagnol " + t.diagSum() + "\n");
		System.out.println("\nadd neighbors including self at 5,5" + t.countNeighbors(5, 5) + "\n");
	}
}