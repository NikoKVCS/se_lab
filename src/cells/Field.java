package cells;
import java.util.ArrayList;
import cells.Cell;
public class Field {
	private int width;
	private int height;
	private Cell[][] field;
	public Field(int width, int height) {//构造函数
		this.width = width;
		this.height = height;
		field = new Cell[height][width];
	}
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public static int getnum(Field field,int row,int col) {
		field.get(row, col);
		Cell[] neighbour = field.getNeighbour(row, col);
		int numOfLive = 0;
		for ( Cell c : neighbour ) {    //for(实例 : 要遍历的集合)
			if ( c.isAlive() ) {
				numOfLive++;
			}
		}
		return numOfLive;
		
	}
	public Cell place(int row, int col, Cell o) {    //what's this?
		Cell ret = field[row][col];
		field[row][col] = o;
		return ret;
	}
	
	public Cell get(int row, int col) {
		return field[row][col];
	}
	
	public Cell[] getNeighbour(int row, int col) {//周围八个
		ArrayList<Cell> list = new ArrayList<Cell>();//动态数组
		for ( int i=-1; i<2; i++ ) {
			for ( int j=-1; j<2; j++ ) {
				int r = row+i;
				int c = col+j;
				if ( r >-1 && r<height && c>-1 && c<width && !(r== row && c == col) ) {
					list.add(field[r][c]);
				}
			}
		}
		return list.toArray(new Cell[list.size()]);//获得数组
	}
	
	public void clear() {
		for ( int i=0; i<height; i++ ) {
			for ( int j=0; j<width; j++ ) {
				field[i][j] = null;
			}
		}
	}
}
