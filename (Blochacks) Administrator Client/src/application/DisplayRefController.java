package application;

import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import refugees.Refugee;

public class DisplayRefController {
	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private TextField passport;

	@FXML
	private TextField gender;

	@FXML
	private TextField address;

	@FXML
	private TextField nationality;


	@FXML
	private TextField height;

	@FXML
	private TextField phone;

	@FXML
	private TextField mail;

	@FXML
	private TextField password;

	@FXML
	private TextField center;

	@FXML
	private TextField age;

	@FXML
	private TextArea additional_info;
	@FXML
	private TextField serialNumber;
	@FXML
	private TextField ipaddress;
	@FXML
	private TextField port;
	@FXML
	private Label status;
	private PrintWriter print_server;
	private Scanner read_server;
	private Refugee refugee;
	
	public void initialize()
	{
		serialNumber.setEditable(false);
	}
	
	@FXML
	public void modifyInfo(ActionEvent event)
	{	
		Integer x = null;
		Integer y = null;
		Long z = null;
		Long serial = null;
		Refugee r1  = null;
		try
		{
			x = Integer.parseInt(age.getText());
			y = Integer.parseInt(height.getText());
			z = Long.parseLong(phone.getText());
			serial = Long.parseLong(serialNumber.getText());
			r1 = new Refugee(firstName.getText(), lastName.getText(), nationality.getText(), x, y,
					passport.getText(),
					gender.getText(),
					z,
					mail.getText(),
					address.getText(),
					password.getText(),
					serial,additional_info.getText() ,
					false);
			print_server.println("UpdateRefInfo: ");
			print_server.println(r1.toString());
			print_server.flush();
			System.out.println("Modifying");
		}
		catch(InputMismatchException e)
		{
			status.setText("Wrong Input");
		}		
	}
	@FXML
	public void transfer(ActionEvent e)
	{
		if(!ipaddress.getText().equals("") && !port.getText().equals("") && isInteger(port.getText()))
		{
			print_server.println("SendingRefugeeto: ");
			print_server.println(serialNumber.getText());
			print_server.println(ipaddress.getText());
			print_server.println(port.getText());
			print_server.flush();
			
		}
		else
		{
			status.setText("Error");
		}
	}
	
	private boolean isInteger(String x)
	{
		try 
		{
			Integer.parseInt(x);
			return true;
		}
		catch(InputMismatchException e)
		{
			return false;
		}
	}
	public void setRefugee(Refugee r)
	{
		refugee = r;
		firstName.setText(refugee.getFirst_name());
		lastName.setText(refugee.getLast_name());
		passport.setText(refugee.getPassport());
		gender.setText(refugee.getGender());
		address.setText(refugee.getLocation());
		nationality.setText(refugee.getNationality());
		height.setText(Integer.toString(refugee.getHeightCM()));
		phone.setText(Long.toString(refugee.getPhone()));
		mail.setText(r.getEmail());
		center.setText("");
		
		password.setText(refugee.getVerbal_pass());
		age.setText(Integer.toString(r.getAge()));
		serialNumber.setText(Long.toString(r.getFingerprint()));
		additional_info.setText(r.getMore_information());
		
		
		
		
	}
	public void setUpNetworking(PrintWriter print, Scanner scan)
	{
		print_server = print;
		read_server = scan;
		
	}
}
