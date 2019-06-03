package springwebapp.test;

import static com.clc.controller.AppConstants.INCORRECT_CREDENTIALS;
import static com.clc.controller.AppConstants.LOGIN_SUCCESS;
import static com.clc.controller.AppConstants.PASSWORD_INVALID;
import static com.clc.controller.AppConstants.USERNAME_INVALID;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="testData")
	public static  Object[][] testData(){
		Object[][] data = new Object[8][3];

		data[0][0]="admin";
		data[0][1]="admin123";
		data[0][2]=LOGIN_SUCCESS;
		
		data[1][0]="";
		data[1][1]="admin123";
		data[1][2]=USERNAME_INVALID;
		
		data[2][0]=null;
		data[2][1]="admin123";
		data[2][2]=USERNAME_INVALID;

		data[3][0]="admin";
		data[3][1]="";
		data[3][2]=PASSWORD_INVALID;
		
		data[4][0]="admin";
		data[4][1]=null;
		data[4][2]=PASSWORD_INVALID;
		
		data[5][0]="admin123";
		data[5][1]="admin";
		data[5][2]=INCORRECT_CREDENTIALS;
		
		
		data[6][0]="";
		data[6][1]="";
		data[6][2]=USERNAME_INVALID;
		
		data[7][0]=null;
		data[7][1]=null;
		data[7][2]=USERNAME_INVALID;
		
		return data;
		
	}
}
