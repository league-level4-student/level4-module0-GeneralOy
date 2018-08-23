package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;
	
	private Timer timer;
	
	/**1. Create a 2D array of Cells. Do not initialize it.*/
	Cell[][] cellArray;
	
	/**v???????????v*/
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		/**2. Calculate the cell size.*///??????????????????
		cellSize = w/cpr;
		/**3. Initialize the cell array to the appropriate size.*///??????????????????
		cellArray = new Cell[cpr][cpr];
		/**3. Iterate through the array and initialize each cell.
		//   Don't forget to consider the cell's dimensions when 
		//   passing in the location.*///??????????????????
		for(int i = 0; i < cpr; i++) {
			for(int j = 0; j < cpr; j++) {
				cellArray[i][j] = new Cell(i*cellSize, j*cellSize, cellSize);
			}
		}
		
	}

	/**vv*/
	public void randomizeCells() {
		Random random = new Random();
		/**4. Iterate through each cell and randomly set each
		//   cell's isAlive memeber to true of false*/
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				cellArray[i][j].isAlive = random.nextBoolean();
			}
		}
		repaint();
	}
	
	/**v???????????v*/
	public void clearCells() {
		/**5. Iterate through the cells and set them all to dead.*/
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				cellArray[i][j].isAlive = false;
			}
		}
		repaint();
	}

	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	/**vv*/
	@Override
	public void paintComponent(Graphics g) {
		/**6. Iterate through the cells and draw them all*/
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				cellArray[i][j].draw(g);
			}
		}
		
		
		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	/**v???????????v*/
	//advances world one step
	public void step() {
		int numNeighbors;
		/**7. iterate through cells and get their neighbors*///??????????????????
		for(int i = 0; i < cellsPerRow; i++) {
			for(int j = 0; j < cellsPerRow; j++) {
				if(cellArray[i][j].isAlive) {
					numNeighbors = getLivingNeighbors(i,j);
					cellArray[i][j].liveOrDie(numNeighbors);
				}
			}
		}
		
		/**8. check if each cell should live or die*/
	
		
		
		
		repaint();
	}
	
	/**9. Complete the method.
	//   It returns an array list of the  8 or less neighbors of the 
	//   cell identified by x and y*/
	public int getLivingNeighbors(int x, int y){
		int numNeighborsAlive = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				if(x != 0 && y != 0) {
					if(cellArray[x+i][y+j].isAlive) {
						numNeighborsAlive++;
					}
				}
			}
		}
		return numNeighborsAlive;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int i = (e.getX()-(e.getX()%cellsPerRow))/cellsPerRow, j = (e.getY()-(e.getY()%cellsPerRow))/cellsPerRow;
		/**10. Use e.getX() and e.getY() to determine
		//    which cell is clicked. Then toggle
		//    the isAlive variable for that cell.*/
		if(cellArray[i][j].isAlive) {
			cellArray[i][j].isAlive = false;
		}else {
			cellArray[i][j].isAlive = true;
		}
		
		
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
