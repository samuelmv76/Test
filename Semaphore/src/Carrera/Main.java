package Carrera;

public class Main {

	public static void main(String[] args) {
		
		Tortuga mbappe = new Tortuga();
		Tortuga tortuga2 = new Tortuga();
		Tortuga tortuga3 = new Tortuga();
		
		mbappe.start();
		tortuga2.start();
		tortuga3.start();
		
		
		try {
			
			mbappe.join();
			tortuga2.join();
			tortuga3.join();
			System.out.println("Valor final del contador: " + mbappe.getMetros());
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
