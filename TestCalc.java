import java.util.*;
import java.util.Queue.*;

public class TestCalc
{

	public static void main(String []args)
	{
		String Str;
		String ch;
		String[] tok;
		double result = 0;
		
		Queue<String> q = new LinkedList<String>();
		
		while(true)
		{
			try
			{
				System.out.println("Enter the post-fix expression (tokens separated by a space) : ");
				Scanner sc = new Scanner(System.in);
				Str = sc.nextLine();
				
				tok = Str.split(" ");	//is a regular expression that splits characters separated by one space

				int ind = 0;
				
				while(ind < tok.length)
				{
					if(tok[ind].toCharArray()[tok[ind].length()-1] == '.')
						throw new IllegalArgumentException() ;
					
					q.offer(tok[ind]);
					ind++;
				}
				
				result = PfCalculator.EvaluationOfPostFixCalc(q);
			}
			
			catch(ArrayIndexOutOfBoundsException e1)
			{
				System.out.println("Error !!! Expression is missing");
				result = 0.0;
			}
			
			catch(NullPointerException e2)
			{
				System.out.println("Error !!! NULL pointer exception");
				result = 0.0;
			}
			
			catch(ClassCastException e3)
			{
				System.out.println("Error !!! Class Casting is incorrect");
				result = 0.0;
			}
			
			catch(IllegalArgumentException e4)
			{
				System.out.println("Error !!! Arguments are incorrect") ;
				result = 0.0;
			}
			
			System.out.println("Final Result : " + result);
			
			System.out.println("Do u want to continue ? (y/n) : ");
			
			ch = Validator.getString("");
			
			if(ch.equals("n") || ch.equals("N"))
				break;

		}
	
	}

}