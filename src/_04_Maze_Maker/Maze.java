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
				if (CellsArray[i][j].hasEastWall() == true) {
					g.drawLine(i * (MazeDisplay.WIDTH / width), j * (MazeDisplay.HEIGHT / height),
							i * (MazeDisplay.WIDTH / width),
							j * (MazeDisplay.HEIGHT / height) + MazeDisplay.HEIGHT / height);
				} else {
					System.out.println("noEwall");
				}
				if (CellsArray[i][j].hasWestWall() == true) {
					g.drawLine(i * (MazeDisplay.WIDTH / width) + MazeDisplay.WIDTH / width,
							j * (MazeDisplay.HEIGHT / height),
							i * (MazeDisplay.WIDTH / width) + MazeDisplay.WIDTH / width,
							j * (MazeDisplay.HEIGHT / height) + MazeDisplay.HEIGHT / height);
				} else {
					System.out.println("noWwall");
				}
				if (CellsArray[i][j].hasSouthWall() == true) {
					g.drawLine(i * (MazeDisplay.WIDTH / width),
							j * (MazeDisplay.HEIGHT / height) + MazeDisplay.HEIGHT / height,
							i * (MazeDisplay.WIDTH / width) + MazeDisplay.WIDTH / width,
							j * (MazeDisplay.HEIGHT / height) + MazeDisplay.HEIGHT / height);
				} else {
					System.out.println("noSwall");
				}
				if (CellsArray[i][j].hasNorthWall() == true) {
					g.drawLine(i * (MazeDisplay.WIDTH / width), j * (MazeDisplay.HEIGHT / height),
							i * (MazeDisplay.WIDTH / width) + MazeDisplay.WIDTH / width,
							j * (MazeDisplay.HEIGHT / height));
				} else {
					System.out.println("noNwall");
				}
				/*g.drawRect(i * (MazeDisplay.WIDTH / width), j * (MazeDisplay.HEIGHT / height),
						MazeDisplay.WIDTH / width, MazeDisplay.HEIGHT / height);*/

			}
		}
	}

	/** 4b. This method returns the selected cell. */
	public Cell getCell(int x, int y) {
		int cellX = x / (800 / 5);
		int cellY = y / (800 / 5);

		return CellsArray[cellX][cellY];
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
