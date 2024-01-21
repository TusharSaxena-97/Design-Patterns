package FactoryMethod;

public class Millionaire {

	public static void main( String args[])
	{
		Vehicle mycarone = VehicleFactory.createVehicle("car");
		mycarone.Running();
		
		Vehicle mybikeone = VehicleFactory.createVehicle("bike");
		mybikeone.Running();
		
		Vehicle myyathchone = VehicleFactory.createVehicle("");
		myyathchone.Running();
			
	}
}


class VehicleFactory{
	
	public static Vehicle createVehicle(String vehicleName) {
		
		if( vehicleName.toLowerCase() == "car")
			return new Car();
		if( vehicleName.toLowerCase() == "bike" )
			return new Bike();
		else return new Yatch();
	}
}



interface Vehicle{	
	public void Running();
}

class Car implements Vehicle
{

	@Override
	public void Running() {
		// TODO Auto-generated method stub
		System.out.println("Car is Running");
	}	
}

class Bike implements Vehicle
{

	@Override
	public void Running() {
		// TODO Auto-generated method stub
		System.out.println("Bike is Running");
	}	
}

class Yatch implements Vehicle
{

	@Override
	public void Running() {
		// TODO Auto-generated method stub
		System.out.println("Yatch is Running");
	}	
}