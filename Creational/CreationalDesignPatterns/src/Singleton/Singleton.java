package Singleton;

public class Singleton extends Thread{
	
	@Override
	public void run()
	{
		CEO ceo = CEO.getInstance();
		System.out.println(ceo);
	}
	
	public static void main( String args[]) throws InterruptedException
	{
		// Since the Constructor is Private we cannot create more than one CEO at a time		
		//CEO Current_CEO = new CEO();
		
		Singleton th1 = new Singleton();
		Singleton th2 = new Singleton();
		Singleton th3 = new Singleton();
		
		th1.start();
		th2.start();
		th3.start();
	}
}

class CEO{
	
	private static CEO present_ceo;
	
	private CEO(){
	}
	
	public static CEO getInstance()
	{
		if (CEO.present_ceo == null) 
			{
            // Ensure that the instance hasn't yet been
            // initialized by another thread while this one
            // has been waiting for the lock's release.

			// if we remove this Synchronized block condition, The Pattern breaks :(
				synchronized(CEO.class)
				{
		            if (CEO.present_ceo == null)
		            	CEO.present_ceo = new CEO();
				}
			}
		
    return CEO.present_ceo;
	}
}
