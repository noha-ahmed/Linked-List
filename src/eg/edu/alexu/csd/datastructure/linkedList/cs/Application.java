package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.awt.Point;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Application  {
	static Scanner sc = new Scanner(System.in);
	static char selectM;
	static boolean exit = false;
	static boolean valid = true ;
	static char poly;
	static char poly1;
	static char poly2;
	static int r[][];
	static PolynomialSolver polySolve = new PolynomialSolver();
	
	public static void menu () {
		System.out.println("====================================================================");
		System.out.println("Please choose an action:");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("8- Exit");
		System.out.println("====================================================================");
	}
	  public static boolean checkPoly ( char selectM , char poly ){
		    if( poly == 'A' || poly == 'B'|| poly == 'C' ){
		        return true;
		    }
		    if( selectM == '2' || selectM == '6' || selectM == '7'){
		      if( poly == 'R'){
		        return true;
		      } 
		    }
		    System.out.println(" invalid input ");
		    return false;
		    
	 }
	  public static int[][] insert ()
	    {
	        int [][] arr = null;
	        int size = 0;
	        boolean done = false;
	        while (!done)
	        {
	            try
	            {
	                size = sc.nextInt();
	                done=true;
	            }
	            catch (InputMismatchException e)
	            {
	                sc.next();
	                System.out.print("That’s not an integer. Try again: ");
	            }
	        }

	        arr=new int[size][2];
	        done = false;

	        for(int i=0; i<size; i++)
	        {
	            int j=i+1;

	            while (!done)
	            {
	                try
	                {
	                    System.out.printf("Enter the coefficient of term %d :\n", j);
	                    arr[i][0]=sc.nextInt();
	                    done=true;
	                }
	                catch (InputMismatchException e)
	                {
	                    sc.next();
	                    System.out.println("That’s not an integer. Try again: ");
	                }
	                
	            }
	            done =false;
	            while (!done)
	            {
	                try
	                {
	                    System.out.printf("Enter the exponent of term %d :\n", j);
	                    arr[i][1]=sc.nextInt();
	                    done=true;
	                }
	                catch (InputMismatchException e)
	                {
	                    sc.next();
	                    System.out.print("That’s not an integer. Try again: \n");
	                }
	            }
	            done=false;
	        }
	       return arr;
	    }
	  
	public static char checkOperand1 ( ){
		do {
			System.out.println("Insert first operand variable name: A, B or C");
			poly1 = sc.next().charAt(0);
			if ( poly1 == 'M') {
				return poly1;
			}
			if( checkPoly( selectM , poly1 )) {
				if( polySolve.checkPoly(poly1)) {
					valid = true;
				}
				else {
					System.out.println(" Variable not set ");
					valid = false;
				}
			}
			else {
				valid = false;
			}
		}while( !valid );
		return poly1;	
	}
	
	public static char checkPrintEvaluate () {
		do {
			System.out.println("Insert the variable name: A, B, C or R");
			poly = sc.next().charAt(0);
			if( poly == 'M' ) {
				return poly;
			}
			if( checkPoly( selectM , poly )) {
				if( polySolve.checkPoly(poly)) {
					valid = true;
				}
				else {
					System.out.println(" Variable not set ");
					valid = false;
				}
			}
			else {
				valid = false;
			}
			
		}while( !valid );
		return poly;
	}
	
	public static char checkOperand2 ( ) {
		do {
			System.out.println("Insert second operand variable name: A, B or C");
			poly2 = sc.next().charAt(0);
			if ( poly2 == 'M') {
				return poly2;
			}
			if( checkPoly( selectM , poly2 )) {
				if( polySolve.checkPoly(poly2)) {
					valid = true;
				}
				else {
					System.out.println("Variable not set ");
					valid = false;
				}
			}
			else {
				valid = false;
			}
		}while( !valid );
		return poly2;
	}
	
	public static char checkClear() {
		do {
			System.out.println("Insert the variable name: A, B, C or R");
			poly = sc.next().charAt(0);
			if ( poly == 'M') {
				return poly;
			}
		}while( !checkPoly( selectM , poly ) );
		return poly;
	}
	
	public static char checkSet () {
		do {
			System.out.println("Insert the variable name: A, B, C ");
			poly = sc.next().charAt(0);
			if( poly == 'M') {
				return poly;
			}
			if( checkPoly( selectM , poly )) {
				if( polySolve.checkPoly(poly)) {
					System.out.println(" Variable is already set ");
					valid = false;
				}
				else {
					valid = true;
				}
			}
			else {
				valid = false;
			}
		}while( !valid );
		return poly;
	}
	
	public static void main( String[] args){
	

		/*int[][] a = {{1,3},{-2,2},{3,4}};
		int[][] b = {{2,5},{2,6},{-4,3},{0,6},{-3,4}};
		polySolve.setPolynomial('A', a);
		polySolve.setPolynomial('B', b);*/
		while ( !exit ) {
			menu();
		    selectM = sc.next().charAt(0);
			
			switch ( selectM ) {
			case '1' :
				//set poly
				System.out.println(" enter M to return to the menu");
				poly = checkSet();
				if( poly == 'M') {
					break;
				}
                System.out.println("Enter the number of terms:");
                int[][] terms = insert();
                polySolve.setPolynomial(poly,terms);
                System.out.printf("%c is set\n",poly);
                System.out.println(polySolve.print(poly));
			    break;
			case '2' :
				//print poly
				System.out.println(" enter M to return to the menu");
				poly = checkPrintEvaluate();
				if( poly == 'M') {
					break;
				}
				System.out.printf( " Value in %c :" , poly );
				System.out.println( polySolve.print(poly) );
				break;
			case '3' :
				//add
				System.out.println(" enter M to return to the menu");
				poly1 = checkOperand1();
				if( poly1 == 'M') {
					break;
				}
				poly2 = checkOperand2();
				if( poly2 == 'M') {
					break;
				}
			    r = polySolve.add(poly1, poly2);
				System.out.print("Result set in R: ");
				polySolve.printPoints(r);
				break;
			case '4' :
				//sub
				System.out.println(" enter M to return to the menu");
				poly1 = checkOperand1();
				if( poly1 == 'M') {
					break;
				}
				poly2 = checkOperand2();
				if( poly2 == 'M') {
					break;
				}
			    r = polySolve.subtract(poly1, poly2);
				System.out.print("Result set in R: ");
				polySolve.printPoints(r);
				break;
			case '5' :
				//multiplication
				System.out.println(" enter M to return to the menu");
				poly1 = checkOperand1();
				if( poly1 == 'M') {
					break;
				}
				poly2 = checkOperand2();
				if( poly2 == 'M') {
					break;
				}
			    r = polySolve.multiply(poly1, poly2);
				System.out.print("Result set in R: ");
				polySolve.printPoints(r);
				break;
			case '6' :
				//evaluate
				System.out.println(" enter M to return to the menu");
				poly = checkPrintEvaluate();
				if( poly == 'M') {
					break;
				}
				System.out.println( " enter a value:");
				float value = 0;
				boolean done=false;
				while(!done) {
				try {
				value = sc.nextFloat();
				done=true;}
				 catch (InputMismatchException e)
	            {
	                sc.next();
	                System.out.print("That’s not an integer. Try again: ");
	            }
	            }
				float res = polySolve.evaluatePolynomial(poly, value);
				System.out.printf("Evaluation of %c when x = %.2f : %.2f\n " , poly , value , res );
				break;
			case '7' :
				//clear poly
				System.out.println(" enter M to return to the menu");
				poly = checkClear();
				if( poly == 'M') {
					break;
				}
				if( polySolve.checkPoly(poly)) {
					polySolve.clearPolynomial(poly);
					System.out.printf("%c is cleared\n",poly);	
				}
				else {
					System.out.printf("%c is already empty\n",poly);
				}
				break;
			case '8' :
				// exit
				exit = true;
				break;
			default :
				System.out.println(" invalid input");	
			}
			
			
		}
		
	
	}
}
