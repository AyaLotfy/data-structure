package eg.edu.alexu.csd.datastructure.linkedList.cs04;

import java.util.ArrayList;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
import eg.edu.alexu.csd.datastructure.linkedList.cs04.PolynomialClass;


public class PolyMain {
	
	static boolean exit = false;

	public static void main(String[] args) {
		PolynomialClass newPoly=new PolynomialClass() ;//created an instance from my class

		while(exit==false){
			printMenu();
			
			Scanner orderNo= new Scanner(System.in);
			Integer x = orderNo.nextInt();

			
			if(x.equals(1)){
				System.out.println("Insert the variable name: A, B or C");
				Scanner polyName= new Scanner(System.in);
				Character poly = polyName.next().charAt(0);
				poly=Character.toUpperCase(poly);
				

				
				if(poly.equals('A')){
					System.out.println("Enter number of terms to be added");
					Scanner term= new Scanner(System.in);
					Integer size = term.nextInt();
					
					int [][] toBeSent = new int [size][2];
					printInnerMenu();
					for(int i =0;i<toBeSent.length;i++){
						int order =i+1;
						System.out.println("Enter coeff of x no. "+order);
						Scanner coeffecient= new Scanner(System.in);
						Integer coeff = coeffecient.nextInt();						
						toBeSent[i][0]=coeff;
						
						System.out.println("Enter exponent of x no. "+order);
						Scanner exponent= new Scanner(System.in);
						Integer exp = exponent.nextInt();
						toBeSent[i][1]=exp;
					}
					newPoly.setPolynomial('A', toBeSent);

				}else if(poly.equals('B')){
					System.out.println("Enter number of terms to be added");
					Scanner term= new Scanner(System.in);
					Integer size = term.nextInt();
					
					int [][] toBeSent = new int [size][2];
					printInnerMenu();
					for(int i =0;i<toBeSent.length;i++){
						int order =i+1;
						System.out.println("Enter coeff of x no. "+order);
						Scanner coeffecient= new Scanner(System.in);
						Integer coeff = coeffecient.nextInt();						
						toBeSent[i][0]=coeff;
						
						System.out.println("Enter exponent of x no. "+order);
						Scanner exponent= new Scanner(System.in);
						Integer exp = exponent.nextInt();
						toBeSent[i][1]=exp;
					}
					newPoly.setPolynomial('B', toBeSent);

				}else if(poly.equals('C')){
					System.out.println("Enter number of terms to be added");
					Scanner term= new Scanner(System.in);
					Integer size = term.nextInt();
					
					int [][] toBeSent = new int [size][2];
					printInnerMenu();
					for(int i =0;i<toBeSent.length;i++){
						int order =i+1;
						System.out.println("Enter coeff of x no. "+order);
						Scanner coeffecient= new Scanner(System.in);
						Integer coeff = coeffecient.nextInt();						
						toBeSent[i][0]=coeff;
						
						System.out.println("Enter exponent of x no. "+order);
						Scanner exponent= new Scanner(System.in);
						Integer exp = exponent.nextInt();
						toBeSent[i][1]=exp;
					}
					newPoly.setPolynomial('C', toBeSent);

				}else{
					
					System.out.println("invalid input RETRY");
				}
				
			} else if (x.equals(2)){
				System.out.println("Insert the variable name: A, B, C or R");
				Scanner polyName= new Scanner(System.in);
				Character poly = polyName.next().charAt(0);
				poly=Character.toUpperCase(poly);
				
				if(poly.equals('A')){
					String printed =new String();
					printed= newPoly.print('A');
					System.out.println(printed);
					
				}else if(poly.equals('B')){
					String printed =new String();
					printed= newPoly.print('B');
					System.out.println(printed);

				}else if(poly.equals('C')){
					String printed =new String();
					printed= newPoly.print('C');
					System.out.println(printed);

				}else if(poly.equals('R')){
					String printed =new String();
					printed= newPoly.print('R');
					System.out.println(printed);

				}else{
					
					System.out.println("invalid input RETRY");
				}
				
				
			}else if (x.equals(3)){

				System.out.println("Insert the first operand variable name: A, B or C");
				Scanner polyName1= new Scanner(System.in);
				Character poly1 = polyName1.next().charAt(0);
				poly1=Character.toUpperCase(poly1);
				
				System.out.println("Insert the second operand variable name: A, B or C");
				Scanner polyName2= new Scanner(System.in);
				Character poly2 = polyName2.next().charAt(0);
				poly2=Character.toUpperCase(poly2);
				
				if(poly1.equals('A')||poly2.equals('A'))
				{
					if(poly1.equals('B')||poly2.equals('B')){
						newPoly.add ('A', 'B');
						System.out.println(newPoly.print('R'));
					}
					
					else if(poly1.equals('C')||poly2.equals('C')){
						newPoly.add ('A', 'C');
						System.out.println(newPoly.print('R'));
					}else if(poly1.equals('A')||poly2.equals('A')){
						newPoly.add ('A', 'A');
						System.out.println(newPoly.print('R'));
						
					}
					else {
						System.out.println("invalid input RETRY");
					}
				}
				else if(poly1.equals('B')||poly2.equals('B'))
				{
					if(poly1.equals('C')||poly2.equals('C')){
						newPoly.add ('B', 'C');
						System.out.println(newPoly.print('R'));

					}else if(poly1.equals('B')||poly2.equals('B')){
						newPoly.add ('B', 'B');
						System.out.println(newPoly.print('R'));

						
					}
					else {
						System.out.println("invalid input RETRY");
					}
					
				}else if(poly1.equals('C')||poly2.equals('C'))
				{
					if(poly1.equals('C')||poly2.equals('C')){
						newPoly.add ('C', 'C');
						System.out.println(newPoly.print('R'));

					}
					else {
						System.out.println("invalid input RETRY");
					}
					
				}
				else {
					System.out.println("invalid input RETRY");
				}
				
				
				
				
			}else if (x.equals(4)){

				System.out.println("Insert the first operand variable name: A, B or C");
				Scanner polyName1= new Scanner(System.in);
				Character poly1 = polyName1.next().charAt(0);
				poly1=Character.toUpperCase(poly1);
				
				System.out.println("Insert the second operand variable name: A, B or C");
				Scanner polyName2= new Scanner(System.in);
				Character poly2 = polyName2.next().charAt(0);
				poly2=Character.toUpperCase(poly2);
				
				if ((poly1.equals('A') && poly2.equals('A'))) {
					newPoly.subtract('A', 'A');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('B') && poly2.equals('B'))) {
					newPoly.subtract('B', 'B');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('C') && poly2.equals('C'))) {
					newPoly.subtract('C', 'C');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('A') && poly2.equals('B'))) {
					newPoly.subtract('A', 'B');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('B') && poly2.equals('A'))) {
					newPoly.subtract('B', 'A');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('B') && poly2.equals('C'))) {
					newPoly.subtract('B', 'C');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('C') && poly2.equals('B'))) {
					newPoly.subtract('C', 'B');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('A') && poly2.equals('C'))) {
					newPoly.subtract('A', 'C');
					System.out.println(newPoly.print('R'));

				} else if ((poly1.equals('C') && poly2.equals('A'))) {
					newPoly.subtract('C', 'A');
					System.out.println(newPoly.print('R'));

				} else {
					System.out.println("invalid input RETRY");
				}
				
			}else if (x.equals(5)){

				System.out.println("Insert the first operand variable name: A, B or C");
				Scanner polyName1= new Scanner(System.in);
				Character poly1 = polyName1.next().charAt(0);
				poly1=Character.toUpperCase(poly1);
				
				System.out.println("Insert the second operand variable name: A, B or C");
				Scanner polyName2= new Scanner(System.in);
				Character poly2 = polyName2.next().charAt(0);
				poly2=Character.toUpperCase(poly2);

				if(poly1.equals('A')||poly2.equals('A'))
				{
					if(poly1.equals('B')||poly2.equals('B')){
						newPoly.multiply ('A', 'B');//may need changes
						System.out.println(newPoly.print('R'));

					}
					
					else if(poly1.equals('C')||poly2.equals('C')){
						newPoly.multiply ('A', 'C');	//may need changes	
						System.out.println(newPoly.print('R'));

						
					}
					else if(poly1.equals('A')||poly2.equals('A')){
						newPoly.multiply ('A', 'A');//may need changes
						System.out.println(newPoly.print('R'));

					} 
					else{
						System.out.println("invalid input RETRY");
					}
				}
				else if(poly1.equals('B')||poly2.equals('B'))
				{
					if(poly1.equals('C')||poly2.equals('C')){
						newPoly.multiply ('B', 'C');	//may need changes	
						System.out.println(newPoly.print('R'));

					}
					else if(poly1.equals('B')||poly2.equals('B')){
						newPoly.multiply ('B', 'B');//may need changes
						System.out.println(newPoly.print('R'));

					}else
					{
						System.out.println("invalid input RETRY");
					}
					
				}else if(poly1.equals('C')||poly2.equals('C'))
				{
					if(poly1.equals('C')||poly2.equals('C')){
						newPoly.multiply ('C', 'C');	//may need changes	
						System.out.println(newPoly.print('R'));

					}
					else
					{
						System.out.println("invalid input RETRY");
					}
					
				}
				else {
					System.out.println("invalid input RETRY");
				}
				
				
				
				
			}else if (x.equals(6)){
				System.out.println("Insert the variable name: A, B or C");
				Scanner polyName= new Scanner(System.in);
				Character poly = polyName.next().charAt(0);
				poly=Character.toUpperCase(poly);
				System.out.println("Enter point to sub at");
				Scanner subNo= new Scanner(System.in);
				float S = subNo.nextFloat();
				
				if(poly.equals('A')){
					System.out.println(""+newPoly.evaluatePolynomial('A', S));
					
				}else if(poly.equals('B')){
					System.out.println(""+newPoly.evaluatePolynomial('B', S));
					
				}else if(poly.equals('C')){
					System.out.println(""+newPoly.evaluatePolynomial('C', S));
					
				}else{
					System.out.println("invalid input RETRY");
				}
			
			
			}else if(x.equals(7)){
				System.out.println("Insert the variable name: A, B or C");
				Scanner polyName= new Scanner(System.in);
				Character poly = polyName.next().charAt(0);
				poly=Character.toUpperCase(poly);

				if(poly.equals('A')){
					newPoly.clearPolynomial('A');
					System.out.println("A is cleared");
					
				}else if(poly.equals('B')){
					newPoly.clearPolynomial('B');
					System.out.println("B is cleared");
					
					
				}else if(poly.equals('C')){
					newPoly.clearPolynomial('C');
					System.out.println("C is cleared");
					
					
				}else{
					System.out.println("invalid input RETRY");
				}
				
			}else if (x.equals(8)){
				System.out.println("Are you sure?");
				
				
				
				Scanner Sure = new Scanner(System.in);
				Character yON =Sure.next().charAt(0);
				yON=Character.toUpperCase(yON);
				if(yON.equals('Y')){
					System.out.println("Have a nice day\nGOOD BYE");
					exit =true;

				}
				else{
					System.out.println("Continue Poly!!");

				}
				

			}else{
				System.out.println("invalid input RETRY");
			}
			
		}
			
		
		
	}
	

	
	public static void printMenu()
	{
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable");
		System.out.println("2- Print the value of a polynomial variable");
		System.out.println("3- Add two polynomials");
		System.out.println("4- Subtract two polynomials");
		System.out.println("5- Multiply two polynomials");
		System.out.println("6- Evaluate a polynomial at some point");
		System.out.println("7- Clear a polynomial variable");
		System.out.println("8- Exit the program");
		System.out.println("====================================================================");
	}
	
	public static void printInnerMenu(){
		System.out.println("Insert the polynomial terms coefficent then exponent");
	
				
	}
	

	
}
