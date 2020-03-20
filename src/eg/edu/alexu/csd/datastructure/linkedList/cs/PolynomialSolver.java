package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.awt.Point;

public class PolynomialSolver implements IPolynomialSolver {
		DLinkedList listA = new DLinkedList() ; 
		DLinkedList	listB = new DLinkedList();
		DLinkedList	listC = new DLinkedList();
		DLinkedList	listR = new DLinkedList();
		
	public boolean checkPoly ( char poly ) {
		return !chooseList( poly ).isEmpty();
	}
	
	public void printPoints ( int[][] terms ) {
		int x;
		int y;
		for ( int i = 0 ; i < terms.length ; i++) {
			x = terms[i][0];
			y = terms[i][1];
			System.out.printf("( %d , %d )", x , y);
			if ( i!= terms.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

	public DLinkedList arrayToList ( int[][] terms ) {
		DLinkedList list = new DLinkedList ();
		for ( int i=0 ; i< terms.length ; i++) {
			Point data = new Point(terms [i][0], terms[i][1]);
			list.add( data );
		}
		sortList(list);
		return list;	
	}
	public int[][] listToarray(DLinkedList list){
		 int[][] arr=new int[list.size()][2];
		 for(int i =0;i<list.size();i++) {
	         Point p=(Point) list.get(i);
	          arr[i][0]=p.x;
	          arr[i][1]=p.y;
	}
		return arr;
		
	}
	public void sortList ( DLinkedList list ){
		  for (int i =0 ; i <list.size();i++ ) {
			  for (int j=0;j<list.size()-1;j++) {
			  Point p1=(Point) list.get(j);
			  Point p2=(Point) list.get(j+1);
			  if(p1.x==0 || p2.x==0) {
				  if(p1.x==0) {
					  list.remove(j);
				  }
				  else {
					  list.remove(j+1);
				  }
			  }
			  else {
	              if(p1.y<p2.y) {
		              list.set(j, p2);
		              list.set(j+1,p1);	 
	               } 
                	else if (p1.y==p2.y) {
	                	Point temp = new Point ();
		                temp.x=p1.x+p2.x;
		                temp.y=p1.y;
	                   	list.set(j, temp);
		                list.remove(j+1) ;
                   		if(temp.x==0) {
			             list.remove(j);
		                }
            	} 
          	}
	       }	  }
		  empty(list);
		  }
	public DLinkedList chooseList ( char poly) {
		
		switch (poly) {
		  case 'A':
			  return listA;
	        
	      case 'B':
	    	  return listB;
	         
	      case 'C':
	    	  return listC;
	         
	      case 'R':
	    	  return listR;
	    	 
	    }
		 return null;
	}
	public void assignList ( char poly , DLinkedList list) {
		switch (poly) {
		  case 'A':
	         listA = list;
	         return;
	      case 'B':
	    	 listB = list;
	    	 return;
	      case 'C':
	    	 listC = list;
	    	 return;
	      case 'R':
	    	 listR = list;
	    	 return;
	    }
	}
	     @Override
	     public void setPolynomial(char poly, int[][] terms) {
	 		// TODO Auto-generated method stub
	 		DLinkedList list = arrayToList(terms);
	 		assignList( poly , list);
	 	}

		@Override
		public String print(char poly) {
			String readPoly= null;
			DLinkedList list = chooseList(poly);
			readPoly = listToString ( list );
			return readPoly;
		}
		public String  listToString( DLinkedList list ) {
	    	String poly ="";
	    	Point p = (Point) list.get(0);
	    	poly+= term( p.x , p.y);
	    	for( int i = 1 ; i < list.size();i++) {
	    	    p= (Point) list.get(i);
	    	    if( p.x > 0) {
	    	    	poly+= "+" ;
	    	    }
	    	    poly+= term (p.x, p.y);
	    	}
			return poly ;	
	    }
	    
	    public String term (int coeff, int exp) {
	    	String term = "";
	    	
	    	if( coeff == 1) {
	    		term+= "";
	    	}
	    	else if ( coeff == -1) {
	    		term+= "-";
	    	}
	    	else if ( coeff == 0 ) {
	    		return "0";
	    	}
	    	else {
	    		term+= Integer.toString( coeff );
	    	}
	    	
	    	if ( exp == 0 ) {
	    	    term+= " ";
	    	}
	    	else if ( exp == 1) {
	    		term+="x ";
	    	}
	    	else {
	    		term+= "x^"+ Integer.toString(exp)+"";
	    	}
	    	
	    	return term;

	    }
		@Override
		public void clearPolynomial(char poly) {
			chooseList(poly).clear();
		}

		@Override
		public float evaluatePolynomial(char poly, float value) {
			DLinkedList list=chooseList( poly );
			float sum=0;
			for(int i=0;i<list.size();i++) {
				Point p = (Point) list.get(i);
				sum=(float) (sum+(p.x* Math.pow(value, p.y)));
			}
			return sum;
		}

		@Override
		public int[][] add(char poly1, char poly2) {
			DLinkedList list1= chooseList( poly1 );
			DLinkedList list2= chooseList( poly2 );
			listR.clear();
	        for(int i=0;i<list1.size();i++) {
				Point p1=(Point) list1.get(i);
				listR.add(p1);
			}
			for(int j=0;j<list2.size();j++) {
				Point p2=(Point) list2.get(j);
				listR.add(p2);
			}
			sortList(listR);
			int[][] arr = listToarray(listR);
			return arr;
		}

		@Override
		public int[][] subtract(char poly1, char poly2) {
			DLinkedList list1= chooseList( poly1 );
			DLinkedList list2= chooseList( poly2 );
			listR.clear();
	        for(int i=0;i<list1.size();i++) {
				Point p1=(Point) list1.get(i);
				listR.add(p1);
			}
			for(int j=0;j<list2.size();j++) {
				Point p2=(Point) list2.get(j);
				Point p3=new Point();
				p3.x=-p2.x;
				p3.y=p2.y;
				listR.add(p3);
			}
			sortList(listR);
			int[][] arr =listToarray(listR);
			return arr;
		}
		

		@Override
		public int[][] multiply( char poly1 , char poly2 ) {
			// TODO Auto-generated method stub
			DLinkedList list1 = chooseList ( poly1 );
			DLinkedList list2 = chooseList ( poly2 );
			listR.clear();
			Point p1 ;
			Point p2 ;
			Point p3 ;
			for ( int i=0 ; i < list1.size() ; i++ ) {
				p1 = (Point) list1.get(i);
				for( int j=0 ; j < list2.size() ; j++) {
					p2= (Point) list2.get(j);
					p3 = new Point();
					p3.x = p1.x*p2.x;
					p3.y = p1.y + p2.y;
					listR.add( p3 );
				}
				
				sortList(listR);
			}
			
			int[][] arr =listToarray(listR);
			
			return arr;
		}
		public static void empty(DLinkedList list) {
			
			if (list.isEmpty()==true) {
				Point p1=new Point(0,0);
				list.add(p1);
			}
			else {
				Point temp=(Point) list.get(0);
				if(temp.x==0) {
					list.clear();
					Point p1=new Point(0,0);
					list.add(p1);
			}
		}
		
		}
}

