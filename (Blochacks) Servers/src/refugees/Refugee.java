package refugees;


import java.util.Scanner;

public class Refugee {

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getVerbal_pass() {
		return verbal_pass;
	}

	public void setVerbal_pass(String verbal_pass) {
		this.verbal_pass = verbal_pass;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeightCM() {
		return heightCM;
	}

	public void setHeightCM(int heightCM) {
		this.heightCM = heightCM;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEye_Colors() {
		return eye_Colors;
	}

	public void setEye_Colors(String eye_Colors) {
		this.eye_Colors = eye_Colors;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMore_information() {
		return more_information;
	}

	public void setMore_information(String more_information) {
		this.more_information = more_information;
	}

	public boolean isMia() {
		return mia;
	}

	public void setMia(boolean mia) {
		this.mia = mia;
	}

	public void setFingerprint(long fingerprint) {
		this.fingerprint = fingerprint;
	}


	protected String last_name;
	protected String first_name;
	protected String nationality;
	
	private long fingerprint; 

	private String verbal_pass;

	protected int age;
	protected int heightCM;
	protected String passport;

	protected String gender;
	protected String eye_Colors;


	protected long phone;
	protected String email;

	protected String location;
	
	protected String more_information;

	protected boolean mia;

	/**
	 * Default constructor that calls default constructor
	 * from object class
	 */

	public Refugee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor 
	 * for the refugee object
	 */
	public Refugee(String firstName, String lastName, String nationality, int age, int heightCM, String passport,
			String gender, long phone, String email, String location, String vPass,long fingerprint, String more_information, Boolean missing) 
	{
		super();
		this.last_name = lastName;
		this.first_name = firstName;
		this.nationality = nationality;
		this.age = age;
		this.heightCM = heightCM;
		this.passport = passport;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.location = location;
		this.verbal_pass = vPass;
		this.fingerprint = fingerprint;
		this.more_information = more_information;
		this.mia = missing;
	}

	/**
	 * Copy constructor 
	 * that reads from the input stream
	 */

	public Refugee(Scanner sc)
	{
		

		Boolean missing = false;
		

		sc.next();
		first_name = sc.nextLine(); 
		sc.next();
		last_name =sc.nextLine();
		sc.next();
		nationality = sc.nextLine();
		sc.next();
		age = sc.nextInt();
		sc.next();
		heightCM = sc.nextInt();
		sc.next();
		passport = sc.nextLine();
		sc.next();
		gender = sc.nextLine();
		sc.next();
		phone = sc.nextLong();
		sc.next();
		email =sc.nextLine();
		sc.next();
		location =sc.nextLine(); 
		sc.next();
		verbal_pass = sc.nextLine();
		sc.next();
		fingerprint = sc.nextLong();
		sc.next();
		more_information = sc.nextLine();

		
		
		
		mia = missing;

			
		
	}
	
	
	/**
	 * Getter for the fingerprint 
	 */
	public long getFingerprint()
	{
		return fingerprint;
	}
	
	
	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return   "first_name: "+first_name +"\n"+"last_name: "+ last_name +"\n"+"nationality: "+ nationality+"\n"+"age: "+age+"\n"+ "heightCM: "+heightCM+"\n"+"Passport: "+passport+"\n"+"Gender: "+gender+"\n"+"Phone: "+phone
				+"\n"+"Email: "+email+"\n"+"Location: "+location+"\n"+"verbal_pass: "+verbal_pass+"\n"+"Fingerprint: "+fingerprint+"\n"+"Additional_information: "+more_information+ "\n";
	}


}