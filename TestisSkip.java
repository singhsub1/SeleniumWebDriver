

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dd_core.TestCore;
import dd_util.CommonUtil;

public class LoginTest extends TestCore{
	
	//checking whether the test is Executable
	@BeforeTest
	public void isSkip(){
		
		if(!CommonUtil.isExecutable("LoginTest")){
			
			throw new SkipException("Skipping the test as the Runmode is No");
			
		}
		
	}
	
	@Test(dataProvider="getData")
	public void doLogin(String username,String password){
		
		driver.findElement(By.id(OR.getProperty("username"))).sendKeys(username);
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("login"))).click();
		
	}
	
	
	@DataProvider
	public static Object[][] getData(){
				 
		 
		return CommonUtil.getData("LoginTest");
		
		
	}
	
	

}
