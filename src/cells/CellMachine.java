package cells;
import javax.swing.JFrame;
import cells.Cell;
import cells.Field;
import cells.View;
public class CellMachine {
	public static void main(String[] args) {
		
		Field field = new Field(30,30);
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				Cell cell = field.get(row, col);
				if ( Math.random() < 0.2 ) {//随机生成地图
					cell.reborn();
				}
			}
		}
		View view = new View(field);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Cells");
		frame.add(view);
		frame.pack();
		frame.setVisible(true);
		
		for ( int i=0; i<1000; i++ ) {//最高1000次
			for ( int row = 0; row<field.getHeight(); row++ ) {
				for ( int col = 0; col<field.getWidth(); col++ ) {
				/*	Cell cell = field.get(row, col);
					Cell[] neighbour = field.getNeighbour(row, col);
					int numOfLive = 0;
					for ( Cell c : neighbour ) {    //for(实例 : 要遍历的集合)
						if ( c.isAlive() ) {
							numOfLive++;
						}
					}
					*/
					Cell cell = field.get(row, col);
					int numOfLive =Field.getnum(field,row,col);
					if ( cell.isAlive() ) {
						if ( numOfLive <2 || numOfLive >3 ) {
							cell.die();
							
						}
					} else if ( numOfLive == 3 ) {
						cell.reborn();
					}
					
				}
			}
			
			frame.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}

}
