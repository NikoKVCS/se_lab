package cells;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import cells.Cell;
public class View extends JPanel {
	private static final long serialVersionUID = -5258995676212660595L;
	private static final int GRID_SIZE = 16;
	private Field theField;
	
	public View(Field field) {
		theField = field;
	}


	public void paint(Graphics g) {//����View��̳�JPanel,paint�����Զ�ִ��
		super.paint(g);//���ø����paint����
		for ( int row = 0; row<theField.getHeight(); row++ ) {
			for ( int col = 0; col<theField.getWidth(); col++ ) {
				Cell cell = theField.get(row, col);
				if ( cell != null ) {
					cell.draw(g, col*GRID_SIZE, row*GRID_SIZE, GRID_SIZE);//����Cell�ĺ�������
				}
			}
		}
	}
	public Dimension getPreferredSize() {  //������������Ĵ�С
		return new Dimension(theField.getWidth()*GRID_SIZE+1,
				theField.getHeight()*GRID_SIZE+1);
	}  

	

}
