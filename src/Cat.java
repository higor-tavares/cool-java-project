package mypackage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cat {
	
	public static void main(String args[]) throws IOException{
	String filename = args[0];
	String line = "";
	BufferedReader in = new BufferedReader(new FileReader(filename));
	do {
		line = in.readLine();
		if(line == null) return;
		System.out.println(line);
	} while(true);
	}
}
