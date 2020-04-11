package service;

public class ValidateUserFields {
	public boolean adminlogin(String username,String password) {
			if(username.equals("1") && password.equals("1"))
					return true;
			else 
					return false;
	}

}
