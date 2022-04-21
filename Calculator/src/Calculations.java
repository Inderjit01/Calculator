
import java.util.Scanner;
import java.util.Stack;

public class Calculations
{

	 private Stack<Integer> stack;
	 int op1, op2;
	 
	 public Calculations()
	    { 
		 stack = new Stack<Integer>();                        
	    } // end Calculations
	 
	 /**
	  * The purpose of solve is to check the users input and depending
	  * on the input  it will go to the isOperator method or push
	  * the input into the stack. If it can't do either it will 
	  * throw the EmptyCollectionException.  
	  */
	 public int solve(String expr) throws EmptyCollectionException
	 {
		 int result = 0;
	        String token;
	        Scanner parser = new Scanner(expr);
	       
	        while (parser.hasNext())             
	        { 
	        	  token = parser.next();
		 
			 if (isOperator(token))
			 {
				try {
	             result = evaluateSingleOperator(token.charAt(0));
				} // end try
				catch (Exception e)
				{
					throw new EmptyCollectionException("stack");
				} // end catch
			 } // end if
			 
			  else
				  stack.push(new Integer(Integer.parseInt(token)));
	        } // end while
	        parser.close();
	        return result;
	 } // end solve
	
	 
	 /**
	  * The purpose of isOperator is to declare all the
	  * possible options for the operators, except for
	  * when it is an operand.
	  */
	private boolean isOperator(String token) 
	    {
	        return ( token.equals("+") || token.equals("-") ||
	        		 token.equals("*") || token.equals("/") ||
	        		 token.equals("%") || token.equals("m") ||
	        		 token.equals("r") || token.equals("d") ||
	        		 token.equals("p") || token.equals("n") ||
	        		 token.equals("f") || token.equals("c") ||
	        		 token.equals("q") || token.equals("h") ||
	        		 token.equals("?") );
	    } // end isOperator
	 /**
	  * The purpose of the method evaluateSingleOperator
	  * is to do all the operations to get the result the 
	  * user wants.
	  */
	private int evaluateSingleOperator(char operation)
	    {
	        int result = 0;
	        int print = 0;
	        switch (operation)
	        {
	            case '+': // addition
	            	op2 = (stack.pop()).intValue();
		            op1 = (stack.pop()).intValue();
	            	result = op1 + op2;
	            	stack.push(new Integer(result));
	                break;
	                
	            case '-': // subtraction
	            	op2 = (stack.pop()).intValue();
	            	op1 = (stack.pop()).intValue();
	                result = op1 - op2;
	                stack.push(new Integer(result));
	                break;
	                
	            case '*': // multiplication
	            	op2 = (stack.pop()).intValue();
	            	op1 = (stack.pop()).intValue();
	                result = op1 * op2;
	                stack.push(new Integer(result));
	                break;
	                
	            case '/': // division
	            	op2 = (stack.pop()).intValue();
	            	op1 = (stack.pop()).intValue();
	            	result = op1 / op2;
	            	stack.push(new Integer(result));
	                break;
	                
	            case '%': // modulo
	            	op2 = (stack.pop()).intValue();
	                op1 = (stack.pop()).intValue();
	            	result = op1 % op2;
	            	stack.push(new Integer(result));
	                break;  
	                
	            case 'm': // unary minus
	            	result = -(stack.pop().intValue());
	            	stack.push(new Integer(result));
	                break;    
	                
	            case 'r': // exchange top two
	            	op2 = (stack.pop()).intValue();
	                op1 = (stack.pop()).intValue();
	                stack.push(new Integer(op2));
	                stack.push(new Integer(op1));                              
	                break; 
	                
	            case 'd': // duplicate top
	                result = stack.peek().intValue();
	                stack.push(new Integer(result));
	                break; 
	                
	            case 'p': // print top
	            	print = stack.peek().intValue();
	            	System.out.println(print + "\n");
	                break;
	                
	            case 'n': // print top then remove
	            	result = stack.pop().intValue();
	            	System.out.println(result + "\n");
	                break; 
	                
	            case 'f': // display stack
	            	Stack<Integer> tempstack = new Stack<Integer>();
	            	String output = "";
	            	while (stack.size() != 0)
	            	{
	            		result = stack.pop().intValue();
	            		tempstack.push(result);
	            	} // end while
	            	while (tempstack.size() != 0)
	            	{
	            		result = tempstack.pop().intValue();
	            		output += result + " ";
	            		stack.push(result);
	            	} // end while
	            	System.out.println(output + "\n");
	                break; 
	                
	            case 'c':  // clear stack                                    
	                stack.clear();
	                break; 
	                
	            case 'q': // exit program
	            	System.out.println("The program has ended.");
	                System.exit(0);
	                break; 
	                
	            case 'h': // help menu
	            	
	            case '?':
	                System.out.println(" p Print top" +
	                                   "\n n Print top and remove" +
	                				   "\n d Duplicate top" +
	                                   "\n r Exchange top two items" +
	                                   "\n f print contents of stack" +
	                                   "\n c Clear stack" +
	                                   "\n + Add" +
	                                   "\n - Subtract" +
	                                   "\n * Multiply" +
	                                   "\n / Integer divide" +
	                                   "\n % Integer remainder" +
	                                   "\n m Unary minus" +
	                                   "\n q Quit" +
	                                   "\n h,? This help ");
	                
	        } // end switch statement
	        return result;
	    } // end evaluateSingleOperator
	
} // end Calculation
