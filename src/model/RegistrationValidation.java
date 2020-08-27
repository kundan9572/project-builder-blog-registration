package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {
	public boolean checkUserDetails(String email, String password, String confirmPassword) {
		boolean pass= validPassword(password, confirmPassword);
		boolean emailv= validEmail(email);
		if(pass=true && emailv ==true)
			return true;
		else
			return false;
		
		
	}
	
	private boolean validPassword(String password, String confirmPassword) {
		if(password == null) {
			return false;
		}
			String regex = "^(?=.*[0-9])"
						+ "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$"; 
	        Pattern p = Pattern.compile(regex); 
	        Matcher m = p.matcher(password); 
		    boolean matchFound = m.find();
	        
	        if(password == confirmPassword)
		        return matchFound; 
	        else
	        	return false;
		
	}
	
	
	private boolean validEmail(String email) {
		
		if(email != null) {
			
			 Pattern pattern = Pattern.compile("^[a-zA-Z0-9@._]$");
			    Matcher matcher = pattern.matcher(email);
			    boolean matchFound = matcher.find();
			    return(matchFound);
			    
		}else 
			return false;
		
	   
		
	}

}
