package core;

import java.util.Scanner;

public class Functions {
	
	private static int shift = -8;

	public static String encrypt(String s)
	{
		String temp = "";
		for (int i=0; i<s.length(); i++)
		{
			temp += (char) ( s.charAt(i) + shift );
		}
		return temp;
	}

	public static String decrypt(String s)
	{
		String temp = "";
		for (int i=0; i<s.length(); i++)
		{
			temp += (char) ( s.charAt(i) - shift );
		}
		return temp;
	}
	
	// unused
	public static String reverse(String s)
	{
		StringBuilder sb = new StringBuilder();
		for (int i=s.length()-1; i>=0; i--)
		{
			sb.append( s.charAt(i) );
		}
		return sb.toString();
	}

	// for testing purposes
	public static String getInput() {
		System.out.println("Enter message:\n\n");
		String temp = "";
		try ( Scanner scanner = new Scanner(System.in) ) 
		{
			while ( scanner.hasNextLine() )
			{
				temp += scanner.nextLine();
			}
			return temp;
		} 
		catch (Exception e) {e.printStackTrace();}
		return "default";
	}


}
