package eg.edu.alexu.csd.datastructure.linkedList.cs;


import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

public class PolynomialSolverTest {
 PolynomialSolver test = new PolynomialSolver();
 DLinkedList list1= new DLinkedList();
 DLinkedList list2= new DLinkedList();
   int[][] a = {{1,3},{-2,2},{3,4}};
   int[][] b = {{2,5},{2,6},{-4,3},{0,6},{-3,4}};
   int[][] c = {{1,4},{2,3},{3,1}};
   int[][] d = {{1,1}};
	
	@Test
	void settest() {
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		list1=test.listA;
		list2=test.listB;
		Point point1=new Point (3,4);
		assertEquals(point1,list1.get(0));
		Point point2=new Point(2,6);
		assertEquals(point2,list2.get(0));
	}
	@Test
	void evaluatetest() {
	test.setPolynomial('A', a);
	float ans=(float) 0;
	assertEquals(ans,test.evaluatePolynomial('A', 0));
	 ans=(float) 2;
	 assertEquals(ans,test.evaluatePolynomial('A', 1));
	}
	@Test
	void addtest() {
		test.setPolynomial('A', a);
		test.setPolynomial('B', b);
		test.add('A','B');
		list1=test.listR;
		Point point1=new Point (2,6);
		assertEquals(point1,list1.get(0));
		float ans=(float) -1;
		 assertEquals(ans,test.evaluatePolynomial('R', 1));
	}
	@Test
	void substracttest() {
		test.setPolynomial('A', a);
		test.setPolynomial('C', c);
		test.subtract('A','C');
		list1=test.listR;
		Point point1=new Point (2,4);
		assertEquals(point1,list1.get(0));
		float ans=(float) 4;
		 assertEquals(ans,test.evaluatePolynomial('R', -1));
	}
	@Test
	void multiplicationtest() {
		test.setPolynomial('A', a);
		test.setPolynomial('C', d);
		test.multiply('A','C');
		list1=test.listR;
		Point point1=new Point (3,5);
		assertEquals(point1,list1.get(0));
		float ans=(float) 2;
		 assertEquals(ans,test.evaluatePolynomial('R', 1));
	}
	@Test
	void cleartest() {
		test.setPolynomial('A', a);
		test.clearPolynomial('A');
		list1=test.listA;
		assertEquals(true,list1.isEmpty());
		test.setPolynomial('B', b);
		list1=test.listB;
		assertEquals(false,list1.isEmpty());
	}
	@Test
	void printtest() {
		test.setPolynomial('A', a);
		String A = "3x^4+x^3-2x^2";
		assertEquals( A , test.print('A'));
		test.setPolynomial('B', b);
		String B = "2x^6+2x^5-3x^4-4x^3";
		assertEquals( B , test.print('B'));
		int[][] c = {{0,1},{0,4}};
		test.setPolynomial('C', c);
		String C = "0";
		assertEquals( C , test.print('C'));
		test.setPolynomial('C', d);
		String D = "x ";
		assertEquals( D , test.print('C'));
	}
	
}
