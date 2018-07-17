package com.tianywluo.util;

import com.tianywluo.entity.User;

public class VerifyUtil {

	public boolean isValidUsername(User user) {
		String regex = "^([a-zA-Z0-9]{3,20})$";
		boolean isValid = user.getUsername().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidPassword(User user) {
		String regex = "^([\\uFF00-\\uFFFF\\u0000-\\u00FF]{3,32})$";
		boolean isValid = user.getPassword().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidRealname(User user) {
		String regex = "^([\\u4E00-\\u9FA5]{2,4})$";
		boolean isValid = user.getRealname().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidIdCard(User user) {
		String regex = "^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9X]$";
		boolean isValid = user.getIdCard().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidEmail(User user) {
		String regex = "^(([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5}){1,25})$";
		boolean isValid = user.getEmail().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isValidTelephone(User user) {
		String regex = "^(((13|14|15|18|17)\\d{9}))$";
		boolean isValid = user.getTelephone().matches(regex);
		
		if (isValid) {
			return true;
		} else {
			return false;
		}
	}
	
}
