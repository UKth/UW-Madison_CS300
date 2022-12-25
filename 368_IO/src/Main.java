import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner fileIn = null;
		File f = new File("cereal.csv");

		fileIn = new Scanner(f);
		String row = "";
		while(true) {
			try{
			row = fileIn.nextLine();
			if(row == null) {
				break;
			}
			String[] values =  row.split(",");
			System.out.printf("%-40s",values[0]+"");
			for(int i = 1; i< values.length; i++) {
				System.out.printf("%-10s",values[i]+"");
			
			}
			System.out.println();
			}
			catch(Exception e){
			 break;
			}
			
		} while (row != null);
		fileIn.close();
		
	}
}
