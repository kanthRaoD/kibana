package dashboard;

public class App 
{
    public static void main( String[] args ) 
    {
    	
        SampleTest test=new SampleTest();
        System.out.println("perform login operation");
        try {
			test.login();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      //  test.fundtransfer();
      //  test.logout();
        
        
    }
}
