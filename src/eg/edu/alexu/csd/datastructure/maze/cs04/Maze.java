/**
* 

* <p>

* My structure used  to help you come out of maze using BFS and DFS.
* You can use it in your car if you get lose. :D  
* </p>
* @since 19-May-2016
* @author Aia Lotfy
* @version 1.0 
 */
package eg.edu.alexu.csd.datastructure.maze.cs04;

import java.awt.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs04.QueueList;
import eg.edu.alexu.csd.datastructure.stack.cs04.Stack;

/**
 * Maze class.
 * 
 * @author Aia
 */
public class Maze implements IMazeSolver {
	/**
	 * input maze to solve.
	 */
	public static char[][] input;
	/**
	 * start row 'S'.
	 */
	public static int startRow;
	/**
	 * start column 'S'.
	 */
	public static int startCol;
	/**
	 * visited positions.
	 */
	private boolean visited[][];
	/**
	 * output or final output.
	 */
	private Point[][] output;
	/**
	 * end row 'E'.
	 */
	int endRow;
	/**
	 * end column'E'.
	 */
	int endCol;
	/**
	 * num of rows.
	 */
	static int r;
	/**
	 * num of columns.
	 */
	static int c;

	/**
	 * print used in debug.
	 * 
	 * @param s
	 *            string to be printed.
	 */
	public void printDebug(String s) {
		System.out.println(s);
	}

	/**
	 * print used in debug.
	 * 
	 * @param sizy
	 *            integer to be printed.
	 */
	public void printDebugInt(int sizy) {
		System.out.println(sizy);
	}

	/**
	 * print used in debug.
	 * 
	 * @param point
	 *            point to be printed.
	 */
	public void printDebugPoint(Point point) {
		System.out.println(point);
	}

	/**
	 * readInputInputInputInput from file.
	 * 
	 * @param maze
	 *            file to readInputInputInputInput from.
	 */

	public final static void readInput(final File maze) {
		Scanner get;
		try {
			get = new Scanner(maze);
			if (!get.hasNext()) {
				get.close();
				throw new RuntimeException("Empty File");
			}
			r = get.nextInt();
			c = get.nextInt();
			int sNum = 0;
			int eNum = 0;
			get.nextLine();
			input = new char[r][c];
			for (int i = 0; i < r; i++) {
				String s = get.nextLine();
				input[i] = s.toCharArray();
				for (int j = 0; j < c; j++) {
					if (input[i][j] == 'S') {
						startRow = i;
						startCol = j;
						sNum++;
					} else if (input[i][j] == 'E') {
						eNum++;
					}
				}
			}
			get.close();
			if (sNum != 1 || eNum == 0) {
				throw new RuntimeException("Check Starts and Ends");
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("File not found!");
		}

	}

	/**
	 * check visited point.
	 * 
	 * @param rows
	 *            current row.
	 * @param column
	 *            current column.
	 * @return true if you can visit.4 false if you can't.
	 */
	private final boolean check(final int rows, final int columns) {
		if (rows < 0 || rows >= input.length | columns < 0 || columns >= input[0].length)
			return false;
		if (visited[rows][columns]) {
			return false;
		}
		if (input[rows][columns] != '.' && input[rows][columns] != 'E') {
			return false;
		}
		return true;
	}

	/**
	 * solve the maze using BFS.
	 * 
	 *
	 * @param maze
	 *            current file to get inputs from.
	 * @return 2D array representing the path if found else return null.
	 */
	@Override
	public final int[][] solveBFS(final File maze) {
		readInput(maze);
		QueueList structure = new QueueList();
		boolean found = false;
		visited = new boolean[r][c];
		output = new Point[r][c];
		structure.enqueue(new Point(startRow, startCol));
		printDebugPoint(new Point(startRow, startCol));
		Point temp;
		while (!structure.isEmpty()) {
			temp = (Point) structure.dequeue();
			printDebugPoint(temp);
			visited[temp.x][temp.y] = true;
			if (check(temp.x, temp.y - 1)) {
				output[temp.x][temp.y - 1] = temp;
				printDebugPoint(new Point(temp.x, temp.y - 1));
				structure.enqueue(new Point(temp.x, temp.y - 1));
			}
			if (check(temp.x + 1, temp.y)) {
				output[temp.x + 1][temp.y] = temp;
				printDebugPoint(new Point(temp.x + 1, temp.y));
				structure.enqueue(new Point(temp.x + 1, temp.y));
			}
			if (check(temp.x, temp.y + 1)) {
				output[temp.x][temp.y + 1] = temp;
				printDebugPoint(new Point(temp.x, temp.y + 1));
				structure.enqueue(new Point(temp.x, temp.y + 1));
			}
			if (check(temp.x - 1, temp.y)) {
				output[temp.x - 1][temp.y] = temp;
				printDebugPoint(new Point(temp.x - 1, temp.y));
				structure.enqueue(new Point(temp.x - 1, temp.y));
			}
			if (input[temp.x][temp.y] == 'E') {
				endRow = temp.x;
				endCol = temp.y;
				found = true;
				break;
			}
		}
		if (!found) {
			return null;
		}
		Stack ans = new Stack();
		temp = new Point(endRow, endCol);
		printDebug("leni");
		printDebugInt(output[0].length);
		while (true) {
			ans.push(temp);
			printDebugPoint(temp);
			if (temp.x == startRow && temp.y == startCol) {
				break;
			}
			temp = output[temp.x][temp.y];
		}
		int[][] returnedArray = new int[ans.size()][2];
		int sizy = ans.size();
		printDebugInt(sizy);
		for (int i = 0; i < sizy; i++) {
			Point get = (Point) ans.pop();
			printDebugPoint(get);
			returnedArray[i][0] = get.x;
			returnedArray[i][1] = get.y;
		}
		return returnedArray;
	}

	/**
	 * solve the maze using DFS.
	 * 
	 *
	 * @param maze
	 *            current file to get inputs from.
	 * @return 2D array representing the path if found else return null.
	 */
	@Override
	public final int[][] solveDFS(final File maze) {
		readInput(maze);
		Stack structure = new Stack();
		boolean found = false;
		output = new Point[r][c];
		visited = new boolean[r][c];
		printDebugPoint(new Point(startRow, startCol));
		structure.push(new Point(startRow, startCol));
		Point temp;
		while (!structure.isEmpty()) {
			temp = (Point) structure.pop();
			printDebugPoint(temp);
			visited[temp.x][temp.y] = true;
			if (check(temp.x, temp.y - 1)) {
				output[temp.x][temp.y - 1] = temp;
				printDebugPoint(new Point(temp.x, temp.y - 1));
				structure.push(new Point(temp.x, temp.y - 1));
			}
			if (check(temp.x + 1, temp.y)) {
				output[temp.x + 1][temp.y] = temp;
				printDebugPoint(new Point(temp.x + 1, temp.y));
				structure.push(new Point(temp.x + 1, temp.y));
			}
			if (check(temp.x, temp.y + 1)) {
				output[temp.x][temp.y + 1] = temp;
				printDebugPoint(new Point(temp.x, temp.y + 1));
				structure.push(new Point(temp.x, temp.y + 1));
			}
			if (check(temp.x - 1, temp.y)) {
				output[temp.x - 1][temp.y] = temp;
				printDebugPoint(new Point(temp.x - 1, temp.y));
				structure.push(new Point(temp.x - 1, temp.y));
			}
			if (input[temp.x][temp.y] == 'E') {
				endRow = temp.x;
				endCol = temp.y;
				found = true;
				break;
			}
		}
		if (!found) {
			return null;
		}
		Stack ans = new Stack();
		temp = new Point(endRow, endCol);
		while (true) {
			ans.push(temp);
			printDebugPoint(temp);
			if (temp.x == startRow && temp.y == startCol) {
				break;
			}
			temp = output[temp.x][temp.y];
		}
		int[][] returnedArray = new int[ans.size()][2];
		int sizy = ans.size();
		printDebugInt(sizy);
		for (int i = 0; i < sizy; i++) {
			Point get = (Point) ans.pop();
			printDebugPoint(get);
			returnedArray[i][0] = get.x;
			returnedArray[i][1] = get.y;
		}
		return returnedArray;
	}

	public static void main(String[] args) {
		Maze mazy = new Maze();
		File f = new File("E:\\2nd_sem_1st_year\\Code Masri\\java projects\\maze Try\\src\\aia.txt");
		int ans[][] = mazy.solveBFS(f);
		System.out.println("Bfs");
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		
		int s[][] = mazy.solveDFS(f);
		System.out.println("Dfs");
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println();
		}
	}
}