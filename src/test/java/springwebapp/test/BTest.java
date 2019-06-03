package springwebapp.test;

import static com.clc.controller.AppConstants.PASSWORD_INVALID;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.clc.controller.BusinessLogicController;

@Listeners(value = ReportGenerate.class)
public class BTest {

	static BusinessLogicController controller = new BusinessLogicController();

	@Test
	public void n1() {
		String returnVal = controller.autheticateUser("admin", null);

		Assert.assertEquals(returnVal, PASSWORD_INVALID);

		returnVal = controller.autheticateUser("admin12", "");
		Assert.assertEquals(returnVal, PASSWORD_INVALID);

		returnVal = controller.autheticateUser("aasasssd", "aa");
		Assert.assertEquals(returnVal, PASSWORD_INVALID);
	}

	@Parameters({ "ABC" })
	@Test
	public void n2(String value) {
		if (value.equals("test")) {
			System.out.println("Parameters...." + value);

		}
	}


}
