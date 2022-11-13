package application;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.Scene; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



public class processingAgentController {

	@FXML
	private Button bt1;
	
	@FXML
	private Button bt2;
	
	@FXML
	private TextArea txt1;
	
	@FXML
	private Label lb1;
	
	private UpdaterController status1 = new UpdaterController();
	String text = "";
	String fileName = "";
	
	File selectedFile;
	File processedFile;
	File DeleteFile;
	
	public void getAcceptedOrder(ActionEvent event) throws Exception
	{	
		txt1.clear();
		txt1.setFont(Font.font("System", FontPosture.REGULAR, 12));
		FileChooser fc = new FileChooser();
		selectedFile = fc.showOpenDialog(null);
		fileName = selectedFile.getName();
		DeleteFile = selectedFile;
		if(selectedFile != null)
		{
			//lb1.setText(selectedFile.getAbsolutePath());
			text = "";
			Scanner sc = new Scanner(selectedFile);		 
		    while (sc.hasNextLine())
		    {
		      //System.out.println(sc.nextLine());
		      text = text + sc.nextLine() + "\n";   
		    }
		    
		    txt1.setText(text);
		    sc.close();
		}
		else
		{
			System.out.println("file is not valid");
		}	
	}
	public void processOrder(ActionEvent event) throws Exception
	{
		FileWriter fWriter = new FileWriter(new File(".").getAbsolutePath()+"//Processed Order//"+fileName);	
		fWriter.write(text);
		fWriter.close();
		DeleteFile.delete();
		txt1.clear();
		txt1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		txt1.setText("Processed Order is Saved. \n\n\nChoose the next Order you \n want to process.");
		status1.setStatus("Ready to Cook");
	}
}
