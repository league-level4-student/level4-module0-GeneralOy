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
		Cell[] unvisitedNeigh;
		int tempX;
		int unvNeigh;
		for (int f = 0; f < 25; f++) {
			unvNeigh = 0;
			unvisitedNeigh = new Cell[4];

			/** A. mark cell as visited */
			/** B. check for unvisited neighbors using the cell */
			for (int i = -1; i < 2; i++) {
				if ((currentCell.getX() + i) < 5 && (currentCell.getX() + i) >= 0) {

					for (int j = -1; j < 2; j++) {
						if ((currentCell.getY() + j) < 5 && (currentCell.getY() + j) >= 0) {

							if ((j == 0 && i == 0) || (j == -1 && i == -1) || (j == 1 && i == 1) || (j == -1 && i == 1)
									|| (j == -1 && i == 1)) {
							} else if ((j == 0 && i == 1) || (j == 0 && i == -1) || (j == 1 && i == 0)
									|| (j == -1 && i == 0)) {
								if(maze.getCell(currentCell.getX() + i, currentCell.getY() + j).hasBeenVisited() == false) {
									unvisitedNeigh[unvNeigh] = maze.getCell(currentCell.getX() + i, currentCell.getY() + j);
									unvNeigh++;
								}
							}
						}
					}
				}
			}
		

			/** C. if has unvisited neighbors, */

			/** C1. select one at random. */
			if(unvNeigh>0) {
				tempX = randGen.nextInt(unvNeigh);
				
			/** C2. push it to the stack */
				
				for(int i = unvNeigh-1; i >= 0; i--)
				if (i != tempX) {
					uncheckedCells.push(unvisitedNeigh[i]);
				}
			Cell tempCell = unvisitedNeigh[tempX];
			if (tempCell != currentCell) {
				removeWalls(tempCell, currentCell);
			}
			currentCell.setBeenVisited(true);
			currentCell = tempCell;
			
			/** C3. remove the wall between the two cells */

			/** C4. make the new cell the current cell and mark it as visited */

			/** D. if all neighbors are visited */

			/** D1. if the stack is not empty */

			/** D1a. pop a cell from the stack */

			/** D1b. make that the current cell */

		}else if (unvNeigh == 0 && uncheckedCells.empty() == false) {
			currentCell = uncheckedCells.pop();
			
		}
		}
	}

	/**
	 * 7. Complete the remove walls method. // This method will check if c1 and c2
	 * are adjacent. // If they are, the walls between them are removed.
	 */
	private static void removeWalls(Cell c1, Cell c2) {
		for (int i = -1; i < 2; i++) {
			if (c1.getY() == c2.getY()) {
				if (c1.getX() < c2.getX()) {
					c1.setEastWall(false);
					c2.setWestWall(false);
				} else if (c1.getX() > c2.getX()) {
					c1.setWestWall(false);
					c2.setEastWall(false);
				}
			} else if (c1.getX() == c2.getX()) {
				if (c1.getY() < c2.getY()) {
					c1.setSouthWall(false);
					c2.setNorthWall(false);
				} else if (c1.getY() > c2.getY()) {
					c1.setNorthWall(false);
					c2.setSouthWall(false);
				}
			}
		}
	}

	/**
	 * 8. Complete the getUnvisitedNeighbors method Any unvisited neighbor of the
	 * passed in cell gets added to the ArrayList
	 */
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {

		return null;
	}
}