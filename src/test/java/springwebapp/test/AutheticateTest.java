package springwebapp.test;

import static com.clc.controller.AppConstants.INCORRECT_CREDENTIALS;
import static com.clc.controller.AppConstants.PASSWORD_INVALID;
import static com.clc.controller.AppConstants.USERNAME_INVALID;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.clc.controller.BusinessLogicController;

@Listeners(value=ReportGenerate.class)
public class AutheticateTest {
	static BusinessLogicController controller = new BusinessLogicController();

	@Test(enabled=false,alwaysRun=true,dataProvider = "testData" ,dataProviderClass=(DataProviderClass.class),dependsOnMethods="invalidCrendentials")
	public void verifyCrendentials(String unm, String pwd, String emsg) {
		String returnVal = controller.autheticateUser(unm, pwd);
		Assert.assertEquals(returnVal, emsg);
	}
	

	@Test(enabled=false,dataProvider = "testData" ,dataProviderClass=(DataProviderClass.class))
	public void invalidCrendentials() {
		String returnVal = controller.autheticateUser("asadmin", "dadmin123");
		Assert.assertEquals(returnVal, INCORRECT_CREDENTIALS);
	}

	@Test(invocationCount=3,invocationTimeOut=5)
	//in
	public void invalidUserName() {
		System.out.println("Hello..........");
		String returnVal = controller.autheticateUser(null, "admin123");
		Assert.assertEquals(returnVal, USERNAME_INVALID);

		returnVal = controller.autheticateUser("", "admin123");
		Assert.assertEquals(returnVal, USERNAME_INVALID);

		returnVal = controller.autheticateUser("asd", "admin123");
		Assert.assertEquals(returnVal, USERNAME_INVALID);

	}

	@Test(enabled = false)
	public void invalidPassword() {
		String returnVal = controller.autheticateUser("admin", null);
		Assert.assertEquals(returnVal, PASSWORD_INVALID);

		returnVal = controller.autheticateUser("admin12", "");
		Assert.assertEquals(returnVal, PASSWORD_INVALID);

		returnVal = controller.autheticateUser("aasasssd", "aa");
		Assert.assertEquals(returnVal, PASSWORD_INVALID);
	}

}
