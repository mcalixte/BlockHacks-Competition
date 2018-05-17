package application;

import java.io.PrintWriter;
import java.util.Scanner;

public class FingerPrintNotFoundController
{
	private Scanner scan_server;
	private PrintWriter write_server;
	public void setUpNetworking(PrintWriter w, Scanner s)
	{
		scan_server = s;
		write_server = w;
	}

}
