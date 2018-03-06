package eg.edu.alexu.csd.datastructure.iceHockey.cs04;

//import static org.junit.Assert.assertArrayEquals;

import java.awt.Point;

//import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class Classy implements IPlayersFinder {

	String[] input1 = { "33JUBU33", "3U3O4433", "O33P44NB", "PO3NSDP3", "VNDSD333", "OINFD33X" };
	String[] input2 = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4",
			"G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
	String[] input3 = { "8D88888J8L8E888", "88NKMG8N8E8JI88", "888NS8EU88HN8EO", "LUQ888A8TH8OIH8", "888QJ88R8SG88TY",
			"88ZQV88B88OUZ8O", "FQ88WF8Q8GG88B8", "8S888HGSB8FT8S8", "8MX88D88888T8K8", "8S8A88MGVDG8XK8",
			"M88S8B8I8M88J8N", "8W88X88ZT8KA8I8", "88SQGB8I8J88W88", "U88H8NI8CZB88B8", "8PK8H8T8888TQR8" };
	String[] input4 = { "11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
	String[] snake1 = { "BBBBBBBBB", "66666666B", "BBBBBBB6B", "B66666C6B", "B6CCCCC6B", "B6CBBBC6B", "B6CCCCC6B",
			"B6666666B", "BBBBBBBBB" };
	String[] snake2 = { "BBBBBBBBB", "AAAAAAAAB", "BBBBBBBAB", "BAAAAA5AB", "BA55555AB", "BA5BBB5AB", "BA55555AB",
			"BAAAAAAAB", "BBBBBBBBB" };
	int rowsG, columnsG;
	boolean visitedPixels[][] = new boolean[50][50];
	int plus = 0;
	Point points[] = new Point[50 * 50];
	char pixels[][];
	char teamStr;
	int x, xx, y, yy;
	int area;

	public static void main(final String[] args) {
		Classy Test = new Classy();
		String[] image = { "44444H44S4", "K444K4L444", "4LJ44T44XH", "444O4VIF44", "44C4D4U444", "4V4Y4KB4M4",
				"G4W4HP4O4W", "4444ZDQ4S4", "4BR4Y4A444", "4G4V4T4444" };
		Integer team = 4;
		Integer threashold = 16;

		Point[] result = Test.findPlayers(Test.snake2, 5, threashold);
		System.out.println(result.length);
		for (int counter = 0; counter < result.length; counter++) {
			System.out.println(result[counter]);
		}

	}

	final int recursion(final int a, final int b) {
		if (a < 0 || a >= rowsG || b < 0 || b >= columnsG) {
			return 0;
		}
		area = 0;
		if (visitedPixels[a][b] == false && pixels[a][b] == teamStr) {
			area++;
			visitedPixels[a][b] = true;// forgot to mark visited
		} else {
			return 0;
		}
		if (a < x) {
			x = a;
		}
		if (a > xx) {
			xx = a;
		}
		if (b < y) {
			y = b;
		}
		if (b > yy) {
			yy = b;
		}
		area = area + recursion(a - 1, b) + recursion(a + 1, b) + recursion(a, b - 1) + recursion(a, b + 1);
		return area;
	}

	@Override
	public final Point[] findPlayers(final String[] photo, final int team, final int threshold) {

		area = 0;
		points = new Point[50 * 50];
		if (photo == null) {
			return new Point[0];
		}
		if (photo.length == 0) {
			return new Point[0];
		}
		int columns = photo[0].length();
		int rows = photo.length;
		boolean flag = false;
		if (photo.length == 0) {
			// Point null2[] = {};

			return new Point[0];
		}

		if (photo[0].length() == 0) {
			// Point null2[] = {};
			return new Point[0];
		}
		for (int i = 0; i < photo.length; i++) {
			if (photo[i] == null) {
				flag = true;
				break;
			}
		}
		if (flag == true) {
			// Point null2[] = {};
			Point[] null2 = new Point[0];
			return null2;
		}
		if (!(columns >= 1 && columns <= 50)) {
			// Point null2[] = {};
			Point[] null2 = new Point[0];
			return null2;
		}
		if (!(rows <= 50 && rows >= 1)) {
			// Point null2[] = {};
			Point[] null2 = new Point[0];
			return null2;
		}
		for (int iii = 0; iii < rows; iii++) {
			for (int jjj = 0; jjj < columns; jjj++) {
				visitedPixels[iii][jjj] = false;
			}
		}
		plus = 0;
		pixels = new char[rows][columns];
		// pixels=null;
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns; i++) {
				pixels[j][i] = 0;
			}
		}
		for (int j = 0; j < rows; j++) {
			for (int i = 0; i < columns; i++) {
				pixels[j][i] = photo[j].charAt(i);
			}
		}
		teamStr = Integer.toString(team).charAt(0);
		rowsG = rows;
		columnsG = columns;
		for (int index22 = 0; index22 < 50 * 50; index22++) {
			points[index22] = new Point();
		}
		int flagc = 0;
		for (int ii = 0; ii < rows; ii++) {
			for (int jj = 0; jj < columns; jj++) {
				if (pixels[ii][jj] == teamStr && visitedPixels[ii][jj] == false) {
					x = 500;
					xx = -1;
					y = 500;
					yy = -1;
					int area2 = recursion(ii, jj);
					if (area2 * 4 >= threshold) {
						flagc = 1;
						points[plus].x = yy + y + 1;
						points[plus].y = xx + x + 1;
						plus++;
					}
					x = 500;
					xx = -1;
					y = 500;
					yy = -1;
				}
			}
		}
		if (flagc == 0) {
			return new Point[0];
		}
		Point[] return_array = new Point[plus];
		for (int iii = 0; iii < plus; iii++) {
			return_array[iii] = points[iii];
		}

		Arrays.sort(return_array, new Comparator<Point>() {
			public int compare(final Point fPoint, final Point sPoint) {
				int xDif = Integer.compare(fPoint.x, sPoint.x);
				if (xDif == 0) {
					return Integer.compare(fPoint.y, sPoint.y);
				} else {
					return xDif;
				}
			}
		});
		return return_array;
	}
}