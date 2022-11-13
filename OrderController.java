package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class OrderController {

	@FXML
	private CheckBox cb1;
	@FXML
	private CheckBox cb2;
	@FXML
	private CheckBox cb3;
	@FXML
	private CheckBox cb4;
	@FXML
	private RadioButton rb1;
	@FXML
	private RadioButton rb2;
	@FXML
	private RadioButton rb3; 
	
	private static pizza pizza1 = new pizza();
	
	String pizzaType = "";
	String toppings = "";
	String orderDetail = "";

	public void SelectPizza(ActionEvent event2)  throws Exception
	{
		if(rb1.isSelected()) {
			pizzaType = "peperoni";
		}
		if(rb2.isSelected()) {
			pizzaType = "Cheese";
		}
		if(rb3.isSelected()) {
			pizzaType = "Vegitable";
		}
		if(cb1.isSelected()) {
			toppings += "Mushroom ";
		}
		if(cb2.isSelected()) {
			toppings += "Onion ";
		}
		if(cb3.isSelected()) {
			toppings += "Olives ";
		}
		if(cb4.isSelected()) {
			toppings += "Extra Cheese ";
		}
		pizza1.setPizzaType(pizzaType);
		pizza1.setPizzaTopping(toppings);
		
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Verification.fxml"));
		Scene scene = new Scene(root,400,400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();  
	}
	public String getOrderDetails() 
	{
		orderDetail = "\nPizza Type : "+ pizza1.getPizzaType(); 
		orderDetail += "\nPizza Topping : "+ pizza1.getPizzaTopping();
	    return orderDetail;
	}
}
