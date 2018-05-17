package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController 
{
	
	private Scanner scan_server;
	private PrintWriter write_server;
	
	
	
	
	
	
	@FXML
	private Label labelStatus;
	
	@FXML
	private Label ipCompletion;
	
	@FXML
	private Label portCompletion;
	
	@FXML
	private TextField ipAddress;
	
	@FXML
	private TextField port;
	
	public void login(ActionEvent ae) 
	{
		if (ipAddress.getText().equals(""))
		{
			ipCompletion.setText("Missing IP address");
			labelStatus.setText("Login failed");
		}
		if(port.getText().equals(""))
		{
			portCompletion.setText("Missing port address");
			labelStatus.setText("Login failed");
		}
		
		if(!port.getText().equals(""))
		{
			if(!isInteger(port.getText()))
			{
				portCompletion.setText("Port must be an integer");
				labelStatus.setText("Login failed");
			}
		}
		if(!ipAddress.getText().equals("") && isInteger(port.getText())&& !port.getText().equals(""))
		{	
			
			ipCompletion.setText("");
			portCompletion.setText("");
			
			
			Stage primaryStage= new Stage();
			FXMLLoader loader = new FXMLLoader(); 
			loader.setLocation(getClass().getResource("Action.fxml")); 
			Parent root;
			try {
				root = loader.load();
				Scene scene = new Scene(root);
				ActionController control = loader.<ActionController>getController();
				control.setUpNetworking(ipAddress.getText(), Integer.parseInt(port.getText()));
				if(control.isConnected())
				{
					scene.getStylesheets().add(getClass().getResource("Action.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setOnCloseRequest(Event -> System.exit(0));
					Stage st = (Stage)((Node)ae.getSource()).getScene().getWindow();
					st.close();
				}
				else
				{
					labelStatus.setText("Login failed");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		
			
		}
	}
	public static boolean isInteger(String x)
	{
		try
		{
			Integer.parseInt(x);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	
	
	
	
	
}