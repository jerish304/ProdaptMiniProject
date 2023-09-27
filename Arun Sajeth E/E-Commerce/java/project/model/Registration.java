package project.model;

import java.util.Date;

public class Registration {
	
	String name;
	Date dob;
	String email;
	String phno;
	String pass;
	
	public Registration(String name, Date dob, String email, String phno, String pass) 
	{
		super();
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phno = phno;
		this.pass = pass;
	}

	public Registration() 
	{
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", dob=" + dob + ", email=" + email + ", phno=" + phno + ", pass=" + pass
				+ "]";
	}

}
