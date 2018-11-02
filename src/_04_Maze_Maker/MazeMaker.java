package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class MazeMaker {

	private static int width;
	private static int height;

	private static Maze maze;

	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();

	public static Maze generateMaze(int w, int h) {
		width = w;
		height = h;
		maze = new Maze(width, height);

		/** 4. select a random cell to start */
		int randX = randGen.nextInt(width);
		int randY = randGen.nextInt(height);

		/** 5. call selectNextPath method with the randomly selected cell */
		selectNextPath(maze.getCell(randX, randY));

		return maze;
	}

	/** 6. Complete the selectNextPathMethod */
	private static void selectNextPath(Cell currentCell) {
		int[][] unvisitedNeighbors;
		int unvNeigh;
		for (int f = 0; f < 25; f++) {
			unvisitedNeighbors = new int[5][2];
			unvNeigh = 0;
			System.out.println("testo");
			
			/** A. mark cell as visited */
			currentCell.hasBeenVisited();
			/** B. check for unvisited neighbors using the cell */
			for (int i = -1; i < 2; i++) {
				if ((currentCell.getX() + i) < 5 || (currentCell.getX() + i) > -1) {
					for (int j = -1; j < 2; j++) {
						if ((currentCell.getY() + j) < 5 || (currentCell.getY() + j) > -1) {
							if ((j == 0 && i == 0) || (j == -1 && i == -1) || (j == 1 && i == 1) || (j == -1 && i == 1)
									|| (j == -1 && i == 1)) {
								
							} else {
								System.out.println("2estesto");
								unvisitedNeighbors[unvNeigh][0] = currentCell.getX() + i;
								unvisitedNeighbors[unvNeigh][1] = currentCell.getY() + j;
								unvNeigh++;
							}
						}
					}
				}
			}
			int tempX = randGen.nextInt(unvNeigh);
			if (unvNeigh > 0) {
				System.out.println("tqweesto");
				System.out.println(tempX);
				uncheckedCells.push(maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]));
				System.out.println(uncheckedCells);
				System.out.println("///////////////" + unvisitedNeighbors);
				Cell tempCell = maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]);
				removeWalls(tempCell, currentCell);
			}
			/** C. if has unvisited neighbors, */
			if (unvNeigh == 0 && uncheckedCells.empty() == false) {
				currentCell = uncheckedCells.pop();
			}
			/** C1. select one at random. */

			/** C2. push it to the stack */

			/** C3. remove the wall between the two cells */

			/** C4. make the new cell the current cell and mark it as visited */

			/** D. if all neighbors are visited */

			/** D1. if the stack is not empty */

			/** D1a. pop a cell from the stack */

			/** D1b. make that the current cell */

		//}
		}
		
}

	/*
	 * 7. Complete the remove walls method. // This method will check if c1 and c2
	 * are adjacent. // If they are, the walls between them are removed.
	 */
	private static void removeWalls(Cell c1, Cell c2) {
		System.out.println("remove wall");
		for (int i = -1; i < 2; i++) {
			if (c1.getY() == c2.getY()) {
				System.out.println("/////////////////////////////////////");
				if (c1.getX() < c2.getX()) {
					c1.setEastWall(false);
					c2.setWestWall(false);
					System.out.println("EastFalse");
				} else if (c1.getX() > c2.getX()) {
					c1.setWestWall(false);
					c2.setEastWall(false);
					System.out.println("WestFalse");
				}
			} else if (c1.getX() == c2.getX()) {
				System.out.println("/////////////ad///////////////////////");
				if (c1.getY() < c2.getY()) {
					c1.setSouthWall(false);
					c2.setNorthWall(false);
					System.out.println("SouthFalse");
				} else if (c1.getY() > c2.getY()) {
					c1.setNorthWall(false);
					c2.setSouthWall(false);
					System.out.println("NorthFalse");
				}
			}
		}
		System.out.println(c1.hasBeenVisited());
		System.out.println(c1.hasSouthWall());
		System.out.println(c1.hasNorthWall());
		System.out.println(c1.hasEastWall());
		System.out.println(c1.hasWestWall());
	}

	/*
	 * 8. Complete the getUnvisitedNeighbors method Any unvisited neighbor of the
	 * passed in cell gets added to the ArrayList
	 */
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {

		return null;
	}
}

/*if (tempCell.getY() > currentCell.getY()) {
	// uncheckedCells.pop().setNorthWall(false);

	maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]).setSouthWall(false);
	System.out.println("falseS");
} else if (tempCell.getX() > currentCell.getX()) {
	// uncheckedCells.pop().setEastWall(false);
	System.out.println("falseE");
	maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]).setEastWall(false);
} else if (tempCell.getY() < currentCell.getX()) {
	// uncheckedCells.pop().setSouthWall(false);
	System.out.println("falseW");
	maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]).setWestWall(false);
} else if (tempCell.getX() < currentCell.getY()) {
	// uncheckedCells.pop().setWestWall(false);
	System.out.println("falseN");
	maze.getCell(unvisitedNeighbors[tempX][0], unvisitedNeighbors[tempX][1]).setNorthWall(false);
}

}/**/

//if(unvNeigh != 0) {

//}else {

/** selectNextPath(maze.getCell(unvisitedNeighbors[tempX][1],
// unvisitedNeighbors[tempX][2]));
// currentCell = uncheckedCells.pop();*/