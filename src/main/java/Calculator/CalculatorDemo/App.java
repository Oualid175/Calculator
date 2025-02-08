package Calculator.CalculatorDemo;

import java.util.Scanner;


public class App 
{
	int a ,b ;
	
	void input(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first no :");
		this.a = sc.nextInt();
		System.out.println("Enter second no :");
		this.b = sc.nextInt();
	}
	
	int add(int a, int b) {
		return a+b;
	}
	
	int sub(int a, int b) {
		return a-b;
	}
	
	int mul(int a, int b) {
		return a*b;
	}
	
	float div(int a , int b) {
		
		return (float)a/b;
		
	}
	
    public static void main( String[] args )
    {
    	boolean exit = false;
    	do {
	        System.out.println("\nThis is Calculator App:" );
	        System.out.println("Choose Option:");
	        System.out.println("1 : Addition");
	        System.out.println("2 : Subtract");
	        System.out.println("3 : Multiply");
	        System.out.println("4 : Divide ");
	        System.out.println("5 : Exit");
	        
	        Scanner sc = new Scanner(System.in);
	        int choice = sc.nextInt();
	        
	        App app = new App();
	        
	        switch(choice) {
	        case 1 : app.input(); System.out.println("Result = "
	        							+app.add(app.a,app.b)); break;
	        case 2 : app.input(); System.out.println("Result = "
	        							+app.sub(app.a,app.b)); break;
	        case 3 : app.input(); System.out.println("Result = "
	        							+app.mul(app.a,app.b)); break;
	        case 4 : app.input(); if(app.b == 0)
	        							System.out.println("Divide by Zero");
	        						else
	        							System.out.println("Result = "
	        							+app.div(app.a,app.b)); break;
	        case 5 : exit = true; System.out.println("Exiting");break;
	        default: System.out.println("Wrong Choice!!!");
	        } 
	        
    	}while(exit == false);
    }
}