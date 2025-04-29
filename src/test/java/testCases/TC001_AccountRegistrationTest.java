package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		logger.info("*****Starting TC001_AccountRegistrationTest*****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*****Clicked on MyAccount Link*****");
		hp.clickRegister();
		logger.info("*****clicked on Register LInk*****");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("*****Providing customer Details*****");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password=randomeAlphaNumeric();
		regpage.setpwd(password);
		regpage.setpwdconfirm(password);
		regpage.setchkdpolicy();
		regpage.setbtnContinue();
		
		logger.info("****validating expected message*****");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("*****Finished TC001_AccountRegistrationTest*****");
	}
	

}
