import java.util.Scanner;

public class RPN {

	public static void main(String[] args) {
		
		 String expression;
         int result;
         
		 Scanner console = new Scanner(System.in);
		
		 Calculations evaluator = new Calculations();
		 
		 System.out.println("Enter a valid expression, one token " +
				            "at a time with a space between each token (e.g. 5 4 + 3 2 1 - + *)");
         System.out.println("Press h or ? for help menu.");
		
		  do // This keeps allowing the user to input values until they press q
		 {
			expression = console.nextLine();
	        result = evaluator.solve(expression);
			 
		 } while (expression != "q");
		    
		    console.close();
	} // end main

}
