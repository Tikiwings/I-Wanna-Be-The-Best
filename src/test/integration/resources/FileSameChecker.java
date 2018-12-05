package test.integration.resources;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileSameChecker {
	private FileSameChecker() {
		
	}
	public static boolean checkIfSameFile(String filePath1, String filePath2) {
		boolean areEqual = true;
		
		try {
			//print file path 1
			
			BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
	        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2));
	        
	        String line1 = reader1.readLine();
	        String line2 = reader2.readLine();

	        while (line1 != null || line2 != null)
	        {
	            if (line1 == null || line2 == null || !line1.equalsIgnoreCase(line2))
	            {
	                areEqual = false;   
	                break;
	            }
	            line1 = reader1.readLine();
	            line2 = reader2.readLine();
	        }
	        reader1.close();
	        reader2.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return areEqual;
	}
}
