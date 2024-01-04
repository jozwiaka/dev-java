import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.SwingUtilities;

public class Run6 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Okno();
			}
		});

		String regex = ".";
	      String input = "this is a sample \nthis is second line";
	      Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(input);
	      int count =0;
	      while(matcher.find()) {
	         count++;
	         System.out.println(matcher.group());
	      }
	      System.out.println();
	      System.out.println("Number of new line characters: \n"+count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	  String Str = new String("Welcome to Tutorialspoint.com");
//
//      System.out.print("Return Value :" );
//      System.out.println(Str.matches("(.*)Tutorialspoint(.*)"));
//
//      System.out.print("Return Value :" );
//      System.out.println(Str.matches("Tutorials"));
//
//      System.out.print("Return Value :" );
//      System.out.println(Str.matches("Welcome(.*)"));
//      
//      String s ="abc",a=s;
//      System.out.println(s+": "+(a==s)); //abc: true
//      s=s.toUpperCase();
//      System.out.println(s+": "+(a==s));//ABC: false
//      
//      String s1=new String("hello");  
//      String s2="hello";  
//      String s3=s1.intern();//returns string from pool, now it will be same as s2  
//      System.out.println(s1==s2);//false because reference variables are pointing to different instance
//      System.out.println(s2==s3);//true because reference variables are pointing to same instance 
//      
//      String[] sAr=Str.split(" ");
//      for(int i=0;i<sAr.length;i++)
//      System.out.println(sAr[i]);
//      
//		String a="abcd";
//		String b="ab"+"cd";
//		if(a==b) System.out.println("(1)-a=b");
//		b="ab";
//		b=b.concat("cd");
//		if(a==b) System.out.println("(2)-a=b");
//		b=b.intern();
//		if(a==b) System.out.println("(3)-a=b");
//		b="Xabcd".substring(1);
//		if(a==b) System.out.println("(4)-a=b");
//		b=b.intern();
//		if(a==b) System.out.println("(5)-a=b");
//		 try
//		 {
//		      int[] myNumbers = {1, 2, 3};
//		      System.out.println(myNumbers[10]);
//		 }
//		 catch (Exception e)
//		 {
//		      System.out.println("Something went wrong.");
//		 }
//
//		 try
//		 {
//		      int[] myNumbers = {1, 2, 3};
//		      System.out.println(myNumbers[10]);
//		 }
//		 catch (Exception e)
//		 {
//		      System.out.println("Something went wrong.");
//		 }
//		 finally
//		 {
//		      System.out.println("The 'try catch' is finished.");
//		 }
//
//		 
//		 checkAge(15);
//		 
//	}
//	static void checkAge(int age) {
//	    if (age < 18) {
//	      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
//	    }
//	    else {
//	      System.out.println("Access granted - You are old enough!");
//	    }
	  }
}
