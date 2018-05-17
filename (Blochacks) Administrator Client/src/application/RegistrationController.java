package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import refugees.Refugee;

public class RegistrationController {
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
	private TextField eye;

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
	private TextArea addInfo;
	@FXML
	private TextField serialNumber;

	private PrintWriter print_server;
	private Scanner read_server;

	
	/** *
	public Refugee(String firstName, String lastName, String nationality, int age, int heightCM, String passport,
			String gender, long phone, String email, String location, String vPass,long fingerprint, String more_information, Boolean missing) 
	{
	 * 
	 */
	@FXML
	public void submit(ActionEvent event) {
		System.out.println("Submit");
		Integer x = Integer.parseInt(age.getText());
		Integer y = Integer.parseInt(height.getText());
		Long z = Long.parseLong(phone.getText());
		long serial= Long.parseLong(serialNumber.getText());
		Refugee r1 = new Refugee(firstName.getText(), lastName.getText(), nationality.getText(), x, y,
				passport.getText(), gender.getText(), z, mail.getText(), address.getText(),password.getText(),serial,addInfo.getText() ,false);
			print_server.print("CreatenewRefugee: ");
			print_server.print(r1.toString());
			print_server.flush();
			
	
	
	}
	public void setUpNetworking(Socket s) throws IOException
	{
		print_server = new PrintWriter(s.getOutputStream());
		read_server = new Scanner(s.getInputStream());
	}
}
