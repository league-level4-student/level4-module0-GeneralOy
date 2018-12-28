package _04_Maze_Maker;

import java.awt.Graphics;

public class Maze {
	/** 1. Create a 2D array of cells. Don't initialize it. */
	Cell[][] CellsArray;

	private int width;
	private int height;

	public Maze(int w, int h) {
		this.width = w;
		this.height = h;

		/** 2. Initialize the cells using the width and height variables */
		CellsArray = new Cell[w][h];
		/**
		 * 3. Iterate through each cell and initialize it // using i and j as the
		 * location
		 */
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				CellsArray[i][j] = new Cell(i, j);
			}
		}

	}

	/** 4. This method iterates through the cells and draws them */
	public void draw(Graphics g) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				CellsArray[i][j].draw(g);/**/
				//System.out.println(CellsArray[i][j]);

			}
		}
	}

	/** 4b. This method returns the selected cell. */
	public Cell getCell(int x, int y) {
		int cellX = (x -(x%160)/ 160);
		
		int cellY = (y -(x%160)/ 160);
		return CellsArray[cellX][cellY];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public void checkWalls(int i, int j) {
		boolean N = CellsArray[i][j].hasNorthWall();
		boolean E = CellsArray[i][j].hasEastWall();
		boolean W = CellsArray[i][j].hasWestWall();
		boolean S = CellsArray[i][j].hasSouthWall();
		System.out.println("Cell at (" + i + ", " + j + ") has;");
		System.out.println("North; " + N);
		System.out.println("East; " + E);
		System.out.println("West; " + W);
		System.out.println("South; " + S);
	}
}
