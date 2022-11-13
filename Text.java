package application;

import java.io.File;
import java.io.FileWriter;

public class Text {

	String Order = " ";
	String fileName = "";
	
	public void CreateTextFile(String text, String fileName1) throws Exception
	{
		fileName = fileName1+".txt";
		FileWriter fWriter = new FileWriter(new File(".").getAbsolutePath()+"//Accepted Order//"+fileName);																	
		fWriter.write(text);
		fWriter.close();
	}

}
