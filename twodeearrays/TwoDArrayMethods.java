package twodeearrays;

public class TwoDArrayMethods {

	// declare a 2D Array
	int[][] twoD;

	public TwoDArrayMethods() {
		// initialize the 2 D array to 10 rows and 10 columns
		// first [] is the # of rows, seconf [] is # of columns
		twoD = new int[10][10];
		fillArray();
	}

	public TwoDArrayMethods(int rows, int cols) {
		// initialize the 2 D array to 10 rows and 10 columns
		twoD = new int[rows][cols];
		fillArray();
	}

	// IMPORTANT a 2D array is an array of arrays!
	// the "name" of the 2D array is the row array that has as elements
	// arrays of the size specified by the cols
	public void printRow() {
		// What's stored in the rows?
		// a 1D array!!!
		for (int[] i : twoD)
			System.out.println(i);
	}

	// print the while array
	public void printArray() {
		// row array
		for (int r = 0; r < twoD.length; r++) {
			// column array
			for (int c = 0; c < twoD[r].length; c++) {
				System.out.print(twoD[r][c] + "\t");
			}
			System.out.println("");
		}
	}

	// return the value stored at a specific cell in the 2DArray
	public int getAt(int r, int c) {
		return twoD[r][c];
	}

	// fill array with random numbers
	public void fillArray() {
		for (int r = 0; r < twoD.length; r++)
			for (int c = 0; c < twoD[r].length; c++) {
				twoD[r][c] = (int) ((Math.random() * 100) + 1);
			}
	}

	// sum up a particular column
	public int colSum(int z) {
		int colSum = 0;
		// NOTE only one loop needed as the column is constant
		for (int r = 0; r < twoD.length; r++) {
			colSum += twoD[r][z];
			// print the column to verify the sum is correct
			System.out.println("row: " + r + " column: " + z + " value at: " + twoD[r][z]);
		}

		return colSum;
	}

	// sum up a particular column
	public int rowSum(int z) {
		int rowSum = 0;
		// NOTE only one loop needed as the row is constant
		// notice how you have to "get" the row in the for loop
		for (int c = 0; c < twoD[z].length; c++) {
			rowSum += twoD[z][c];
			// print the column to verify the sum is correct
			System.out.println("row: " + z + " column: " + c + " value at: " + twoD[z][c]);
		}

		return rowSum;
	}

	// sum up a diagonal
	// key is the pattern! you want to sum 0,0 - 1,1 - 2,2..
	// so you only need one loop!
	// NOTE: this only works on a square array...
	public int diagSum() {
		int dSum = 0;
		for (int x = 0; x < twoD.length; x++) {
			dSum += twoD[x][x];
			System.out.println("row: " + x + " column: " + x + " value at: " + twoD[x][x]);
		}
		return dSum;
	}

	// sum values in the neighbors of a cell
	// KEY - watch going out of bounds!
	public int countNeighbors(int r, int c) {
		int sum = 0;
		// add -1, 0, 1 to current r & c to get coordinates of neighbor cells.
		// One possible way: 8 combinations
		// -1, -1 | -1, 0 | -1, 1
		// ----------------------
		// 0, -1 | 0, 0* | 0, 1
		// ----------------------
		// -1, 1 | 0, 1 | 1, 1

		// if you don't want to count the cell itself, leave out the 0,0 combination

		int[] rPlus = { -1, -1, -1, 0, 0, 0, -1, 0, 1 };
		int[] cPlus = { -1, 0, 1, -1, 0, 1, 1, 1, 1 };

		// you only need one loop
		for (int z = 0; z < rPlus.length; z++) {
			// check for out of bounds!
			// out of bounds means the r & column you're trying to access is outside
			// the limits of the array
			int row = r + rPlus[z];
			int col = c + cPlus[z];
			// NOTE: use r to get the row length or else you could go out of bounds
			if (row >= 0 && row < twoD.length && col >= 0 && col < twoD[r].length) {
				sum += twoD[row][col];
				System.out.println("Row: " + row + " Column: " + col + " " + twoD[row][col] + " ");
			}
		}

		return sum;
	}

}
