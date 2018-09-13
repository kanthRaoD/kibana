package dashboard;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleTest {
	WebDriver driver;
	TestStatus teststatus=new TestStatus();
	ResultSender sendresult=new ResultSender();
    @Test(description = "login")
    public void login() throws InterruptedException{
    
    	teststatus.setTestClass("login");
    	Instant start = Instant.now();
    	 System.out.println(start);  
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
    	//WebDriver driver = new FirefoxDriver();
    	try{
    	driver.get("http://zero.webappsecurity.com/");
    	
    	driver.manage().window().maximize();
    	Thread.sleep(1000);
    	driver.findElement(By.id("signin_button")).click();
    	
    	driver.findElement(By.id("user_login")).sendKeys("username");
    	driver.findElement(By.id("user_password")).sendKeys("password");
    	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    	Thread.sleep(1000);
    	driver.findElement(By.name("submit")).click();
    	
    	String title=driver.getTitle();
    	System.out.println(title);
    	Instant end = Instant.now();
    	if(title.equalsIgnoreCase("zero.webappsecurity.com"))
    	{
    		Duration timeElapsed = Duration.between(end, start);
    		teststatus.setDescription("login failed");
            teststatus.setStatus("scenario failed");
            teststatus.setBrowser("Chrome");
            teststatus.setExecutionDate(timeElapsed);
            System.out.println("total duration of execution" + timeElapsed.getSeconds()+"sec");
            sendresult.send(teststatus);
    	}
    	
    	
    	
    	
    	
    	}finally{
    		//driver.close();
    	}
    	
    }

    @Test(description = "fundtransfer", dependsOnMethods = "login")
    public void fundtransfer(){
    	Instant start = Instant.now();
   	   System.out.println(start); 
    	teststatus.setTestClass("fundtransfer");
    	driver.findElement(By.id("transfer_funds_link")).click();
    	Select fromaccount=new Select(driver.findElement(By.id("tf_fromAccountId")));
    	fromaccount.selectByIndex(2);
    	Select toaccount=new Select(driver.findElement(By.id("tf_toAccountId")));
    	toaccount.selectByIndex(2);
    	
    	driver.findElement(By.id("tf_amount")).sendKeys("100");
    	driver.findElement(By.id("tf_description")).sendKeys("transfer rs 100");
    	
    	driver.findElement(By.id("btn_submit")).click();
    	driver.findElement(By.id("btn_submit")).click();
    	String title=driver.getTitle();
    	System.out.println(title);
    	Instant end = Instant.now();
    	
    	Duration timeElapsed = Duration.between(end, start);
		teststatus.setDescription("Transfer funds");
        teststatus.setStatus("scenario passed");
        teststatus.setBrowser("Chrome");
        teststatus.setExecutionDate(timeElapsed);
        System.out.println("total duration of execution" + timeElapsed.getSeconds()+"sec");
        sendresult.send(teststatus);
    	
    }
    
    
    

    
    @Test(description = "logout", dependsOnMethods = "fundtransfer")
    public void logout(){
    	Instant start = Instant.now();
    	   System.out.println(start); 
     	teststatus.setTestClass("Logout");
    	driver.findElement(By.className("icon-user")).click();
    	driver.findElement(By.id("logout_link")).click();
    	String title=driver.getTitle();
    	System.out.println(title);
    	Instant end = Instant.now();
    	
    	Duration timeElapsed = Duration.between(end, start);
		teststatus.setDescription("logout successfull");
        teststatus.setStatus("scenario passed");
        teststatus.setBrowser("Chrome");
        teststatus.setExecutionDate(timeElapsed);
        System.out.println("total duration of execution" + timeElapsed.getSeconds()+"sec");
        sendresult.send(teststatus);
        
        driver.close();
    }
}