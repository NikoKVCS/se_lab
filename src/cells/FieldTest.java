package cells;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FieldTest {

	private Field f1;
	private Field f2;
	private Field f3;
	private Field f4;
	private Field f5;
	private Field f6;
	private Field f7;
	private Field f8;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetnum() {
		f1 = new Field (3,3);
		for ( int row = 0; row<f1.getHeight(); row++ ) {
			for ( int col = 0; col<f1.getWidth(); col++ ) {
				f1.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f1.getHeight(); row++ ) {//第一个测试用例，细胞为生，周围0个存活
			for ( int col = 0; col<f1.getWidth(); col++ ) {
				Cell cell = f1.get(row, col);
				if((row==1)&&(col==1))
				{
					cell.reborn();
				}
				else { cell.die();  }
			}
			}
	
		
		f2 = new Field (3,3);//第二个测试用例，中间为死周围0个
		for ( int row = 0; row<f2.getHeight(); row++ ) {
			for ( int col = 0; col<f2.getWidth(); col++ ) {
				f2.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f2.getHeight(); row++ ) {
			for ( int col = 0; col<f2.getWidth(); col++ ) {
				Cell cell = f2.get(row, col);
				 cell.die(); 
			}
			}
		
		
		f3 = new Field (3,3);//第三个测试用例，细胞为生，周围2个
		for ( int row = 0; row<f3.getHeight(); row++ ) {
			for ( int col = 0; col<f3.getWidth(); col++ ) {
				f3.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f3.getHeight(); row++ ) {
			for ( int col = 0; col<f3.getWidth(); col++ ) {
				Cell cell = f3.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) || (row==1)&&(col==1))
				cell.reborn();
				else {
					cell.die();
				}
			}
			}
		
		
		f4 = new Field (3,3);//第四个测试用例，细胞为死，周围2个
		for ( int row = 0; row<f4.getHeight(); row++ ) {
			for ( int col = 0; col<f4.getWidth(); col++ ) {
				f4.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f4.getHeight(); row++ ) {
			for ( int col = 0; col<f4.getWidth(); col++ ) {
				Cell cell = f4.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) )
				cell.reborn();
				else {
					cell.die();
				}
			}
			}
		
		f5 = new Field (3,3);//第五个测试用例，细胞为生，周围3个
		for ( int row = 0; row<f5.getHeight(); row++ ) {
			for ( int col = 0; col<f5.getWidth(); col++ ) {
				f5.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f5.getHeight(); row++ ) {
			for ( int col = 0; col<f5.getWidth(); col++ ) {
				Cell cell = f5.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) || (row==0)&&(col==2)
						|| (row==1)&&(col==1)  )
				cell.reborn();
				else {
					cell.die();
				}
			}
			}
		
		f6 = new Field (3,3);//第六个测试用例，细胞为死，周围3个
		for ( int row = 0; row<f6.getHeight(); row++ ) {
			for ( int col = 0; col<f6.getWidth(); col++ ) {
				f6.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f6.getHeight(); row++ ) {
			for ( int col = 0; col<f6.getWidth(); col++ ) {
				Cell cell = f6.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) || (row==0)&&(col==2) )
				cell.reborn();
				else {
					cell.die();
				}
			}
			}
		
		f7 = new Field (3,3);//第七个测试用例，细胞为生，周围4个
		for ( int row = 0; row<f7.getHeight(); row++ ) {
			for ( int col = 0; col<f7.getWidth(); col++ ) {
				f7.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f7.getHeight(); row++ ) {
			for ( int col = 0; col<f7.getWidth(); col++ ) {
				Cell cell = f7.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) || (row==0)&&(col==2) || 
						(row==1)&&(col==0)  || (row==1)&&(col==1))
				cell.reborn();
				else {
					cell.die();
				}
			}
			}

		f8 = new Field (3,3);//第八个测试用例，细胞为死，周围4个
		for ( int row = 0; row<f8.getHeight(); row++ ) {
			for ( int col = 0; col<f8.getWidth(); col++ ) {
				f8.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<f8.getHeight(); row++ ) {
			for ( int col = 0; col<f8.getWidth(); col++ ) {
				Cell cell = f8.get(row, col);
				if((row==0)&&(col==0) || (row==0)&&(col==1) || (row==0)&&(col==2) || 
						(row==1)&&(col==0) )
				cell.reborn();
				else {
					cell.die();
				}
			}
			}
		
		assertEquals(0,Field.getnum(f1,1,1));//判断调用getnum()之后的输出结果是否与预期相同
		assertEquals(0,Field.getnum(f2,1,1));
		assertEquals(2,Field.getnum(f3,1,1));
		assertEquals(2,Field.getnum(f4,1,1));
		assertEquals(3,Field.getnum(f5,1,1));
		assertEquals(3,Field.getnum(f6,1,1));
		assertEquals(4,Field.getnum(f7,1,1));
		assertEquals(4,Field.getnum(f8,1,1));
		
	}

}
