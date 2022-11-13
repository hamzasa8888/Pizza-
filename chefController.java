package application;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class chefController
{
	@FXML
	private Button bt1;
	
	@FXML
	private Button bt2;
	
	@FXML
	private TextArea txt1;
	
	@FXML
	private Label lb1;
	
	private Label email;
	
	private UpdaterController status1 = new UpdaterController();
	
	String text = "";
	
	File selectedFile;
	File FinishedFile;
	File DeleteFile;

	String name;
	
	public void getProcessedOrder(ActionEvent event) throws Exception
	{	
		status1.setStatus("Cooking");
		txt1.clear();
		txt1.setFont(Font.font("System", FontPosture.REGULAR, 12));
		FileChooser fc = new FileChooser();
		selectedFile = fc.showOpenDialog(null);
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
	public void makeOrderReadyToPickUp(ActionEvent event) throws Exception
	{
		status1.setStatus("Order is Ready");
		FileWriter fWriter = new FileWriter(new File(".").getAbsolutePath()+"//Finished Order//out.txt");	
		fWriter.write(text);
		fWriter.close();
		name = DeleteFile.getName();
		DeleteFile.delete();
		txt1.clear();
		txt1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		txt1.setText("Order is Now Ready \nto Pick Up. \n\n\nChoose the next Order you \n want to Cook.");
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/email.fxml"));
		Scene scene = new Scene(root,300,150);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();  
	}
	
}
