package application;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VerificationController 
{
	
	@FXML
	private TextField ASURITE;
	
	@FXML
	private Label lb5;
	
	private Student student = new Student();
	private OrderController order = new OrderController();
	private Text text1 = new Text();
	boolean check = false;
	
	int orderNumber;
	String ASURITEid = "";
	String output = "123";
	File AcceptedFile;
	

	public void checkUser(ActionEvent event3) throws Exception
	{
		ASURITEid = ASURITE.getText();
		check = this.student.CheckStudent(ASURITE.getText());	
		if(check) 
		{
			lb5.setText("ASURITE ID Verified.");
			Random rand = new Random(); 
			int orderNumber = rand.nextInt(1000);
			
			output = "Order Details: \nOrder number = "+ orderNumber;
			output += order.getOrderDetails();
			output += "\n\nStudent Details: \n";
			output += "Student Name : "+student.getStudentName();
			output += "\nASURITE id : "+student.getASURITEID();
			output += "\nemail : "+student.getEmail();
			
		    text1.CreateTextFile(output, student.getStudentName());
			
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Updater.fxml"));
			Scene scene = new Scene(root,620,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();  
			
		}
		else {
		 lb5.setText("INVALID ASURITE ID!");
		}
	}

}
