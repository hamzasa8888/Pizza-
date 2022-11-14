package application;

import java.io.File;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UpdaterController {

	@FXML
	private Label update;
	
	static String status = "Accepted";
	
	
	public void setStatus(String data)
	{
	   status = data;
	   
	}
	public void checkStatus(ActionEvent event)
	{
	   update.setText(status);
	}

}
